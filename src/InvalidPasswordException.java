
public class InvalidPasswordException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InvalidPasswordException(String message) {
		super(message);
		System.out.println(message);
		
	}
	

}
