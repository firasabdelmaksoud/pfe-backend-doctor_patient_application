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

import Tn.Pixemantic.DoctorPatientAppointment.Entity.User;
import Tn.Pixemantic.DoctorPatientAppointment.Service.IUserService;



@CrossOrigin(origins="http://localhost:5000")
@RestController
public class UserController {
	@Autowired 
	 IUserService UserService; 
	 // http://localhost:8080/retrieve-all-User
	 @GetMapping("/retrieve-all-User") 
	 @ResponseBody 
	 public List<User> getUser() { 
		 List<User> list = UserService.retrieveAllUser(); 
		 return list; } 
	//http://localhost:8080/retrieve-User/{User-id} 
	 @GetMapping("/retrieve-User/{User-id}") 
	 @ResponseBody 
	 public User retrieveUser(@PathVariable("User-id") int UserId) { 
		 return UserService.retrieveUser(UserId);  } 
	// Ajouter User : http://localhost:8080/add-User
	 @PostMapping("/add-User") 
	 @ResponseBody 
	 public User addUser(@RequestBody User a) { 
		 User User = UserService.addUser(a); 
		 return User ; }

	 //http://localhost:8080/remove-User/{User-id} 
	 @DeleteMapping("/remove-User/{User-id}") 
	 @ResponseBody 
	 public void removeUser(@PathVariable("User-id") String UserId) {
		 UserService.deleteUser(UserId); 
		  } 
	 // http://localhost:8080/modify-User 
	 @PutMapping("/modify-User") 
	 @ResponseBody 
	 public User modifyUser(@RequestBody User User) { 
		 return UserService.updateUser(User);  }
}
