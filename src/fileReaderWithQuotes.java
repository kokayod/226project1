import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class fileReaderWithQuotes
{
	
	ArrayList<ArrayList<ArrayList<ArrayList<String>>>> everything = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();
	ArrayList<ArrayList<ArrayList<String>>> files = new ArrayList<ArrayList<ArrayList<String>>>();
	ArrayList<ArrayList<String>> students = new ArrayList<ArrayList<String>>();
	ArrayList<String> data = new ArrayList<String>();
	
	public void readFile(File fileToRead)
	{
		
		Scanner input = null;
		
		try
		{
			input = new Scanner(fileToRead);
			
			while(input.hasNextLine())
			{
				String line = input.nextLine();
				
				boolean quoted = false;
				
				int placeholder = 0;
				
				String quoteTemp = "";
				
				for(int i = 0; i < line.length(); i++)
				{
					char debugTester = line.charAt(i);
					if(line.charAt(i) == '\"')
					{
						if(quoted == false)
						{
							quoted = true;
							continue;
						}
						
						if(quoted == true)
						{
							System.out.println("quoteTemp: " + quoteTemp);
							data.add(quoteTemp);
							
							quoteTemp = "";
							
							quoted = false;
							
							placeholder = i;
							
//							i = i + 1;
							
						}
					}
					
					if(quoted == true)
					{
						if(line.charAt(i) == '\"')
						{
							i++;
						}
						
						quoteTemp = quoteTemp + line.charAt(i);
					}
					
					if(line.charAt(i) == ',' && quoted == false)
					{
						
						data.add(line.substring(placeholder, i));
						
//						System.out.println("here:" + line.substring(placeholder, i) + ":stop");
						
						placeholder = i;
					}		

				}

				students.add(data);
				
				data = new ArrayList<String>();
			}
			
			files.add(students);
			
			students = new ArrayList<ArrayList<String>>();
			
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Error: File was not found");
		}
		
		everything.add(files);
	}
	
	public ArrayList<ArrayList<ArrayList<ArrayList<String>>>> getData()
	{
		return everything;
	}

	
}
