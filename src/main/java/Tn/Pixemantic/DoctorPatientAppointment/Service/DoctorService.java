package Tn.Pixemantic.DoctorPatientAppointment.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.Doctor;
import Tn.Pixemantic.DoctorPatientAppointment.Repository.DoctorRepository;


@Service
public class DoctorService implements IDoctorService {

	
	@Autowired
	DoctorRepository doctorRepo;
	private static final Logger l = LogManager.getLogger(DoctorService.class);
	
	@Override
	public List<Doctor> retrieveAllDoctor() {
		List<Doctor> doctors = (List<Doctor>) doctorRepo.findAll();
		for(Doctor d : doctors)
		{
			l.info("doctor +++ : "+d);
		}
		return doctors;
	}

	@Override
	public Doctor addDoctor(Doctor a) {
		l.info("Adding doctor with ID: "+a.getDoctorId());
		return doctorRepo.save(a);
	}

	@Override
	public void deleteDoctor(String id) {
		l.info("Deleting activity with ID: "+id);
		doctorRepo.deleteById(Integer.parseInt(id));
		
	}

	@Override
	public Doctor updateDoctor(Doctor a) {
		l.info("Updating doctor with ID: "+a.getDoctorId());
		return this.doctorRepo.save(a);
	}

	@Override
	public Doctor retrieveDoctor(int id) {
		l.info("Retriving doctor with ID: "+id);
		return this.doctorRepo.findById(id).get();
	}

}
