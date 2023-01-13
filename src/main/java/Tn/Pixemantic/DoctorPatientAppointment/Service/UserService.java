package Tn.Pixemantic.DoctorPatientAppointment.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.User;
import Tn.Pixemantic.DoctorPatientAppointment.Repository.UserRepository;


@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepo;
	private static final Logger l = LogManager.getLogger(UserService.class);
	
	@Override
	public List<User> retrieveAllUser() {
		List<User> users = (List<User>) userRepo.findAll();
		for(User u : users)
		{
			l.info("user +++ : "+u);
		}
		return users;
	}

	@Override
	public User addUser(User a) {
		l.info("Adding activity with ID: "+a.getUserId());
		return userRepo.save(a);
	}

	@Override
	public void deleteUser(String id) {
		l.info("Deleting user with ID: "+id);
		userRepo.deleteById(Integer.parseInt(id));
		
	}

	@Override
	public User updateUser(User a) {
		l.info("Updating user with ID: "+a.getUserId());
		return this.userRepo.save(a);
	}

	@Override
	public User retrieveUser(int id) {
		l.info("Retriving user with ID: "+id);
		return this.userRepo.findById(id).get();
	}

}
