package bestOfJava.group.Service;

import bestOfJava.group.Model.Doctor;
import bestOfJava.group.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepo doctorRepo;

    @Autowired
    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public Doctor addDoctor(String doctor) {
        Doctor newDoctor = new Doctor();
        newDoctor.setName(doctor);
        return doctorRepo.save(newDoctor);
    }
    public Doctor updateDoctor(Long doctorId, String name) {
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(() -> new IllegalStateException("Doctor with id " + doctorId + " does not exist"));
        doctor.setName(name);
        return doctorRepo.save(doctor);
    }
    public void deleteDoctor(Long doctorId) {
        doctorRepo.deleteById(doctorId);
    }
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }
    public Doctor getDoctorById(Long doctorId) {
        return doctorRepo.findById(doctorId).orElseThrow(() -> new IllegalStateException("Doctor with id " + doctorId + " does not exist"));
    }

    public Doctor findAvailableDoctor() {
        List<Doctor> doctors = getAllDoctors();
        if (doctors.isEmpty()) {
            return null;
        }
        return doctors.get(0);
    }
}
