package finalProject;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class Menu extends InputFormat {
	
	static DecimalFormat df = new DecimalFormat("###,###,###.00"); // Used to format the Subtotal and Grand Total in "Generate Report"
	
	static ArrayList<Reservation> res = new ArrayList<Reservation>(); // res ArrayList. Used to store multiple Reservation objects.
	static ArrayList<Integer> resSubTotal = new ArrayList<Integer>(); // resSubTotal ArrayList. Used to store the subtotal of every reservation present in res ArrayList.
	
	static int numSpace=4, dateSpace=18, timeSpace=12, nameSpace=30, acSpace = 10; // Spacing variables. Used to format the variables into table format.
	
	static int adultTotal, childTotal, grandTotal; // Variables used in getting Total num of Adults and Children, and the Grand Total.
	
	// Retrieves all data from res ArrayList, and prints out in table format.
	static String viewRes() {
		String output = "";
		if(res.isEmpty()) {
			output = "Cannot view, reservations list is currently empty!\n";
		}
		else {
			output =
					lJust("#", numSpace) + 
					lJust("Date", dateSpace) +
					lJust("Time", timeSpace) +
					lJust("Name", nameSpace) + 
					center("Adults", acSpace) +
					center("Children", acSpace) + "\n";
			for(int i = 0; i < getResSize(); i++) {
				output +=
						lJust(Integer.toString(i+1), numSpace) +
						lJust(res.get(i).getDate(), dateSpace) +
						lJust(res.get(i).getTime(), timeSpace) +
						lJust(res.get(i).getName(), nameSpace) +
						center(Integer.toString(res.get(i).getNumAdult()), acSpace) +
						center(Integer.toString(res.get(i).getNumChild()), acSpace) + "\n";
			}
		}
		return output;
	}
	
	// Retrieves inputs from GUI, then enters data into res ArrayList.
	static void makeRes(String dateInput, String timeInput, String nameInput, int adultInput, int childInput) {
		String date = dateInput;
		String time = timeInput;
		String name = nameInput;
		int numAdult = adultInput;
		int numChild = childInput;
		res.add(new Reservation(date, time, name, numAdult, numChild));
		resSubTotal.add(0);
	}
	
	// Used when deleting data from res ArrayList
	static void delRes(int resToDel) {
		res.remove(resToDel);
		resSubTotal.remove(resToDel);
	}
	
	// Used to show the table during Delete option in GUI
	static String delResView() {
		String output = "";
		if(res.isEmpty()) {
			output = "Cannot delete, reservations list is currently empty!";
		}
		else {
			output =
					lJust("#", numSpace) + 
					lJust("Date", dateSpace) +
					lJust("Time", timeSpace) +
					lJust("Name", nameSpace) + 
					center("Adults", acSpace) +
					center("Children", acSpace) + "\n";
			for(int i = 0; i < getResSize(); i++) {
				output +=
						lJust(Integer.toString(i+1), numSpace) +
						lJust(res.get(i).getDate(), dateSpace) +
						lJust(res.get(i).getTime(), timeSpace) +
						lJust(res.get(i).getName(), nameSpace) +
						center(Integer.toString(res.get(i).getNumAdult()), acSpace) +
						center(Integer.toString(res.get(i).getNumChild()), acSpace) + "\n";
			}
			
		}
		return output;
	}
	
	// Used to generate the final report from the data stored in res ArrayList.
	static String genRep() {
		
		String output = "";
		
		adultTotal = 0;
		childTotal = 0;
		grandTotal = 0;
		
		if(res.isEmpty()) {
			output = "Cannot generate report, reservations list is currently empty!";
		}
		else {
			
			output =
					lJust("#", numSpace) + 
					lJust("Date", dateSpace) +
					lJust("Time", timeSpace) +
					lJust("Name", nameSpace) + 
					center("Adults", acSpace) +
					center("Children", acSpace) +
					rJust("Subtotal", acSpace) + "\n";
			for(int i = 0; i < getResSize(); i++) {
				
				resSubTotal.set(i, res.get(i).getAdultSubTotal() + res.get(i).getChildSubTotal());
				
				output +=
						lJust(Integer.toString(i+1), numSpace) +
						lJust(res.get(i).getDate(), dateSpace) +
						lJust(res.get(i).getTime(), timeSpace) +
						lJust(res.get(i).getName(), nameSpace) +
						center(Integer.toString(res.get(i).getNumAdult()), acSpace) +
						center(Integer.toString(res.get(i).getNumChild()), acSpace) +
						rJust(df.format(resSubTotal.get(i)), acSpace) + "\n";
				
				adultTotal += res.get(i).getNumAdult();
				childTotal += res.get(i).getNumChild();
				grandTotal += resSubTotal.get(i);
			}
			output += "\nTotal Number of Adults: " + adultTotal
					+ "\nTotal Number of Children: " + childTotal
					+ "\nGrand Total: PHP " + df.format(grandTotal) + "\n";
			
			output += endReport();
		}
		return output;
	}
	
	// Checks if res ArrayList is empty. Used in GUI
	static boolean delEmpty() {
		if(res.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Gets res ArrayList Size. Used in GUI
	static int getResSize() {
		return res.size();
	}
}
