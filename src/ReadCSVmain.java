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

	ArrayList<ArrayList<ArrayList<String>>> repository = new ArrayList<ArrayList<ArrayList<String>>>();
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
