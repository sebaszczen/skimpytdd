package sebaszczen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sebaszczen.domain.user.User;
import sebaszczen.domain.user.UserNotFoundException;
import sebaszczen.repository.UserRepository;

import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = Logger.getLogger(String.valueOf(UserServiceImpl.class));

    @Autowired
    private UserRepository userRepository;

    public User getUser(String login) {
        User user = userRepository.findByName(login);
        if (user == null) {
            LOGGER.info("user not found");
            throw new UserNotFoundException();
        }
        else{
            return user;
        }
    }
}
