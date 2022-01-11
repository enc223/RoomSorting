import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/*
 * Class to test our Room heirarchy
 * @author Emma Chiusano
 * @verson 0.1
 * Date of Creation: 9 September, 2021
 * Last Date Modified: 15 September, 2021
 * */
public class Test {
	public static void main(String[]args) throws InvalidRoomNumber {
		Scanner input=new Scanner(System.in);
		//initialize file
		File roomsFile=new File("rooms.txt");
		//initialize a variable count
		int count=0;
		//initialize a variable called choice so that we can get the user's choice from the menu to use inthe switch statement
		int choice=0;
		String roomNumber="";
		String roomType="";
		String owner="";
		int capacity=0;
		int area=0;
		int numComps=0;
		//creates a new array "rooms" of type Room
		/*adds rooms to the array, in each subcatagory of Room
		*/
		Room[] rooms=new Room[50];
		//switch statement to fill the array with the text file
		try {
			Scanner roomTypeScan=new Scanner (roomsFile);
			while (roomTypeScan.hasNext()) {
				String roomTypeSwitch=roomTypeScan.next();
				switch (roomTypeSwitch) {
					case "Office":
						rooms[count++]=new Office(roomTypeScan.next(), roomTypeScan.nextInt(), roomTypeScan.nextInt(), roomTypeScan.next()+" "+roomTypeScan.next());
						break;
					case "Lab":
						rooms[count++]=new Lab(roomTypeScan.next(), roomTypeScan.nextInt(), roomTypeScan.nextInt(), roomTypeScan.nextInt());
						break;
					case "Classroom":
						rooms[count++]=new Room(roomTypeScan.next(), roomTypeScan.nextInt(), roomTypeScan.nextInt());
						break;
					default:
						System.out.println("Invalid operation");
				}
			}
			roomTypeScan.close();
			}
			catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		//print out  a menu for the user to choose from
		do{
			System.out.println("Select an Operation:"); 
			System.out.println("1: View the list of Rooms");//prints a list of rooms
			System.out.println("2: Find a Room");         //If the user types 2, it will call findRoom
			System.out.println("3. Add a New Room");      //If the user types 3, a room will be added
			System.out.println("4: Remove an Existing Room");     //If the user types 4, a room will be removed
			System.out.println("5: Sort the List of Rooms");   //If the user types 5, the rooms will be sorted
			System.out.println("6: Exit the Program");//exits the program
			choice=getInt(choice);//gets users choice from scanner
			
			//a switch statement to sort through the menu with the user's input
			switch (choice){
			case 1: printRooms(rooms,count); // fprints the list of rooms
				break;
			case 2: 
				System.out.println("Enter the room number:");
				roomNumber =input.next();
				int index=findRoom(rooms, count, roomNumber); //finds the rooms
				if (index!=-1) {
						System.out.println("Room found: " +rooms[index]);
				}else {
					System.out.println("Room not found");
				}
				break;
			case 3: 
				System.out.println("Enter the room number:");
				 roomNumber =input.next();
				if (addRoom(rooms, count, roomNumber))
					count++;//adds a room
				break;
			case 4: 
				System.out.println("Enter the room number:");
				 roomNumber =input.next();
				if (removeRoom(rooms, count, roomNumber))
					count--;//removes a room
					System.out.println("Room "+roomNumber+" was successfully removed");
				break;
			case 5: sortRooms(rooms, count);
				break;
			case 6: 
				saveFile("rooms.txt", rooms, count);
				System.out.println("Goodbye.");
				break;
			default: System.out.println("You entered an invalid value -- try again");
				break;
			}
			}while(choice != 6);
	}
	//new method to get user input
	//@ param takes in choice
	//@return returns user choice
	public static int getInt(int choice) {
		Scanner input=new Scanner(System.in);
		while(input.hasNextInt()==false) {
			System.out.println("You have entered an invaled input, try again:");
			input.nextLine();//clear the input
		}
		int num=input.nextInt();//get user input
		return num;
	}
	//new method to print the array of rooms
	//@ param takes in the array rooms
	//@ return returns a printed list
	public static void printRooms(Room[] list, int count) {
		System.out.println("Type\t\tNumber\t\tCapacity\tArea\t\tOwner/Computers");
		for(int i=0; i<count; i++) {
			System.out.println(list[i].toString());
		}
	}
	//new method to find a room number in the array list
	//@param takes in teh array rooms and the string room number
	//@return the index of the room, or -1 if room not found
	public static int findRoom(Room[]list,int count,String roomNumber) {
		int roomIndex;
		//for loop to search for the index of room number
		for (int i = 0; i < count; i++) {
			if (list[i].getNumber().equals(roomNumber)) {
				roomIndex=i;
				return i;
			}
		}
		return -1;//return -1 if index not found
	}
	/*new method to sort the array rooms
	 * @param takes in the array rooms 
	 * @return returns a sorted list of type Room */
	public static void sortRooms(Room[] list, int count) {
		int length = count;
		for(int i = 1; i < length; i++){
			//insert element i in the sorted sub list
			Room currentVal = list[i];
			int j = i - 1;
			while (j >= 0 && currentVal.getCapacity() < (list[j].getCapacity())) {
				//shift element (j-i) into element (j)
				list [j + 1] = list[j];
				j--;
			}
			//insert currentVal at position j
			list[j + 1] = currentVal;
		}
		for(int i=0; i<count; i++) {
		System.out.println(list[i].toString());
		}
	}
	/*new method to add rooms to the array
	 * @param takes in the array rooms 
	 * @return returns a new array with the new room */
	public static boolean addRoom(Room[]list, int count, String roomNumber) throws InvalidRoomNumber {
		Scanner input=new Scanner(System.in);
		if (checkRoomNumber (roomNumber)) {
			int j=findRoom(list,count, roomNumber);
			int capacity=0;
			int area=0;
			String owner="";
			int numComps=0;
			if (j==-1) {
			System.out.println("Enter the room type:");
			String roomType=input.next();
			switch (roomType) {
			case "Office":
				System.out.println("Enter the room capacity (# of people):");
				capacity=input.nextInt();
				System.out.println("Enter the room area:");
				area=input.nextInt();
				System.out.println("Enter the name of the owner (First and Last name):");
				owner=input.next()+" "+input.next();
				list[count]=new Office(roomNumber, capacity, area, owner);
				System.out.println("Room "+roomNumber+" was successfully added.");
				return true;
			case "Lab":
				System.out.println("Enter the room capacity (# of people):");
				capacity=input.nextInt();
				System.out.println("Enter the room area:");
				area=input.nextInt();
				System.out.println("Enter the number of computers:");
				numComps=input.nextInt();
				list[count]=new Lab(roomNumber, capacity, area, numComps);
				System.out.println("Room "+roomNumber+" was successfully added.");
				return true;
			case "Classroom":
				System.out.println("Enter the room capacity (# of people):");
				capacity=input.nextInt();
				System.out.println("Enter the room area:");
				area=input.nextInt();
				list[count]=new Classroom(roomNumber, capacity, area);
				System.out.println("Room "+roomNumber+" was successfully added.");
			return true;
			default:
				break;
		}	
		}else {
			System.out.println("Room already exists.");
		}
		}
		return false; 
	}
	/*new method to remove rooms from the array
	 * @param takes in the array rooms 
	 * @return returns an array with a room removed */
	public static boolean removeRoom(Room[]list, int count, String roomNumber) throws InvalidRoomNumber {
		if (checkRoomNumber (roomNumber)) {
			int roomIndex=findRoom(list, count, roomNumber);
			if (roomIndex!=-1) {
				for(int i = roomIndex; i < count-1; i++) {
					list [i] = list[i+1];
				}
				return true;
			}
		}
		return false;
		}
	/*Method to check if teh seat entered exists
	 * @param String seat
	 * @return true if the seat exists, otherwise throw an exception*/
	private static boolean checkRoomNumber (String roomNumber)throws InvalidRoomNumber{
		if (roomNumber.matches("[A-Z][A-Z]\\d{3}")) {
			return true;
		}
		throw new InvalidRoomNumber("Invalid Room Number. Must be [A-Z][A-Z][0-9][0-9][0-9]");
	}
	/*Method to save the new array file
	 * @param String filename
	 * @return saved seatmap to the file*/
	public static void saveFile(String filename, Room[]list, int count) {
		File file=new File(filename);
		try {
			PrintWriter writeFile=new PrintWriter(file);
			for (int i=0; i<count; i++) {
					writeFile.println(list[i].simpleString());
			}
			writeFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Cannot write to "+filename);
		}
	}
}