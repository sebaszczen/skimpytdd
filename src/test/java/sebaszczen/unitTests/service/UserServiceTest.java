package sebaszczen.unitTests.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import sebaszczen.domain.user.User;
import sebaszczen.domain.user.UserNotFoundException;
import sebaszczen.repository.UserRepository;
import sebaszczen.service.UserService;
import sebaszczen.service.UserServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void userService_getUser() {
        given(userRepository.findByName("sebaszczen")).willReturn(new User("Sebastian", "Kowalski"));
        User user = userService.getUser("sebaszczen");
        assertEquals(user.getName(),"Sebastian");
        assertEquals(user.getLastName(),"Kowalski");
    }

    @Test(expected = UserNotFoundException.class)
    public void userService_userNotFoundException() {
        given(userRepository.findByName("sebaszczen")).willReturn(null);
        userService.getUser("sebaszczen");
    }
}