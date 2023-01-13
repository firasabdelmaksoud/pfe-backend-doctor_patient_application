package Tn.Pixemantic.DoctorPatientAppointment.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Integer > {

}
