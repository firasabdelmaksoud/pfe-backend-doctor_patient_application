package Tn.Pixemantic.DoctorPatientAppointment.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.Appointment;
import Tn.Pixemantic.DoctorPatientAppointment.Exceptions.AppointmentNotFoundException;
import Tn.Pixemantic.DoctorPatientAppointment.Request.UpdateAppointmentRequest;
import Tn.Pixemantic.DoctorPatientAppointment.Service.IAppointmentService;
import Tn.Pixemantic.DoctorPatientAppointment.Service.IDoctorService;
import Tn.Pixemantic.DoctorPatientAppointment.Service.IPatientService;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@CrossOrigin(origins="http://localhost:5000")
@RestController
public class AppointmentController {
	@Autowired 
	 IAppointmentService AppointmentService; 
	 IPatientService patientService;
	 IDoctorService doctorService;
	 // http://localhost:8080/retrieve-all-Appointment 
	 @GetMapping("/retrieve-all-Appointment") 
	 @ResponseBody 
	 public List<Appointment> getAppointment() { 
		 List<Appointment> list = AppointmentService.retrieveAllAppointment(); 
		 return list; } 
	//http://localhost:8080retrieve-Appointment/{Appointment-id} 
	 @GetMapping("/retrieve-Appointment/{Appointment-id}") 
	 @ResponseBody 
	 public Appointment retrieveAppointment(@PathVariable("Appointment-id") int AppointmentId) { 
		 return AppointmentService.retrieveAppointment(AppointmentId);  } 
	// Ajouter Appointment : http://localhost:8080/add-Appointment 
	 @PostMapping("/add-Appointment") 
	 @ResponseBody 
	 public Appointment addAppointment(@RequestBody Appointment a) { 
		 Appointment Appointment = AppointmentService.addAppointment(a); 
		 return Appointment ; }
	//http://localhost:8080/remove-Appointment/{Appointment-id} 
	 @DeleteMapping("/remove-Appointment/{Appointment-id}") 
	 @ResponseBody 
	 public void removeAppointment(@PathVariable("Appointment-id") String AppointmentId) {
		 AppointmentService.deleteAppointment(AppointmentId); 
		  } 
	 // http://localhost:8080/modify-Appointment 
	 @PutMapping("/modify-Appointment") 
	 @ResponseBody 
	 public Appointment modifyAppointment(@RequestBody Appointment Appointment) { 
		 return AppointmentService.updateAppointment(Appointment);  }
	 
	 
	  
	// http://localhost:8080/getdoctor-all-Appointment 
		 @GetMapping("/getdoctor-all-Appointment") 
		 @ResponseBody 
		 public Page<Appointment> getAppointmentsForDoctor(@PathVariable int doctorId,Pageable pageable) { 
			 Page<Appointment> page = AppointmentService.getAppointmentsForDoctor(doctorId, pageable); 
			 return page; } 

	    
	    }
	 
	 
	 
	 

