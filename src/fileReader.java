import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class fileReader
{

	private Scanner input = null;
	public ArrayList<String> data;
	private int numOfColumns = 0, numOfRows = 0;

	public ArrayList<String> readFile(File fileToRead){

		try{
			input = new Scanner(fileToRead);
			data = new ArrayList<String>();

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
		}catch(FileNotFoundException e){
			System.out.println("Error: File was not found");
		}
		return data;
	}

	public int getnumOfColumns(){
		return numOfColumns;
	}

	public int getnumOfRows(){
		return numOfRows;
	}


}
