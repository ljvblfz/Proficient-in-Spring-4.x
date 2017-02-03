package sample.mockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.smart.domain.User;
import com.smart.service.UserService;
import com.smart.service.UserServiceImpl;
import static org.mockito.Mockito.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class MockitoSampleTest {
	UserService mockUserService = mock(UserService.class);
	UserServiceImpl mockServiceImpl = mock(UserServiceImpl.class);
    @Mock User mockUser;

    @BeforeClass
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testMockInterface() {
		when(mockUserService.findUserByUserName("tom")).thenReturn(
				new User("tom", "1234"));
		doReturn(true).when(mockUserService).hasMatchUser("tom", "1234");

		User u = new User("John", "1234");
		doNothing().when(mockUserService).registerUser(u);


		User user = mockUserService.findUserByUserName("tom");
		boolean isMatch = mockUserService.hasMatchUser("tom","1234");
		mockUserService.registerUser(u);

		assertNotNull(user);
		assertEquals(user.getUserName(), "tom");
		assertEquals(isMatch, true);


		verify(mockUserService).findUserByUserName("tom");
		verify(mockUserService, times(1)).findUserByUserName("tom");
		verify(mockUserService, atLeastOnce()).findUserByUserName("tom");
		verify(mockUserService, atLeast(1)).findUserByUserName("tom");
		verify(mockUserService, atMost(1)).findUserByUserName("tom");

		verify(mockUserService).hasMatchUser("tom", "1234");
		verify(mockUserService).registerUser(u);

	}


	@Test
	public void testMockClass() {
		when(mockServiceImpl.findUserByUserName("tom")).thenReturn(new User("tom", "1234"));
		doReturn(true).when(mockServiceImpl).hasMatchUser("tom", "1234");

		User user = mockServiceImpl.findUserByUserName("tom");
		boolean isMatch = mockServiceImpl.hasMatchUser("tom","1234");
		assertNotNull(user);
		assertEquals(user.getUserName(), "tom");
		assertEquals(isMatch, true);

		verify(mockServiceImpl).findUserByUserName("tom");
		verify(mockServiceImpl).hasMatchUser("tom", "1234");
	}



	@Test
	public void testMockUser() {
		MockitoAnnotations.initMocks(mockUser);
		when(mockUser.getUserId()).thenReturn(1);
		when(mockUser.getUserName()).thenReturn("tom");
		assertEquals(mockUser.getUserId(),1);
		assertEquals(mockUser.getUserName(), "tom");
	}
	
	

}
