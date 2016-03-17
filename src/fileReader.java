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
						
						//if test var has more than one quote, continue
						
						int quoteCount = testVar.length() - testVar.replace("\"", "").length();
						
						if(testVar.contains("\"") && quoteCount == 1)
						{
							String addTemp = parser.nextToken();
							String quoteTemp = testVar + "," + addTemp;

							while(!addTemp.contains("\""))
							{
								
								addTemp = parser.nextToken();
								quoteTemp = quoteTemp + "," + addTemp;
								
							}

							quoteTemp = quoteTemp.replace("\"", "");
							
							data.add(quoteTemp);
							quoteCount = 0;
							continue;
						}
						
						
						data.add(testVar);
					}
					
//				rows.add(data);
//				
//				data = new ArrayList<String>();
//				
//				files.add(rows);
//				
//				everything.add(files);
//				
//				rows = new ArrayList<ArrayList<String>>();
				
			}
			
			
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Error: File was not found");
		}
		
	}
	
	public ArrayList<String> getData()
	{
		return data;
	}

	
}
