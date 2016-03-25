package csv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class CSVmenu
{

	private Scanner kb = new Scanner(System.in);
	private String input = "", fileName = "", courseSem = "", courseYear = "", courseNum = "", studentID = "", exportFile = "";
	ReadCSVmain read = new ReadCSVmain();
        Export myEx = new Export();
        fileReader myPars = new fileReader();
        
//        ArrayList<String> stu = new ArrayList<>();
//        ArrayList<Student> dents = new ArrayList<>();
//        ArrayList<String> key = new ArrayList<>();
//        String gogo = "";
//        Student myStu = new Student(gogo, key);
//        Files myFile = new Files(stu, dents);

	public void start(){
		while(!input.equalsIgnoreCase("e")){
			boolean isEntry = false;
			
			System.out.println("Please select from the following options:"
					+ "\n1) Enter ‘a’ or ‘A’ to add data."
					+ "\n2) Enter ‘s’ or ‘S’ to save data for a student."
					+ "\n3) Enter ‘g’ or ‘G' to return the number of students who got a specific grade in a specific course for a specific semester."
					+ "\n4) Enter ‘e’ or ‘E’ to exit the program.");
			input = kb.nextLine();

			if(input.equalsIgnoreCase("a")){
				addData();
				isEntry = true;
			}
			else if(input.equalsIgnoreCase("s")){
				saveData();
				isEntry = true;
			}
			else if(input.equalsIgnoreCase("g")){
				numberOfGradesData();
				isEntry = true;
			}
                       
			else if(!input.equalsIgnoreCase("e") && isEntry == false){
				System.out.println("Invalid entry!");
			}
		}
		System.out.println("Exiting program...");
	}

	//add exception handling for no data (valid file) added
	private void addData(){
		getCourseInfo();
                
                
		fileName = courseNum + "-" + courseSem + "-" + courseYear + ".csv";
		System.out.println(fileName);
		
                // Gives it the proper destination
                String myFile = System.getProperty("user.home") + "/Documents/" + fileName;
		File filer = new File(myFile);
                
		//read and extract data from file
                myPars.readFile(filer);
		
		
		//Print number of students in existing repository and those whose data was read
		System.out.println("Number of students in existing repository: ");
		System.out.println("Number of students whose data was read: ");
	}

	private void saveData(){
                // Still need to add functionality to this
		System.out.println("Please enter student ID:");
		studentID = kb.nextLine();
                
                // Asks for file from user then exports the file
                // to Documents
                fileReader myList = new fileReader();
                
                myEx.askFile();
                
		//find student data


	}

	private void numberOfGradesData(){
		getCourseInfo();
		if(!(courseNum.equalsIgnoreCase("none") && (courseSem.equalsIgnoreCase("none") || courseYear.equalsIgnoreCase("none")))){
			//return array of grades with [0] = numofAs, [1] = numofBs, [2] = numofCs, [3] = numofDs, [4] = numofFs
			int[] grades = new int[5];

	//		myFile.findAllGrades();
		}
	}

	private void getCourseInfo(){
            
		System.out.println("Please enter course number: ");
		courseNum = kb.nextLine();

		System.out.println("Please enter semester term (Fall/Spring):");
		courseSem = kb.next();
                
                System.out.println("Please enter semester year");
		courseYear = kb.next();
	}


}
