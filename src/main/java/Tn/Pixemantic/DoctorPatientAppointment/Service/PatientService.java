package Tn.Pixemantic.DoctorPatientAppointment.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.Patient;
import Tn.Pixemantic.DoctorPatientAppointment.Repository.PatientRepository;


@Service
public class PatientService implements IPatientService {

	@Autowired
	PatientRepository patientRepo;
	private static final Logger l = LogManager.getLogger(PatientService.class);
	
	
	@Override
	public List<Patient> retrieveAllPatient() {
		List<Patient> patients = (List<Patient>) patientRepo.findAll();
		for(Patient p : patients)
		{
			l.info("patient +++ : "+p);
		}
		return patients;
	}

	@Override
	public Patient addPatient(Patient a) {
		l.info("Adding patient with ID: "+a.getPatientId());
		return patientRepo.save(a);
	}

	@Override
	public void deletePatient(String id) {
		l.info("Deleting patient with ID: "+id);
		patientRepo.deleteById(Integer.parseInt(id));
		
	}

	@Override
	public Patient updatePatient(Patient a) {
		l.info("Updating patient with ID: "+a.getPatientId());
		return this.patientRepo.save(a);
	}

	@Override
	public Patient retrievePatient(int id) {
		l.info("Retriving patient with ID: "+id);
		return this.patientRepo.findById(id).get();
	}

}
