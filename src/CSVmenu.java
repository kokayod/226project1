import java.util.Scanner;


public class CSVmenu
{

	private Scanner kb = new Scanner(System.in);
	private String input = "", fileName = "", courseSem = "", courseYear = "", courseNum = "", studentID = "", exportFile = "";
	ReadCSVmain read = new ReadCSVmain();

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
//		getCourseInfo();
		fileName = courseNum + "-" + courseSem + "-" + courseYear + ".csv";
		System.out.println(fileName);
		//check here if file exist
		
		//read and extract data from file
//		read.extract(fileName);
		read.extract("380-fall-2002.csv");
		
		
		//Print number of students in existing repository and those whose data was read
		System.out.println("Number of students in existing repository: ");
		System.out.println("Number of students whose data was read: ");
	}

	private void saveData(){
		System.out.println("Please enter student ID:");
		studentID = kb.nextLine();

		System.out.println("Please enter the desired name for the exported student file:");
		exportFile = kb.nextLine();

		//find student data

		//export to csv file

	}

	private void numberOfGradesData(){
		getCourseInfo();
		if(!(courseNum.equalsIgnoreCase("none") && (courseSem.equalsIgnoreCase("none") || courseYear.equalsIgnoreCase("none")))){
			//return array of grades with [0] = numofAs, [1] = numofBs, [2] = numofCs, [3] = numofDs, [4] = numofFs
			int[] grades = new int[5];

			//
		}
	}

	private void getCourseInfo(){
		System.out.println("Please enter course number: ");
		courseNum = kb.nextLine();

		System.out.println("Please enter semester term and year:");
		courseSem = kb.next();
		courseYear = kb.next();
	}


}
