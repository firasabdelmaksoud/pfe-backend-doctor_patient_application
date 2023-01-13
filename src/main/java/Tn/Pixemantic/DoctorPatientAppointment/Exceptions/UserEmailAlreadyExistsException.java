package Tn.Pixemantic.DoctorPatientAppointment.Exceptions;


	public class UserEmailAlreadyExistsException extends RuntimeException{
	    private String message;
	    public UserEmailAlreadyExistsException(String message){
	        super(message);
	        this.message = message;
	    }
	    public UserEmailAlreadyExistsException(){}
	}

