package sample.testng;
import com.smart.domain.User;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class TestNGFixtureTest {
    private User user;

    @BeforeMethod
    private void setUp() throws Exception {
        System.out.println("在每个测试方法执行之前运行！");
        user = new User();
        user.setUserId(1);
        user.setUserName("admin");
    }

    @AfterMethod
    private void tearDown() throws Exception {
        System.out.println("在每个测试方法执行之后运行！");
        user = null;
    }

    @BeforeClass
    private  void beforeClass() throws Exception {
        System.out.println("在测试类执行第一个方法之前运行！");
    }

    @AfterClass
    private  void afterClass() throws Exception {
        System.out.println("在测试类执行最后一个方法之后运行！");
    }

    @Test
    public void testUser() {
        assertEquals("admin", user.getUserName());
        assertEquals(1, user.getUserId());
    }

    @Test
    public void testUserId() {
        assertEquals(1, user.getUserId());
    }

}
