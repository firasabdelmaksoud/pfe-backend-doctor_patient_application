package Tn.Pixemantic.DoctorPatientAppointment.Service;

import java.util.List;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.Doctor;

public interface IDoctorService {
	 List<Doctor> retrieveAllDoctor(); 
	 Doctor addDoctor(Doctor a); 
	 void deleteDoctor(String id); 
	 Doctor updateDoctor(Doctor a); 
	 Doctor retrieveDoctor(int id);
}
