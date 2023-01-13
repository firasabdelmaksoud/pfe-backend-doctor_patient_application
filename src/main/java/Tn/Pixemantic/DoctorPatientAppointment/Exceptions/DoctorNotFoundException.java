package Tn.Pixemantic.DoctorPatientAppointment.Exceptions;

public class DoctorNotFoundException extends RuntimeException{
    private String message;
    public DoctorNotFoundException(String message){
        super(message);
        this.message = message;
    }

    public DoctorNotFoundException(){}
}