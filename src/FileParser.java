import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser
{

	private Scanner input = null;
	private File fileToRead;
	public ArrayList<String> data;
	private int numOfColumns = 0, numOfRows = 0;
	private boolean exception;

	public FileParser(String file){
		data = new ArrayList<String>();
		fileToRead = new File(file);
		exception = false;
		try{
			input = new Scanner(fileToRead);
		}
		catch(FileNotFoundException e){
			exception = true;

			System.out.println("---------------");
			System.out.println("ERROR: File '" + file + "' not found");
			System.out.println("---------------");
		}
	}

	public ArrayList<String> readFile(){
		if(input != null){
			while(input.hasNextLine()){
				String line = input.nextLine();
				String append = "";
				boolean isOpen = false, isMoreQ = false;
				numOfRows++;

				for(int i = 0, j = 1; j < line.length(); i++, j++){
					char here = line.charAt(i), there = line.charAt(j);

					if(here == ',' && there == ',' && isOpen == false){
						data.add(append);
						continue;
					}
					if(isMoreQ == true){
						isMoreQ = false;
						continue;
					}
					if(here == '\"' && there == ',' && isOpen == true){
						data.add(append);
						append = "";
						isOpen = false;
						if(numOfRows == 1){
							numOfColumns++;
						}
						continue;
					}
					if(here == '\"' && isOpen == false){
						isOpen = true;
						continue;
					}
					if(isOpen == true){
						if(here == '\"' && there == '\"'){
							isMoreQ = true;
							continue;
						}else append = append + here;
					}
					if(isOpen == false && here != ','){
						append = append + here;

						if(j == line.length()-1){
							if(there != '\"'){
								append = append + there;
							}
							data.add(append);
							append = "";
							if(numOfRows == 1){
								numOfColumns++;
							}
							continue;
						}
						if(there == ','){
							data.add(append);
							append = "";
							if(numOfRows == 1){
								numOfColumns++;
							}
						}
					}
					if(j == line.length()-1){
						append = append + there;
						if(!(append.equals(""))){
							data.add(append);
							append = "";
							isOpen = false;
							if(numOfRows == 1){
								numOfColumns++;
							}
						}
					}
					if(isOpen == true && here == '\"'){
						append = append + here;
					}
				}
			}
			input.close();
		}
		return data;
	}

	public boolean getException(){
		return exception;
	}

	public int getNumOfColumns(){
		return numOfColumns;
	}

	public int getNumOfRows(){
		return numOfRows;
	}
}
