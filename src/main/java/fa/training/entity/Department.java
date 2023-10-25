package fa.training.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "department")
public class Department {

    @Id
    @Column(name="id")
    private int departmentId;

    @Column(name = "department_name",length = 255)
    private String departmentName;

    @Column(name= "description")
    private int description;

    @OneToMany(mappedBy = "department")
    private Set<DepartmentPersonal> departmentPersonal;

    public Department() {
    }

    public Department(String departmentName, int description) {
        this.departmentName = departmentName;
        this.description = description;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public Set<DepartmentPersonal> getDepartmentPersonal() {
        return departmentPersonal;
    }

    public void setDepartmentPersonal(Set<DepartmentPersonal> departmentPersonal) {
        this.departmentPersonal = departmentPersonal;
    }
}
