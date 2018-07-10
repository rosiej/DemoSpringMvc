package pl.rosiejka.demospringmvc.profile;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.rosiejka.demospringmvc.date.USLocalDateFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
public class ProfileController {

    @ModelAttribute("dateFormat")
    public String localeFormat(Locale locale) {
        return USLocalDateFormatter.getPattern(locale);
    }

    @RequestMapping("/profile")
    public String displayProfile(ProfileFormDTO profileFormDTO){
        return "profile/profileFormPage";
    }
    @RequestMapping(value = "/profile",params = {"save"}, method = RequestMethod.POST)
    public String saveProfile(@Valid ProfileFormDTO profileFormDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "profile/profileFormPage";
        }
        System.out.println("pomyślnie zapisany profil: "+profileFormDTO);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/profile", params = {"addTaste"})
    public String addRow(ProfileFormDTO profileFormDTO) {
        profileFormDTO.getTastes().add(null);
        return "profile/profileFormPage";
    }

    @RequestMapping(value = "/profile", params = {"removeTaste"})
    public String removeRow(ProfileFormDTO profileFormDTO, HttpServletRequest request){
        Integer rowId= Integer.valueOf(request.getParameter("removeTaste"));
        profileFormDTO.getTastes().remove(rowId.intValue());
        return "profile/profileFormPage";

    }

}
