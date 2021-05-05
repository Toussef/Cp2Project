
public class Consumer extends Person{

	private boolean		isLoyalCustomer;
	private double		discountRate;
	//the login info
	private String emailAddress;
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword()throws InvalidPasswordException {
		if (password.length()<5||password.length()>10)
			throw new InvalidPasswordException("Invalid Password. Password should be between 5 and 10 characters long");
		else
			
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
	
	public boolean isLoyalCustomer() {
		return isLoyalCustomer;
	}
	public void setLoyalCustomer(boolean isLoyalCustomer) {
		this.isLoyalCustomer = isLoyalCustomer;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	public Consumer() {
	}

	public Consumer(String _name,int _age, String emailAddress, boolean _isLoyalCustomer,double _discountRate)
	{
		super.setName(_name);
		super.setAge(_age);
		isLoyalCustomer = _isLoyalCustomer;
		discountRate	 = _discountRate;
		this.emailAddress=emailAddress;
	}
	
	public String toString()
	{
		return "";
	}
}



