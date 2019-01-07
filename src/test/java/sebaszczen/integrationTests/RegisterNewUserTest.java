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

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RegisterNewUserTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void user_RegisterNewUser() {
        ResponseEntity<String> registrationTemplate = testRestTemplate.getForEntity("/", String.class);
        Assertions.assertThat(registrationTemplate.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
