package bestOfJava.group.Model;


import jakarta.persistence.*;


@Entity
@Table(name = "doctor")
//Create a Doctor class to represent the doctors in the hospital
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;

   //Get and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor() {                            //Empty constructor because of the Entity (bean)
    }
}
