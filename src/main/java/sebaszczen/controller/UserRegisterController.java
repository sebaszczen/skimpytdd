package sebaszczen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sebaszczen.domain.user.UserDto;

@Controller
@RequestMapping("/")
class UserRegisterController {

    @GetMapping
    public String registrationTemplate(Model model) {
        model.addAttribute("user",new UserDto.UserBuilder().build());
        return "registrationTemplate";
    }
}
