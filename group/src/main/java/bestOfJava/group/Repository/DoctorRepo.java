package bestOfJava.group.Repository;

import bestOfJava.group.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    /*Doctor save(Doctor doctor);
    void delete(Long doctorId);
    List<Doctor> findAll();
    Doctor findById(Long doctorId);*/

}
