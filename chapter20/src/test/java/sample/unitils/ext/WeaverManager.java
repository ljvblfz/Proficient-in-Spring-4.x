package sample.unitils.ext;


import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * weaver manager
 *
 * @author linux_china@hotmail.com
 */
public class WeaverManager {
    private GenericApplicationContext context;   //weaved application context
    private boolean annotationSupport;  //annotation weaved support?

    /**
     * annotation weaved support
     * @param annotationSupport annotation support mark
     */
    public WeaverManager(boolean annotationSupport) {
        this.annotationSupport = annotationSupport;
    }

    /**
     * get weaved object for field Type
     *
     * @param applicationContext applicationContext
     * @param fieldType          field type
     * @param autoWireType       auto wire type
     * @return weaved result object
     */
    public Object getWeavedObject(ApplicationContext applicationContext, Class fieldType, int autoWireType) {
        String beanName = fieldType.getName();
        if (context == null) {                                                                  
            context = new GenericApplicationContext(applicationContext);
            if (annotationSupport) { //annotation wired
                context.registerBeanDefinition("AutowiredAnnotationBeanPostProcessor", new RootBeanDefinition(AutowiredAnnotationBeanPostProcessor.class));
            }
            context.refresh();
        }
        if (!context.containsBean(beanName)) {
            BeanDefinition definition = new RootBeanDefinition(fieldType, autoWireType,false);
            definition.setScope("prototype");
            context.registerBeanDefinition(beanName, definition);
        }
        return context.getBean(beanName);
    }

}
