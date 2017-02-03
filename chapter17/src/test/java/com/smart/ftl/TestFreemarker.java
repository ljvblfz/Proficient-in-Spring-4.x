package com.smart.ftl;

import com.smart.domain.User;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestFreemarker  extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Test
	public void testFillPage() throws Throwable{
		Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate("listUser.ftl");
		Map<String,List<User>> userMap = new HashMap<String,List<User>>();
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		userList.add(user1);
		userList.add(user2);
		userMap.put("userList", userList);
		String htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tpl,userMap); 
		System.out.println(htmlText);

	}

}
