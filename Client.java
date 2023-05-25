package finalProject;

public class Client implements ReservationRate {
	private int numAdult, numChild;
	private String name;
	
	// Client Constructor. Used to declare the variables used in the Client object.
	Client(String name, int numAdult, int numChild) {
		this.name = name;
		this.numAdult = numAdult;
		this.numChild = numChild;
	}
	
	// Getters and Setters for each variable present in Client.
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumAdult() {
		return numAdult;
	}

	public void setNumAdult(int numAdult) {
		this.numAdult = numAdult;
	}

	public int getNumChild() {
		return numChild;
	}

	public void setNumChild(int numChild) {
		this.numChild = numChild;
	}

	// Retrieves the subtotal for the Adults in a reservation. Uses adultRate from ReservationRate interface
	public int getAdultSubTotal() {
		int adultSubtotal = adultRate * numAdult;
		return adultSubtotal;
	}
	
	// Retrieves the subtotal for the Children in a reservation. Uses childRate from ReservationRate interface
	public int getChildSubTotal() {
		int childSubtotal = childRate * numChild;
		return childSubtotal;
	}
}
