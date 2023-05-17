package bestOfJava.group.Model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "person")
//Create a Person class to represent the visitors/patients in the hospital
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Person(Long id, String firstName, String lastName, LocalDateTime timeStamp) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeStamp = timeStamp;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timestamp) {
        this.timeStamp = timestamp;
    }

    public Doctor getDoctor() {
        return null;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Person() {                            //Empty constructor because of the Entity (bean)
    }

}
