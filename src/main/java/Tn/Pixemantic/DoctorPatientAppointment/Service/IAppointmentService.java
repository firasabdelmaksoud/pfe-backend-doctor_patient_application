package Tn.Pixemantic.DoctorPatientAppointment.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.Appointment;

public interface IAppointmentService {
	 List<Appointment> retrieveAllAppointment(); 
	 Appointment addAppointment(Appointment a); 
	 void deleteAppointment(String id); 
	 Appointment updateAppointment(Appointment a); 
	 Appointment retrieveAppointment(int id);
	 public Page<Appointment> getPatientAppointments (int patientId,Pageable pageable);
	 public Page<Appointment> getAppointmentsForDoctor ( int doctorId,Pageable pageable);
}
