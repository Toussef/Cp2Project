import java.util.LinkedList;

public class Booking {
	private Consumer consumer;
	private String currectCountry;
	private String destinationCountry;
	private int members;
	private boolean family;
	private LinkedList<Booking> bookings;

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public String getCurrectCountry() {
		return currectCountry;
	}

	public void setCurrectCountry(String currectCountry) {
		this.currectCountry = currectCountry;
	}

	public LinkedList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(LinkedList<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking() {
		bookings = new LinkedList<>();
	}

	public Booking(Consumer consumer,String currentCountry,String destinationCountry, int members, boolean family) {
		this.consumer=consumer;
		this.currectCountry=currentCountry;
		this.destinationCountry = destinationCountry;
		this.members = members;
		this.family = family;
	}

	public String getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}


	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	public boolean isFamily() {
		return family;
	}

	public void setFamily(boolean family) {
		this.family = family;
	}
	public void addBooking(Booking booking) {
		bookings.add(booking);
	}
	/*public Booking returnBooking(Consumer C ) {//return all bookings for a certain id.

	
	}*/
	public void clearAll() {
		bookings.clear();
	}
	public String toString() {
		return consumer.getFirstName()+"\n"+consumer.getLastName()+"\n"+currectCountry+"\n"+destinationCountry+"\n"+members+"\n"+family+"\n";
	}
}