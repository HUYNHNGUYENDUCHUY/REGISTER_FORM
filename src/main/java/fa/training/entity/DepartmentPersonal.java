package fa.training.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "department_personal")
public class DepartmentPersonal implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name ="dept_id")
    private Department department;

    @Id
    @ManyToOne
    @JoinColumn(name = "personal_id")
    private Personal personal;

    public DepartmentPersonal() {
    }

    public DepartmentPersonal(Department department, Personal personal) {
        this.department = department;
        this.personal = personal;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
