package Tn.Pixemantic.DoctorPatientAppointment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.User;
import Tn.Pixemantic.DoctorPatientAppointment.Service.RegistrationService;



@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping("/registeruser")
    @CrossOrigin(origins="http://localhost:5000")
    public User registerUser (@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();

         if (tempEmail != null && !"".equals(tempEmail))
         {
             User userobj =service.fetchUserByEmail(tempEmail);
             if (userobj != null)
             {
                   throw new Exception("user with "+tempEmail+" is alreadyexist");
             }
         }
        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:5000")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmail= user.getEmail();
        String tempPass = user.getPassword();
        User userObj = null ;
        if (tempEmail != null && tempPass !=null)
        {
            userObj = service.fetchUserByEmailAndPassword(tempEmail,tempPass);
        }

        if(userObj == null)
        {
            throw new Exception("Bad credentials");
        }
        return userObj;
    }

}
