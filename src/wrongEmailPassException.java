
public class wrongEmailPassException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public wrongEmailPassException(){
		
	}
	public wrongEmailPassException(String message) {
		super(message);
	}
	public String toString() {
		return "The email/password combination is incorrect.";
	}
}
