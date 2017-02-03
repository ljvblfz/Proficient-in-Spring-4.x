package com.smart.web.controller;

import com.smart.web.RegisterController;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.Test;
import org.unitils.spring.annotation.SpringBeanByType;

import static org.testng.Assert.assertNotNull;

public class RegisterControllerTest extends BaseWebTest {
	@SpringBeanByType
	private RegisterController controller;

	@Test
	public void register() throws Exception {
		request.setRequestURI("/register.html");
		request.setMethod("POST");
		request.addParameter("userName", "test"); 
		request.addParameter("password", "1234"); 

		// 向控制发起请求 
		ModelAndView mav = handlerAdapter.handle(request, response, controller);
		assertNotNull(mav);
	}
	

}
