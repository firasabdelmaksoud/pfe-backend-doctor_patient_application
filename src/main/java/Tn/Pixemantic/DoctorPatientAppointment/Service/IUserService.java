package Tn.Pixemantic.DoctorPatientAppointment.Service;

import java.util.List;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.User;

public interface IUserService {
	 List<User> retrieveAllUser(); 
	 User addUser(User a); 
	 void deleteUser(String id); 
	 User updateUser(User a); 
	 User retrieveUser(int id);
}
