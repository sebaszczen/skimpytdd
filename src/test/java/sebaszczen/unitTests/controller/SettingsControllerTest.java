package sebaszczen.unitTests.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sebaszczen.controller.UserController;
import sebaszczen.domain.user.User;
import sebaszczen.domain.user.UserNotFoundException;
import sebaszczen.service.UserService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SettingsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void user_getUserDetails() throws Exception {
        given(userService.getUser(anyString())).willReturn(new User("Sebastian", "Kowalski"));

        mockMvc.perform(MockMvcRequestBuilders.get("/settings/sebaszczen")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("name").value("Sebastian"))
                .andExpect(jsonPath("lastName").value("Kowalski"));
    }

    @Test
    public void user_notFoundException() throws Exception {
        given(userService.getUser(anyString())).willThrow(new UserNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/settings/sebaszczen"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


}
