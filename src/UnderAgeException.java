
public class UnderAgeException extends Exception {

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

	public UnderAgeException(String message) {
		super(message);
		System.out.println(message);
		
	}
	

}


