package bestOfJava.group.Controller;

import bestOfJava.group.Model.Doctor;
import bestOfJava.group.Model.Person;
import bestOfJava.group.Service.DoctorService;
import bestOfJava.group.Service.PersonService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")

public class HospitalController {
    private final PersonService personService;

    private final DoctorService doctorService;

    @Autowired
    public HospitalController(PersonService personService, DoctorService doctorService) {
        this.personService = personService;
        this.doctorService = doctorService;
    }

    @PostMapping("/visits")
    public Person registerPerson(@RequestBody Person person) {
       return personService.addPerson(person.getFirstName(),person.getLastName(), LocalDateTime.now());

    }

    @GetMapping("/visits/day")
    public List<Person> getAllVisitsForDay(@RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return personService.getAllVisitsForDay(date);
    }

    @GetMapping("/visits/period")
    public List<Person> getVisitsForPeriod(@RequestParam("start_date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
                                           @RequestParam("end_date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate) {
        return personService.getVisitsForPeriod(startDate, endDate);
    }

    @DeleteMapping("/visits/{personId}")
    public void deletePerson(@PathVariable("personId") Long personId) {
        personService.deletePerson(personId);
    }

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor.getName());
    }

    @PutMapping("/doctors/{doctorId}")
    public Doctor updateDoctor(@PathVariable("doctorId") Long doctorId, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(doctorId, doctor.getName());
    }

    @DeleteMapping("/doctors/{doctorId}")
    public void deleteDoctor(@PathVariable("doctorId") Long doctorId) {
        doctorService.deleteDoctor(doctorId);
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/doctors/{doctorId}")
    public Doctor getDoctorById(@PathVariable("doctorId") Long doctorId) {
        return doctorService.getDoctorById(doctorId);
    }

}
