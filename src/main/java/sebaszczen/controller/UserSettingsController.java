package sebaszczen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sebaszczen.domain.user.User;
import sebaszczen.service.UserService;

@RestController
@RequestMapping("/settings")
class UserSettingsController {

    @Autowired
    private UserService userService;

    @GetMapping("/{login}")
    public User getUser(@PathVariable String login) {
        return userService.getUser(login);
    }
}
