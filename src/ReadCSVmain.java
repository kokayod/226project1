import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class ReadCSVmain
{

	public static void main(String[] args){

		CSVmenu menu = new CSVmenu();

		menu.start();

	}

	//	Arrayist<Student> students = new ArrayList<Student>();
	//
	//	BufferedReader br = new BufferedReader(new FileReader(new File("path/to/your/file.csv")));
	//	String line;
	//	while ((line = br.readLine()) != null) {
	//
	//	    String[] entries = line.split(",");
	//
	//	    Student owner = new Student();
	//
	//	    students.add(owner);


	ArrayList<String> students = new ArrayList<String>();
	ArrayList<String> semester = new ArrayList<String>();
	ArrayList<String> course = new ArrayList<String>();
	Scanner inputFile = null;
	

	public void extract(String file){
		try{
			File f = new File (new File(file).getAbsolutePath());
			inputFile = new Scanner(f);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
	    while(inputFile.hasNext()){
		    String line = inputFile.nextLine();
		
		
	    }
		
		
		
		
		
		
	    inputFile.close();
	}
}
