package Tn.Pixemantic.DoctorPatientAppointment.Service;

import java.util.List;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.Patient;

public interface IPatientService {
	 List<Patient> retrieveAllPatient(); 
	 Patient addPatient(Patient a); 
	 void deletePatient(String id); 
	 Patient updatePatient(Patient a); 
	 Patient retrievePatient(int id);
}
