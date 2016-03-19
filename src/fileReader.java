import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class fileReader
{
	
//	ArrayList<ArrayList<ArrayList<ArrayList<String>>>> everything = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();
//	ArrayList<ArrayList<ArrayList<String>>> files = new ArrayList<ArrayList<ArrayList<String>>>();
//	ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
	ArrayList<String> data = new ArrayList<String>();
	
	//Have arraylist be added to regular array at end and send out
	public void readFile(File fileToRead)
	{
		
		Scanner input = null;
		
		try
		{
			input = new Scanner(fileToRead);
			
			while(input.hasNextLine())
			{
				
					String temp = (input.nextLine());
					
					StringTokenizer parser = new StringTokenizer(temp, ",");
					
					while(parser.hasMoreTokens())
					{
						String testVar = parser.nextToken();

						data.add(testVar);
					}
				
			}
			
			
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Error: File was not found");
		}
		
	}
	
	public String[] getData()
	{
		String[] studentData = new String[data.size()];
		
		for(int i = 0; i < data.size(); i++)
		{
			studentData[i] = data.get(i);
		}
		
		return studentData;
	}

	
}
