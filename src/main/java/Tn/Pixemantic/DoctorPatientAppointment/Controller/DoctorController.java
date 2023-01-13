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

import Tn.Pixemantic.DoctorPatientAppointment.Entity.Doctor;
import Tn.Pixemantic.DoctorPatientAppointment.Service.IDoctorService;





@CrossOrigin(origins="http://localhost:5000")
@RestController
public class DoctorController {
	@Autowired 
	 IDoctorService DoctorService; 
	 // http://localhost:8080/retrieve-all-Doctor 
	 @GetMapping("/retrieve-all-Doctor") 
	 @ResponseBody 
	 public List<Doctor> getDoctor() { 
		 List<Doctor> list = DoctorService.retrieveAllDoctor(); 
		 return list; } 
	//http://localhost:8080/retrieve-Doctor/{Doctor-id} 
	 @GetMapping("/retrieve-Doctor/{Doctor-id}") 
	 @ResponseBody 
	 public Doctor retrieveDoctor(@PathVariable("Doctor-id") int DoctorId) { 
		 return DoctorService.retrieveDoctor(DoctorId);  } 
	// Ajouter Doctor : http://localhost:8080/add-Doctor 
	 @PostMapping("/add-Doctor") 
	 @ResponseBody 
	 public Doctor addDoctor(@RequestBody Doctor a) { 
		 Doctor Doctor = DoctorService.addDoctor(a); 
		 return Doctor ; }
	//http://localhost:8080/remove-Doctor/{Doctor-id} 
	 @DeleteMapping("/remove-Doctor/{Doctor-id}") 
	 @ResponseBody 
	 public void removeDoctor(@PathVariable("Doctor-id") String DoctorId) {
		 DoctorService.deleteDoctor(DoctorId); 
		  } 
	 // http://localhost:8080/modify-Doctor 
	 @PutMapping("/modify-Doctor") 
	 @ResponseBody 
	 public Doctor modifyDoctor(@RequestBody Doctor Doctor) { 
		 return DoctorService.updateDoctor(Doctor);  }
}
