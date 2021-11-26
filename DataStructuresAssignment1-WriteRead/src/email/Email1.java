package email;

/**This program is responsible for generating any number of textfiles 
 * based on the number of people listed in the people.txt, and
 * replaces the name, age, and gender respectively in the template.txt
 * 
 * References: 
 * Jack Bielinski, Jake George, Carl Sustar, Jaison Jacob
 * 
 *
 * @author Tyrell To
 * @version <Created: 9/1/19, Modified: 9/4/19 - Assignment 1>
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Email1 {
	
	public static void main(String[] args) throws IOException {
		// Change the location of the files in respect to your own computer
		// Accessing the people.txt
		FileInputStream people = new FileInputStream("people.txt"); 
		//File people = new File("C:\\Users\\tyrel\\eclipse-workspace\\DataStructures\\src\\email\\people.txt");
		BufferedReader preader = new BufferedReader(new FileReader(people));
		Scanner fromPeople = new Scanner(people);
		
		// Accessing the template.txt
		FileInputStream template = new FileInputStream("template.txt");
		//File template = new File("C:\\Users\\tyrel\\eclipse-workspace\\DataStructures\\src\\email\\template.txt");
		Scanner fromTemplate = new Scanner(template);
		

		// Determines the number of lines
		int line = 0;
		while (preader.readLine() != null) {
			line++;
		}
		preader.close();
		
		// Copies the template.txt into a string		
		String lot = "";
		while (fromTemplate.hasNextLine()) {
			lot = lot + fromTemplate.nextLine() + "\r\n";
		}
		fromTemplate.close();
		
		
		// Initiate arrays for storing data from people.txt
		String[] nameArray = new String[line];
		int[] ageArray = new int[line];
		String[] genderArray = new String[line];
		
		// Stores data into arrays
		int count = 0;
		while (fromPeople.hasNextLine()) {
			nameArray[count] = fromPeople.next();
			ageArray[count] = fromPeople.nextInt();
			genderArray[count] = fromPeople.next();
			count++;
			}
		fromPeople.close();
		
		
		Set<String> store = new HashSet<>();
		ArrayList<String> peopleList = new ArrayList<String>();
	
		// Determines the amount of people without duplicate names
		for (String name: nameArray) {
			if(store.add(name) == true) {
				peopleList.add(name);
			}
		}
		
		// Makes a counter for number of people
		int[] check = new int[peopleList.size()];
		
		
		for(int i = 0; i < peopleList.size(); i++) {
			check[i]++;
		}
		

		// A for loop that is responsible for creating new textfiles with different names, ages, and genders respectively.
		for (int i = 0; i < count; i++) {
			String current = lot;
			current = current.replace("<<N>>", nameArray[i]);
			current = current.replace("<<A>>", Integer.toString(ageArray[i]));
			current = current.replace("<<G>>", genderArray[i]);
			File file = new File(nameArray[i] + ".txt");
			FileWriter fwriter;
			
			if (file.exists()){
				fwriter = new FileWriter(nameArray[i] + "-" + check[peopleList.indexOf(nameArray[i])]++ + ".txt");
			}
			else {
				fwriter = new FileWriter(nameArray[i] + ".txt");
			}
			fwriter.write(current);		
			fwriter.close();
			

		}

		
		

	}

}
