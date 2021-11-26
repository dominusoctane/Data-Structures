import java.util.ArrayList;
import java.util.Scanner;

public class DeQueRun {
	//Sorts an ArrayList of Integer type, and returns the sorted ArrayList
	public static ArrayList<Integer> sort(ArrayList<Integer> arr){
		int temp = 0;
		// an algorithim of O(n^2) that sorts the values from lowest to highest
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				if (arr.get(i) > arr.get(j)) {
					temp = arr.get(i);
					arr.set(i,arr.get(j));
					arr.set(j, temp);
				}
			}
		}
		return arr;
	}
	//Inserts a value into the DeQueDLL object
	public static DeQueDLL<Integer> insert(int value, DeQueDLL<Integer> deq) {
		// Initiate objects of the ArrayList and DeQueDLL classes
		ArrayList<Integer> arr = new ArrayList<Integer>();
		DeQueDLL<Integer> deque = new DeQueDLL<Integer>();
		
		//adds the value to an ArrayList of Integer type
		arr.add(value);
		
		// Checks if deq is empty
		if (!deq.isEmpty()) {
			// As long front is not equal to null, the values returned from the dequeueFront method
			// will be added to the Arraylist of Integer type
			while(deq.front != null) {
				arr.add(deq.dequeueFront());
			}
		}
		// uses the sort method to sort the numbers from lowest to highest
		sort(arr);
		// enqueues the values in the sorted array into the front of the deque
		for (int i = 0; i < arr.size(); i++) {
			//System.out.println(arr.get(i));
			deque.enqueueFront(arr.get(i));
		}
		return deque;
	}
	// Deletes a value from the DeQueDLL object
	public static DeQueDLL<Integer> delete(int value, DeQueDLL<Integer> deq){
		// Initiate objects of the ArrayList and DeQueDLL classes
		ArrayList<Integer> arr = new ArrayList<Integer>();
		DeQueDLL<Integer> deque = new DeQueDLL<Integer>();
		// a boolean to check if the value exists in the deque
		boolean exists = false;
		
		// Checks if deq is empty
		if (!deq.isEmpty()) {
			// As long front is not equal to null, the values returned from the dequeueFront method
			// will be added to the Arraylist of Integer type
			while(deq.front != null) {
				arr.add(deq.dequeueFront());
			}
		}
		// A for loop that finds the index of the ArrayList that is equal to value
		// It removes the integer at that index
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i) == value) {
				arr.remove(i);
				exists = true;
			}
		}
		// If the input value cannot be found, then it prints out this message
		if(exists == false) {
			System.out.println(value +" does not exist in the deque");
		}
		
		// uses the sort method to sort the numbers from lowest to highest
		sort(arr);
		// enqueues the values in the sorted array into the front of the deque
		for (int i = 0; i < arr.size(); i++) {
			//System.out.println(arr.get(i));
			deque.enqueueFront(arr.get(i));
		}
		return deque;
	}

	
	public static void main(String args[]) {
		// Initiate a scanner object
		Scanner sc = new Scanner(System.in);
		// Initiate variables
		int choice = 0;
		int value = 0;
		boolean yes = true;
		// Creates a DeQueDLL<Integer> object
		DeQueDLL<Integer> deque = new DeQueDLL<Integer>();
		
		
		// A while loop that continues to run until choice == 3.
		// It prompts the user to type in 1 for insert, 2 for delete, or 3 for quit.
		while(yes == true) {
			System.out.println("Please type in 1 for insert, 2 for delete, or 3 for quit");
			
			choice = sc.nextInt();
			// If choice is 1, then it will ask for the next integer input, and
			// use the insert method to return a new DeQueDLL<Integer> object
			// that will reassigned to deque
			if (choice == 1) {
				System.out.println("Enter an integer to insert into the deque");
				value = sc.nextInt();
				deque = insert(value, deque);
			}
			// If choice is 2, then it will ask for the next integer input, and
			// check if the DeQueDLL<Integer> is empty. If it is not empty, it will
			// use the delete method to return a new DeQueDLL<Integer> object
			// that will reassigned to deque
			else if (choice == 2) {
				if (deque.isEmpty())
					System.out.println("The deque is empty");
				else {
					System.out.println("Enter an integer to remove from the deque");
					value = sc.nextInt();
					
					deque = delete(value, deque);
				}
			}
			// If choice is 3, then the program will stop running
			else if (choice == 3) {
				yes = false;
			}
			// If the input does not match 1, 2, or 3, then it will prompt this message
			else {
				System.out.println("Please type in one of the valid options that were given");
			}
			//Prints out the DeQueDLL object as a string
			System.out.println("Deque:" + deque.toString());
		}
		
		System.out.println("Goodbye!");
		
	}
	

}
