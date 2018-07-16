package pl.rosiejka.demospringmvc.profile;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserProfileSession implements Serializable{

    private String twitterHandle;
    private String email;
    private LocalDate birthDate;
    private List<String> taste = new ArrayList<>();

    private URL picturePath;

    public Resource getPicturePath() {
        return picturePath == null ? null : new UrlResource(picturePath);
    }

    public void setPicturePath(Resource picturePath) throws IOException {
        this.picturePath = picturePath.getURL();
    }

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

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getTaste() {
        return taste;
    }
}
