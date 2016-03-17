import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class fileReader
{
	
	ArrayList<ArrayList<ArrayList<ArrayList<String>>>> everything = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();
	ArrayList<ArrayList<ArrayList<String>>> files = new ArrayList<ArrayList<ArrayList<String>>>();
	ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
	ArrayList<String> data = new ArrayList<String>();
	
	public void readFile(File fileToRead)
	{
		
		Scanner input = null;
		
		try
		{
			input = new Scanner(fileToRead);
			
			while(input.hasNextLine())
			{
				
					String[] temp = (input.nextLine().split(","));
					
					for(int i = 0; i < temp.length;i++)
					{
						data.add(temp[i]);
						rows.add(data);
						data = new ArrayList<String>();
						
//						System.out.println(temp[i]);
					}
				
				
				files.add(rows);
				everything.add(files);
				
				rows = new ArrayList<ArrayList<String>>();
				
			}
			
			
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Error: File was not found");
		}
		
	}
	
	public ArrayList<ArrayList<ArrayList<ArrayList<String>>>> getData()
	{
		return everything;
	}

	
}
