package fa.training.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="personal")
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id" )
    private int id;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone", length = 255)
    private String phone;

    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "live", length = 255)
    private String live;

    @Column(name = "hobbies", length = 255)
    private String hobbies;

    @Column(name = "description" ,length = 1000)
    private String description;

    @OneToMany(mappedBy = "personal")
    private Set<DepartmentPersonal> departmentPersonal;

    public Personal() {
    }

    public Personal(String firstName, String lastName, String phone, String email, String hobbies, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.hobbies = hobbies;
        this.description = description;
    }

    public Personal(String firstName, String lastName, String gender, String phone, String email, String live, String hobbies, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.live = live;
        this.hobbies = hobbies;
        this.description = description;
    }

    public Personal(int id, String firstName, String lastName, String gender, String phone, String email, String live, String hobbies, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.live = live;
        this.hobbies = hobbies;
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<DepartmentPersonal> getDepartmentPersonal() {
        return departmentPersonal;
    }

    public void setDepartmentPersonal(Set<DepartmentPersonal> departmentPersonal) {
        this.departmentPersonal = departmentPersonal;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "personalId=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", description='" + description + '\'' +
                ", departmentPersonal=" + departmentPersonal +
                '}';
    }
}

