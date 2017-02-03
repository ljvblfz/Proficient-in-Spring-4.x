package sample.testng;

import com.smart.domain.User;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class TestNGExceptionTest {
	private User user;
    @BeforeMethod
    public void init() { 
    	user = null;
    } 
    @Test(enabled = true, expectedExceptions =NullPointerException.class)
    public void testUser(){ 
    	assertNotNull(user.getUserName()); 
    } 
}
