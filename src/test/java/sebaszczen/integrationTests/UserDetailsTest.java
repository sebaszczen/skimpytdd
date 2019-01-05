package sebaszczen.integrationTests;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import sebaszczen.domain.user.User;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
public class UserDetailsTest {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void getUserDetails() {
        ResponseEntity<User> userSettings = testRestTemplate.getForEntity("/settings/Sebastian", User.class);
        Assertions.assertThat(userSettings.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(userSettings.getBody().getName()).isEqualTo("Sebastian");
        Assertions.assertThat(userSettings.getBody().getLastName()).isEqualTo("Kowalski");
    }
}
