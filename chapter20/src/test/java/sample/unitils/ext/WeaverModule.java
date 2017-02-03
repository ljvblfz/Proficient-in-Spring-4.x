package sample.unitils.ext;


import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.unitils.core.Module;
import org.unitils.core.TestListener;
import org.unitils.core.Unitils;
import org.unitils.spring.SpringModule;
import org.unitils.util.AnnotationUtils;
import org.unitils.util.ReflectionUtils;


import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Set;

/**
 * weaver module, two property used:  <br/>
 * weaver.wired.type: byName for byType <br/>
 * weaver.annotation.support: false or true
 *
 * @author linux_china@hotmail.com
 */
public class WeaverModule implements Module {
    /**
     * weaver manager
     */
    private WeaverManager manager;  //weave manager
    /**
     * default wire type
     */
    private int defaultWireType = AbstractBeanDefinition.AUTOWIRE_BY_NAME;

    /**
     * Initializes the module with the given configuration settings.
     *
     * @param configuration The config, not null
     */
    public void init(Properties configuration) {
        String type = configuration.getProperty("weaver.wired.type");
        defaultWireType = getAutowireType(type);
        String annotationSupport = configuration.getProperty("weaver.annotation.support");
        manager = new WeaverManager("true".equals(annotationSupport));
    }

    /**
     * Gives the module the opportunity to performs initialization that
     * can only work after all other modules have been initialized
     */
    public void afterInit() {

    }

    /**
     * Creates the test listener for this module.
     *
     * @return The test listener, not null
     */
    public TestListener getTestListener() {
        return new WeaverTestListener();
    }

    /**
     * get weave manager
     *
     * @return weave manager
     */
    public WeaverManager getManager() {
        return manager;
    }

    /**
     * get wire type
     *
     * @param type type name, only byName and byName support
     * @return int value
     */
    private int getAutowireType(String type) {
        return "byType".equals(type) ? AbstractBeanDefinition.AUTOWIRE_BY_TYPE : AbstractBeanDefinition.AUTOWIRE_BY_NAME;
    }

    /**
     * The {@link TestListener} for this module
     */
    protected class WeaverTestListener extends TestListener {
        /**
         * Invoked before any of the test in a test class are run.
         * This can be overridden to for example add test-class initialization.
         *
         * @param testObject The test class, not null
         */
        @Override
        public void afterCreateTestObject(Object testObject) {
            weavedWithContext(testObject);
        }
    }

    /**
     * weave test object
     *
     * @param testObject test object
     */
    public void weavedWithContext(Object testObject) {
        Set<Field> fields = AnnotationUtils.getFieldsAnnotatedWith(testObject.getClass(), Weaved.class);
        if (fields.size() > 0) {
            SpringModule springModule = Unitils.getInstance().getModulesRepository().getModuleOfType(SpringModule.class);
            ApplicationContext context = springModule.getApplicationContext(testObject);
            for (Field field : fields) {
                Weaved weaved = field.getAnnotation(Weaved.class);
                //wire type for weaved object
                int wireType = weaved.type().length() == 0 ? defaultWireType : getAutowireType(weaved.type());
                Object obj = manager.getWeavedObject(context, field.getType(), wireType);
                ReflectionUtils.setFieldValue(testObject, field, obj);
            }
        }
    }

}
