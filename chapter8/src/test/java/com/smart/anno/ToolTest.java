package com.smart.anno;

import java.lang.reflect.Method;
import org.testng.annotations.*;
public class ToolTest {

	@Test
	public void tool() {
		Class clazz = ForumService.class;
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			NeedTest nt = method.getAnnotation(NeedTest.class);
			if (nt != null) {
				if (nt.value()) {
					System.out.println(method.getName() + "()需要测试");
				} else {
					System.out.println(method.getName() + "()不需要测试");
				}
			}
		}
	}
}
