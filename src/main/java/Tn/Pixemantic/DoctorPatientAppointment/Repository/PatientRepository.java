package Tn.Pixemantic.DoctorPatientAppointment.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Integer >{

}
