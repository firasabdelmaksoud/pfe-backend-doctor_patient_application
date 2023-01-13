package Tn.Pixemantic.DoctorPatientAppointment.Exceptions;


	public class AppointmentTimeNotValidException extends RuntimeException{
	    private String message;
	    public AppointmentTimeNotValidException(String message){
	        super(message);
	        this.message = message;
	    }

	    public AppointmentTimeNotValidException(){}
	}
