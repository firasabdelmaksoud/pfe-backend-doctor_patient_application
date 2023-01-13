package Tn.Pixemantic.DoctorPatientAppointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.User;


@Repository
public interface RegistrationRepository extends JpaRepository< User,Long> {
   public User findByEmail(String email);
   public User findByEmailAndPassword(String email,String password);

}