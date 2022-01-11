import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/*
 * Class to model the entitiy Room
 * @author Emma Chiusano
 * @verson 0.1
 * Date of Creation: 9 September, 2021
 * Last Date Modified: 14 September, 2021
 * */
public class Room {
// data members
	private String number;
	private int capacity;
	private int area;
	//constructors
	/*default constructor
	no parameters
	initializes number to "undeclared" and capacity and area to 0*/
	public Room() {
		number="undeclared";
		capacity=area=0;
	}
	/*Constructor with 3 parameters
	 * @param room for the room number
	 * @param capacity for the capacity of a room
	 * @param area for the area number of a room */
	public Room(String number,int capacity, int area) {
		this.number=number;
		this.capacity=capacity;
		this.area=area;
	}
//Getters
	/*Getter for the number of a room
	* @param no parameters
	* @return the room number of the data member*/
	public String getNumber() {
		return number;
	}
	/*Getter for the capacity of a room
	* @param no parameters
	* @return the room capacity of the data member*/
	public int getCapacity() {
		return capacity;
	}
	/*Getter for the area of a room
	* @param no parameters
	* @return the room area of the data member*/
	public int getArea() {
		return area;
	}
//setters
	/*Setter for the number of a room
	 * @param number to set the data member number
	 * @return no return*/
	public void setNumber(String number) {
		this.number=number;
	}
	/*Setter for the capacity of a room
	 * @param capacity to set the data member capacity
	 * @return no return*/
	public void setCapacity(int capacity) {
		this.capacity=capacity;
	}
	/*Setter for the area of a room
	 * @param area to set the data member area
	 * @return no return*/
	public void setArea(int area) {
		this.area=area;
	}
	/*Method to get the Room information
	 * @param no parameters
	 * @return formatted string contaning teh value of the data members*/
	public String toString() {
		String s;
		s = String.format("%-10s\t%-10d\t%-10d", number, capacity, area);
		return s;
		}
	/*Method to create a simple string with the room information
	 * @param none
	 * @return a simple string with the data members separated by a space*/
	public String simpleString() {
		String s;
		s=(number+" "+capacity+" "+area);
		return s;
		}
	
}
