package com.smart.web;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.smart.domain.User;
import com.smart.service.UserService;

@Controller
public class LoginController{
	private UserService userService;
    

	@RequestMapping(value = "/index.html")
	public String loginPage(){
		return "login";
	}
	

	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request){
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));

		boolean isValidUser = 
			   userService.hasMatchUser(user.getUserName(),
					   user.getPassword());
		if (!isValidUser) {
			return new ModelAndView("login", "error", "用户名或密码错误。");
		} else {
		   user = userService.findUserByUserName(user
					.getUserName());
			user.setLastIp(request.getLocalAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
			//ModelAndView mv = new ModelAndView("xStreamMarshallingView");
			//mv.addObject(user);
			//return mv;
		}
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
