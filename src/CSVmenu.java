import java.util.Scanner;

public class CSVmenu
{
	public static void main(String[] args){
		CSVmenu menu = new CSVmenu();

		menu.start();
	}

	private Scanner kb;
	private String input = "", fileName = "", courseSem = "", courseYear = "", courseNum = "", studentID = "", exportFile = "";
	private Files files;
	private Export exp;
	private FileParser fp;
	boolean dataIn = false, isException = false;

	public void start(){
		kb = new Scanner(System.in);

		while(!input.equalsIgnoreCase("e")){
			System.out.println("Please select from the following options:"
					+ "\n1) Enter 'a' or 'A' to add data."
					+ "\n2) Enter 's' or 'S' to save data for a student."
					+ "\n3) Enter 'g' or 'G' to return the number of students who got a specific grade in a specific course for a specific semester."
					+ "\n4) Enter 'e' or 'E' to exit the program.");
			input = kb.next();

			if(input.equalsIgnoreCase("a")){
				addData();
				continue;
			}
			if(dataIn == false && (input.equalsIgnoreCase("s") || input.equalsIgnoreCase("g"))){
				System.out.println("----------");
				System.out.println("ERROR: No data in repository");
				System.out.println("----------");
				continue;
			}
			else if(input.equalsIgnoreCase("s")){
				saveData();
				continue;
			}
			else if(input.equalsIgnoreCase("g")){
				gradesData();
				continue;
			}
			else if(!input.equalsIgnoreCase("e")){
				System.out.println("---------------");
				System.out.println("Invalid entry!");
				System.out.println("---------------");
			}
		}
		kb.close();
		System.out.println("Exiting program...");
	}

	private void addData(){
		getCourseInfo();               
		fileName = courseNum + "-" + courseSem + "-" + courseYear + ".csv";

		fp = new FileParser(fileName);
		fp.readFile();

		isException = fp.getException();
		if(isException == true){
			return;
		}
		files = new Files(fileName);

		System.out.println("---------------");
		System.out.println("Number of students whose data was read: " + files.getStudentsAdded());
		System.out.println("Number of students in existing repository: " + files.getExistingStudents());
		System.out.println("---------------");
		dataIn = true;
	}

	private void saveData(){
		System.out.println("Please enter student ID:");
		studentID = kb.next();

		System.out.println("Please enter desired export file name:");
		exportFile = kb.next();

		String myFile = System.getProperty("user.home") + "/Documents/" + exportFile + ".csv";
		exp = new Export(studentID, myFile);
		exp.saveToCSV();

		System.out.println("---------------");
		System.out.println("File '" + exportFile + ".csv' saved to Documents folder");
		System.out.println("---------------");
	}

	private void gradesData(){
		getCourseInfo();
		if(!(courseNum.equalsIgnoreCase("none") && (courseSem.equalsIgnoreCase("none") || courseYear.equalsIgnoreCase("none")))){
			showGrades();
		}else System.out.println("Invalid input!");
	}

	private void getCourseInfo(){
		System.out.println("Please enter course number: ");
		courseNum = kb.next();

		System.out.println("Please enter semester term (Fall, Spring, Summer):");
		courseSem = kb.next();

		System.out.println("Please enter semester year:");
		courseYear = kb.next();
	}

	private void showGrades(){
		int[] grades = files.getGradesList(courseNum, courseSem, courseYear);

		System.out.println("---------------");
		System.out.println("Number of A's: " + grades[0]);
		System.out.println("Number of B's: " + grades[1]);
		System.out.println("Number of C's: " + grades[2]);
		System.out.println("Number of D's: " + grades[3]);
		System.out.println("Number of F's: " + grades[4]);
		System.out.println("---------------");
	}
}
