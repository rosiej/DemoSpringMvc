package pl.rosiejka.demospringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rosiejka.demospringmvc.profile.UserProfileSession;

import java.util.List;

@Controller
public class HomeController {

    private UserProfileSession userProfileSession;

    @Autowired
    public HomeController(UserProfileSession userProfileSession) {
        this.userProfileSession = userProfileSession;
    }

    @RequestMapping("/")
    public String home(){
        List<String> tastes = userProfileSession.getTaste();
        if (tastes.isEmpty()) {
            return "redirect:/profile";
        }
        return "redirect:/search/mixed;keywords="+String.join(",",tastes);
    }
}
