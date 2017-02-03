package sample.unitils.spring;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBean;
import org.unitils.spring.annotation.SpringBeanByName;
import org.unitils.spring.annotation.SpringBeanByType;
import com.smart.service.UserService;
import static org.junit.Assert.*;

public class SimpleUserServiceTest extends BaseServiceTest {
	
	//Spring�����м���IdΪ"userService"��Bean
	@SpringBean("userService")
	private UserService userService1;
	//��Spring�����м�����UserService��ͬ���͵�Bean
	@SpringBeanByType
	private UserService userService2;
	//��Spring�����м�����userService��ͬ��Ƶ�Bean
	@SpringBeanByName
	private  UserService userService;
	
	@Test
	public void testApplicationContext(){
		assertNotNull(applicationContext);
	}
	
	@Test
	public void testUserService(){
		assertNotNull(userService);
		assertNotNull(userService1);
		assertNotNull(userService2);
		assertEquals("john123",userService.findUserByUserName("john123").getUserName());
		assertEquals("john123",userService1.findUserByUserName("john123").getUserName());
		assertEquals("john123",userService2.findUserByUserName("john123").getUserName());
	}
}
