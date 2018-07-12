package pl.rosiejka.demospringmvc.profile;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserProfileSession {

    private String twitterHandle;
    private String email;
    private LocalDate birthDate;
    private List<String> taste = new ArrayList<>();

    public void saveForm(ProfileFormDTO profileFormDTO) {
        this.twitterHandle = profileFormDTO.getTwitterHandle();
        this.email = profileFormDTO.getEmail();
        this.birthDate = profileFormDTO.getBirthDate();
        this.taste = profileFormDTO.getTastes();
    }

    public ProfileFormDTO toForm() {
        ProfileFormDTO profileFormDTO = new ProfileFormDTO();
        profileFormDTO.setTwitterHandle(twitterHandle);
        profileFormDTO.setEmail(email);
        profileFormDTO.setBirthDate(birthDate);
        profileFormDTO.setTastes(taste);
        return profileFormDTO;
    }
}
