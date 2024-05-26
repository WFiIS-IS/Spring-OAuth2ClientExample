package lol.wfis.springoauth2clientexample.web.controller;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(Model model, @AuthenticationPrincipal OAuth2User user) {
        if (user != null) {
            String name = user.getAttribute("name");
            String email = user.getAttribute("email");
            model.addAttribute("name", name);
            model.addAttribute("email", email);
        }
        return "index";
    }
}
