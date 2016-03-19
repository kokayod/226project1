import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class csvReader
{
	
	ArrayList<String> data = new ArrayList<String>();
	
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
