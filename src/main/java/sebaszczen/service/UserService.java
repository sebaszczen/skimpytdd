package sebaszczen.service;

import sebaszczen.domain.user.User;

public interface UserService {
    public User getUser(String login);
}
