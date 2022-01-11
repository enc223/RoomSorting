/*
 * Class to handle invalid room number exceptions
 * @author Emma Chiusano
 * @verson 0.1
 * Date of Creation: 9 September, 2021
 * Last Date Modified: 14 September, 2021
 * */
public class InvalidRoomNumber extends Exception{
	//constructors
		/*default constructor
		no parameters
		initializes the seat exception */
		public InvalidRoomNumber() {
			super();
		}
		/*default constructor
		@param String messge
		returns the message of our exception */
		public InvalidRoomNumber(String message) {
			super(message);
		}
}
