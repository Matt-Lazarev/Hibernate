package d_sequence;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @SequenceGenerator(
            name = "emp_gen",
            sequenceName = "emp_gen",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "emp_gen")
    private Integer id;

    private String name;

    private String specialization;

    public Employee(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
