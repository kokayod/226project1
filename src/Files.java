import java.util.ArrayList;
import java.util.HashMap;


public class Files
{
	//<FileName, [    ]>
	//           studentid(Hashmap)
	

	private HashMap <String, Student> classMap;

	
	public Files(ArrayList<String> fileNames, Student students)
	{
		classMap = new HashMap <String, Student>();
		
		Student student = null;
		
		for(int i = 0; i < fileNames.size(); i++)
		{
//			student = new Student(findID(), )
			classMap.put(fileNames.get(i), students);
		}
	}
	
	private int findIDpos(ArrayList<String> stuData){
		//for loop traversing key positions to compile data 
	}
	
	private ArrayList<String> findUniqueIDs(String file, Student students)
	{
		ArrayList<String> uniqueIds = new ArrayList<String>();
		
		for(int i = 0; i < students.size(); i++)
		{
			if(uniqueIds.contains())
		}
		
		return null;
	}
}
