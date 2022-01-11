/*
 * Class to model the entitiy Office
 * @author Emma Chiusano
 * @verson 0.1
 * Date of Creation: 9 September, 2021
 * Last Date Modified: 14 September, 2021
 * */
public class Office extends Room{
//data members
	private String owner;
		
	//constructors
	/*default constructor
	no parameters
	initializes owner to "undeclared" */
	public Office () {
		super();
		owner="undeclared";
	}
	/*Constructor with 1 parameters
	 * @param owner for the owner of a room
	 */
	public Office (String number, int capacity, int area, String owner) {
		super(number, capacity, area);
			this.owner=owner;
	}
	//getters
	/*Getter for the owner of a room
	 * @param no parameters
	* @return the value for the data member owner*/
	public String getOwner() {
		return owner;
	}
	//setters
	/*Setter for the owner of a room
	* @param computers to set the data member owner
	* @return no return*/
	public void setOwner(String owner) {
		this.owner=owner;
	}
	/*Method to get the Office information
	* @param no parameters
	* @return formatted string contaning teh value of the data members
	* Accesses the suoer class Room*/
	public String toString() {
		String s;
		s = String.format("%-15s\t%s\t%s", "Office", super.toString(), owner);
		return s;
		}
	/*Method to create a simple string with the office information
	 * @param none
	 * @return a simple string with the data members separated by a space*/
	public String simpleString() {
		String s;
		s="Office"+" "+super.simpleString()+" "+owner;
		return s;
		}
}
