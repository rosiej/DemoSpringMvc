package pl.rosiejka.demospringmvc.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String displayProfile(ProfileFormDTO profileFormDTO){
        return "profile/profileFormPage";
    }
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String saveProfile(ProfileFormDTO profileFormDTO){
        System.out.println("pomyślnie zapisany profil: "+profileFormDTO);
        return "redirect:/profile";
    }
}
