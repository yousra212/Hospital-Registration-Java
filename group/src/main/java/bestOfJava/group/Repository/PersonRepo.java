package bestOfJava.group.Repository;

import bestOfJava.group.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository

public interface PersonRepo extends JpaRepository<Person, Long> {
    List<Person> findByTimeStamp(LocalDateTime timeStamp);

    List<Person> findByTimeStampBetween(LocalDateTime startDate, LocalDateTime endDate);

    Optional<Person> findPersonByFirstNameAndLastNameAndTimeStamp(String firstName, String lastName, LocalDateTime timestamp);

}