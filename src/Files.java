import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Files
{
	//<FileName, [    ]>
	//           studentid(Hashmap)
	

	private HashMap <String, Student> classMap;
	
	public Files(ArrayList<String> fileNames, ArrayList<Student> studentMaps)
	{
		classMap = new HashMap <String, Student>();
		
		for(int i = 0; i < fileNames.size(); i++)
		{
			classMap.put(fileNames.get(i), studentMaps.get(i));
		}
	}
	
	public ArrayList<String> chooseFilesToRead(String year, String semester)
	{
		String[] fileNames = (String[]) classMap.keySet().toArray();
		
		ArrayList<String> filesToRead = new ArrayList<String>();
		
		for(int i = 0; i < fileNames.length; i++)
		{
			if(fileNames[i].contains(year) && semester.equals(""))
			{
				filesToRead.add(fileNames[i]);
			}
			
			else if(fileNames[i].contains(semester) && year.equals(""))
			{
				filesToRead.add(fileNames[i]);
			}
			
			else if(fileNames[i].contains(semester) && fileNames[i].contains(year))
			{
				filesToRead.add(fileNames[i]);
			}
			
			else
			{
				continue;
			}
		}
		
		return filesToRead;
	}

	public int[] findAllGrades(ArrayList<String> filesToRead)
	{
		int[] grades = new int[5];
		
		for(int i = 0; i < filesToRead.size(); i++)
		{
			
			
			String oneGrade = classMap.get(filesToRead).get();
		}
		
	}
	public ArrayList<String> findUniqueIDs(String file, HashMap <String, ArrayList<String>> students)
	{
		String[] temp = (String[]) students.keySet().toArray();
		
		ArrayList<String> uniqueIDs = new ArrayList<String>();
		
		ArrayList<String> allIDs = new ArrayList<String>(Arrays.asList(temp));  //this makes size of list fixed but shouldn't matter
																				//chnge to array since hashmap keeps track of unique keys
		for(int i = 0; i < allIDs.size(); i++)
		{
			if(uniqueIDs.contains(allIDs.get(i)))
			{
				continue;
			}
			
			else
			{
				uniqueIDs.add(allIDs.get(i));
			}
		}
		
		return uniqueIDs;
	}
}
