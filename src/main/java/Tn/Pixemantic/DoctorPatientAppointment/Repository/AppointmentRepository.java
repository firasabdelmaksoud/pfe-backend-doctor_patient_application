package Tn.Pixemantic.DoctorPatientAppointment.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.Appointment;
import Tn.Pixemantic.DoctorPatientAppointment.Entity.Doctor;
import Tn.Pixemantic.DoctorPatientAppointment.Entity.Patient;



@Repository
public interface AppointmentRepository  extends CrudRepository<Appointment,Integer > {

	Page<Appointment> getByDoctor(Doctor doctor, Pageable pageable);

    Page<Appointment> getByPatient(Patient patient, Pageable pageable);
}
