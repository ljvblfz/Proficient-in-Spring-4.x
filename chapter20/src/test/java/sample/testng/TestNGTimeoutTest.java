package sample.testng;

import com.smart.domain.User;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class TestNGTimeoutTest {
	private User user;
	
    @BeforeMethod
    public void init() { 
    	user = new User();
        user.setUserName("admin");
    } 

	@Test(timeOut = 10)
	public void testUser(){
        assertNotNull(user);
        assertEquals( user.getUserName(),"admin");
	}
}
