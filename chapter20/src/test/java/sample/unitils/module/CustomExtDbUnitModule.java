package sample.unitils.module;

import java.lang.reflect.Method;
import org.unitils.core.TestListener;
import org.unitils.dbunit.DbUnitModule;

public class CustomExtDbUnitModule extends DbUnitModule {
	
	@Override
	public TestListener getTestListener() {
		final TestListener listener = super.getTestListener();
		TestListener result = new TestListener() {
			@Override
			public void beforeTestSetUp(Object testObject, Method testMethod) {
				beforeTestCustomSetUp(testObject, testMethod);
				listener.beforeTestSetUp(testObject, testMethod);
			}
			@Override
			public void afterTestMethod(Object testObject, Method testMethod,
					Throwable testThrowable) {
				afterTestCustomMethod(testObject,testMethod);
				listener.afterTestMethod(testObject, testMethod, testThrowable);
			}
		};
		return result;
	}
	
	public void beforeTestCustomSetUp(Object testObject, Method testMethod){
		
	}
	
	public void afterTestCustomMethod(Object testObject, Method testMethod){
	}
	
}
