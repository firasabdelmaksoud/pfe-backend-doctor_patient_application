package Tn.Pixemantic.DoctorPatientAppointment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.User;
import Tn.Pixemantic.DoctorPatientAppointment.Repository.RegistrationRepository;



@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository repo;

    public User saveUser(User user)
    {
        return repo.save(user);
    }
    public User fetchUserByEmail(String email)
    {
        return  repo.findByEmail(email);
    }
    public User fetchUserByEmailAndPassword(String email,String password)
    {
        return repo.findByEmailAndPassword(email,password);

    }
}
