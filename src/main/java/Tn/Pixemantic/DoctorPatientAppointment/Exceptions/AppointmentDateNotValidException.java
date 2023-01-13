package Tn.Pixemantic.DoctorPatientAppointment.Exceptions;

public class AppointmentDateNotValidException extends RuntimeException {
    private String message;
    public AppointmentDateNotValidException(String message){
        super(message);
        this.message = message;
    }

    public AppointmentDateNotValidException(){}
}
