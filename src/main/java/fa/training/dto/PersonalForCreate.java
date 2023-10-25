package fa.training.dto;

import fa.training.validator.Phone;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class PersonalForCreate {

    @NotBlank(message = "first name may not be null")
    private String firstName;

    @NotBlank(message = "last name may not be null")
    private String lastName;
    private String gender ;

    @Phone
    private String phone ;

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String live;
    @NotNull
    private String[] hobbies;
    private String description;

    public PersonalForCreate() {
    }

    public PersonalForCreate(String firstName, String lastName, String gender, String phone, String email, String live, String[] hobbies, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.hobbies = hobbies;
        this.description = description;
        this.live =live;
    }


    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
