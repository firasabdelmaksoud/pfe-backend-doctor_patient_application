package Tn.Pixemantic.DoctorPatientAppointment.Exceptions;

public class PatientNotFoundExcep extends RuntimeException{
    private String notification;
    public PatientNotFoundExcep(String notification){
        super(notification);
        this.notification=notification;
    }
    public PatientNotFoundExcep(){

    }
}