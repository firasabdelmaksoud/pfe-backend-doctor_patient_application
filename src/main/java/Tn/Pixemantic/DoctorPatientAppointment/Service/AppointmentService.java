package Tn.Pixemantic.DoctorPatientAppointment.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Tn.Pixemantic.DoctorPatientAppointment.Entity.Appointment;
import Tn.Pixemantic.DoctorPatientAppointment.Entity.Doctor;
import Tn.Pixemantic.DoctorPatientAppointment.Entity.Patient;
import Tn.Pixemantic.DoctorPatientAppointment.Exceptions.DoctorNotFoundException;
import Tn.Pixemantic.DoctorPatientAppointment.Exceptions.PatientNotFoundExcep;
import Tn.Pixemantic.DoctorPatientAppointment.Repository.AppointmentRepository;
import Tn.Pixemantic.DoctorPatientAppointment.Repository.DoctorRepository;
import Tn.Pixemantic.DoctorPatientAppointment.Repository.PatientRepository;





@Service
public class AppointmentService implements IAppointmentService{

	@Autowired
	AppointmentRepository appointmentRepo;
	PatientRepository patientrepo;
	DoctorRepository doctorrepo;
	
	private static final Logger l = LogManager.getLogger(AppointmentService.class);
	
	@Override
	public List<Appointment> retrieveAllAppointment() {
		List<Appointment> appointments = (List<Appointment>) appointmentRepo.findAll();
		for(Appointment a : appointments)
		{
			l.info("Appointment +++ : "+a);
		}
		return appointments;
	}

	@Override
	public Appointment addAppointment(Appointment a) {
		l.info("Adding appointment with ID: "+a.getAppointmentId());
		return appointmentRepo.save(a);
	}

	@Override
	public void deleteAppointment(String id) {
		l.info("Deleting appointment with ID: "+id);
		appointmentRepo.deleteById(Integer.parseInt(id));
	}

	@Override
	public Appointment updateAppointment(Appointment a) {
		l.info("Updating appointment with ID: "+a.getAppointmentId());
		return this.appointmentRepo.save(a);
	}

	@Override
	public Appointment retrieveAppointment(int id) {
		l.info("Retriving appointment with ID: "+id);
		return this.appointmentRepo.findById(id).get();
	}
	   public Page<Appointment> getPatientAppointments(
	            int patientId,
	            Pageable pageable) throws PatientNotFoundExcep{
	        Optional<Patient> patient=patientrepo.findById((patientId));
	        if(patient.empty() != null) throw new PatientNotFoundExcep("no patient with this id");
	        return appointmentRepo.getByPatient(patient.get(),pageable);
	    }
	   
	   public Page<Appointment> getAppointmentsForDoctor (
	            int doctorId,
	            Pageable pageable) throws DoctorNotFoundException {
	        Optional<Doctor> doctor = doctorrepo.findById(doctorId);
	        if (doctor.empty() != null) throw new DoctorNotFoundException("No Doctor with such ID");
	        return appointmentRepo.getByDoctor(doctor.get(), pageable);
	    }
}
