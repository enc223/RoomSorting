/*
 * Class to model the entitiy Classroom
 * @author Emma Chiusano
 * @verson 0.1
 * Date of Creation: 9 September, 2021
 * Last Date Modified: 15 September, 2021
 * */
public class Classroom extends Room{
	//constructors
	/*default constructor
	no parameters */
	public Classroom () {
		super();
	}
	/*Constructor with 3 parameters
	 * initializes "Room"'s parameters
	 */
	public Classroom (String number, int capacity, int area) {
		super(number, capacity, area);
	}
	/*Method to get the Classroom information
	* @param no parameters
	* @return formatted string contaning teh value of the data members
	* Accesses the suoer class Room*/
	public String toString() {
		String s;
		s = String.format("%-15s\t%s", "Classroom", super.toString());
		return s;
		}
	/*Method to create a simple string with the Lab information
	 * @param none
	 * @return a simple string with the data members separated by a space*/
	public String simpleString() {
		String s;
		s="Classroom"+" "+super.simpleString();
		return s;
		}
}
