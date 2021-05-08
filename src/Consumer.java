import java.util.LinkedList;
import java.io.*;
//import java.util.Random;
public class Consumer extends Person{
	private LinkedList<Consumer> consumers;
	public LinkedList<Consumer> getConsumers() {
		return consumers;
	}
	public void setConsumers(LinkedList<Consumer> consumers) {
		this.consumers = consumers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private int id;
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
		consumers = new LinkedList<Consumer>();
	}

	public Consumer( String _name,int _age, String emailAddress, boolean _isLoyalCustomer,double _discountRate)
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
	public int sequentialID() {         //Generates the id for the customer
		return consumers.size();
	}
	public void addConsumer(Consumer c) {
		consumers.add(c);
	}
	/*public static void main(String[] args) {
		Consumer clist = new Consumer();
		Consumer c1 = new Consumer("Joe",14,"youssef@mmneimneh.net",true,20);
		clist.addConsumer(c1);
		c1.setId(clist.sequentialID());
		System.out.println(c1.getId());
		
	}*/
}



