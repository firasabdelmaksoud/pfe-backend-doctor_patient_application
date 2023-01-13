package Tn.Pixemantic.DoctorPatientAppointment.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.Patient;
import Tn.Pixemantic.DoctorPatientAppointment.Service.IPatientService;



@CrossOrigin(origins="http://localhost:5000")
@RestController
public class PatientController {
	@Autowired 
	 IPatientService PatientService; 
	 // http://localhost:8080/retrieve-all-Patient 
	 @GetMapping("/retrieve-all-Patient") 
	 @ResponseBody 
	 public List<Patient> getPatient() { 
		 List<Patient> list = PatientService.retrieveAllPatient(); 
		 return list; } 
	//http://localhost:8080/retrieve-Patient/{Patient-id} 
	 @GetMapping("/retrieve-Patient/{Patient-id}") 
	 @ResponseBody 
	 public Patient retrievePatient(@PathVariable("Patient-id") int PatientId) { 
		 return PatientService.retrievePatient(PatientId);  } 
	// Ajouter Patient : http://localhost:8080/add-Patient 
	 @PostMapping("/add-Patient") 
	 @ResponseBody 
	 public Patient addPatient(@RequestBody Patient a) { 
		 Patient Patient = PatientService.addPatient(a); 
		 return Patient ; }
	//http://localhost:8080/remove-Patient/{Patient-id} 
	 @DeleteMapping("/remove-Patient/{Patient-id}") 
	 @ResponseBody 
	 public void removePatient(@PathVariable("Patient-id") String PatientId) {
		 PatientService.deletePatient(PatientId); 
		  } 
	 // http://localhost:8080/modify-Patient
	 @PutMapping("/modify-Patient") 
	 @ResponseBody 
	 public Patient modifyPatient(@RequestBody Patient Patient) { 
		 return PatientService.updatePatient(Patient);  }
}
