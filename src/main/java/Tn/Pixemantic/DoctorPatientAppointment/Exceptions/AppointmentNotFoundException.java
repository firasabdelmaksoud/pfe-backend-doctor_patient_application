package Tn.Pixemantic.DoctorPatientAppointment.Exceptions;

public class AppointmentNotFoundException extends RuntimeException{
    private String message;
    public AppointmentNotFoundException(String message){
        super(message);
        this.message = message;
    }

    public AppointmentNotFoundException(){}
}
