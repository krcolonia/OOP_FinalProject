package finalProject;

public class Reservation extends Client {
	private String date, time;
	
 	Reservation(String date, String time, String name, int numAdult, int numChild) {
 		super(name, numAdult, numChild);
 		this.date = date;
 		this.time = time;
 	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
