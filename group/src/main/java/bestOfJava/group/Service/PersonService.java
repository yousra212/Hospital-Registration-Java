package bestOfJava.group.Service;

import bestOfJava.group.Model.Person;
import bestOfJava.group.Model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bestOfJava.group.Repository.PersonRepo;
import bestOfJava.group.Repository.DoctorRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepo personRepo;
    private final DoctorService doctorService;

    @Autowired
    public PersonService(PersonRepo personRepo, DoctorService doctorService) {
        this.personRepo = personRepo;
        this.doctorService = doctorService;

    }

    public void registerPerson (Person person) {
        Optional<Person> personOptional = personRepo.findPersonByFirstNameAndLastNameAndTimeStamp(person.getFirstName(), person.getLastName(), person.getTimeStamp());
        if (personOptional.isPresent()) {
            person.setDoctor(personOptional.get().getDoctor());
            personRepo.save(person);
        } else {
            throw new IllegalStateException("Person already registered");
        }
    }
    public List<Person> getAllVisitsForDay(LocalDate date) {
        LocalDateTime startDateTime = date.atStartOfDay();
        LocalDateTime endDateTime = date.plusDays(1).atStartOfDay().minusDays(1);
        return personRepo.findByTimeStampBetween(startDateTime, endDateTime);
    }
    public List<Person> getVisitsForPeriod(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.plusDays(1).atStartOfDay().minusDays(1);
        return personRepo.findByTimeStampBetween(startDateTime, endDateTime);
    }
    public void deletePerson(Long personId) {
        personRepo.deleteById(personId);
    }

   public Person addPerson (String firstName, String lastName, LocalDateTime timeStamp) {
        Person newPerson = new Person();
        newPerson.setFirstName(firstName);
        newPerson.setLastName(lastName);
        newPerson.setTimeStamp(timeStamp);

        Doctor doctor = doctorService.findAvailableDoctor();
        if (doctor == null) {
            doctor = doctorService.addDoctor("Pious Alpha");
        }

        newPerson.setDoctor(doctor);
        return personRepo.save(newPerson);
   }
}