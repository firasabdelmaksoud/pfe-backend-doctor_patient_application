package Tn.Pixemantic.DoctorPatientAppointment.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer >{

}
