/*
 * Class to model the entitiy Lab
 * @author Emma Chiusano
 * @verson 0.1
 * Date of Creation: 9 September, 2021
 * Last Date Modified: 14 September, 2021
 * */
public class Lab extends Room{
	//data members
	private int computers;
	
	//constructors
	/*default constructor
	no parameters
	initializes computers to 0 */
	public Lab () {
		super();
		computers=0;
	}
	/*Constructor with 1 parameters
	 * @param computers for the number of a computers*/
	public Lab (String number, int capacity, int area, int computers) {
		super(number, capacity, area);
		this.computers=computers;
	}
	//getters
	/*Getter for the number of computers in a room
	 * @param no parameters
	 * @return the value for the data member computers*/
	public int getComputers() {
		return computers;
	}
	//setters
	/*Setter for the computers in  a room
	 * @param computers to set the data member computers
	 * @return no return*/
	public void setComputers(int computers) {
		this.computers=computers;
	}
	/*Method to get the Lab information
	 * @param no parameters
	 * @return formatted string contaning teh value of the data members
	 * Accesses the suoer class Room*/
	public String toString() {
		String s;
		s = String.format("%-15s\t%s\t%d", "Lab", super.toString(), computers);
		return s;
		}
	/*Method to create a simple string with the Lab information
	 * @param none
	 * @return a simple string with the data members separated by a space*/
	public String simpleString() {
		String s;
		s="Lab"+" "+super.simpleString()+" "+computers;
		return s;
		}
}
