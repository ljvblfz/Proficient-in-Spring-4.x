package com.smart.web.controller;

import com.smart.cons.CommonConstant;
import com.smart.domain.User;
import com.smart.web.LoginController;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.Test;
import org.unitils.spring.annotation.SpringBeanByType;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class LoginControllerTest extends BaseWebTest {
	@SpringBeanByType
	private LoginController controller;

	@Test
	public void loginCheckByMock() throws Exception {
		request.setRequestURI("/login/doLogin.html");
		request.addParameter("userName", "tom"); // ⑥ 设置请求URL及参数
		request.addParameter("password", "1234");

		// 向控制发起请求 ” /loginCheck.html”
		ModelAndView mav = handlerAdapter.handle(request, response, controller);
		User user = (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
	
		assertNotNull(mav);
		assertEquals(mav.getViewName(), "/success");
		assertNotNull(user);
		assertEquals(user.getUserName(), "tom");// ⑧ 验证返回结果
		assertEquals(user.getCredit(), 5);
	}
	

}
