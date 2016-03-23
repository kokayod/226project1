import java.util.ArrayList;
import java.util.HashMap;


public class Student{

	private HashMap <String, ArrayList<String>> studentMap;
	
	
	public Student(String ID, ArrayList<String> studentData){
		studentMap = new HashMap <String, ArrayList<String>>();

		for(int i = 0; i < studentData.size(); i++){
					studentMap.put(ID, studentData);
		}
		
		
	}
	
	private int findIDpos(ArrayList<String> stuData, String data){
		//for loop traversing key positions to compile data 
		
		int pos = 0;
		for(int i = 0; i < stuData.size(); i++)
		{
			if(stuData.get(i).equals(data))
			{
				pos = i;
			}	
		}
		
		return pos;
	}
	
	public int[] getGradesForThisFile()
	{
		int[] gradesForThisFile = new int[5];
		
		String[] studentIDs = (String[]) studentMap.keySet().toArray();
		for(int i = 0; i < studentMap.size(); i++)
		{
			String ID = studentIDs[i];
			
			String grade = studentMap.get(ID).get(studentMap.get(i).size() - 1);
			
			switch(grade)
			{
			
			case "A":
				gradesForThisFile[0] = gradesForThisFile[0] + 1;
				break;
				
			case "B":
				gradesForThisFile[0] = gradesForThisFile[1] + 1;
				break;
				
			case "C":
				gradesForThisFile[0] = gradesForThisFile[2] + 1;
				break;
				
			case "D":
				gradesForThisFile[0] = gradesForThisFile[3] + 1;
				break;
				
			case "F":
				gradesForThisFile[0] = gradesForThisFile[4] + 1;
				break;
			}
		}
		
		return gradesForThisFile;
	}
	
	public HashMap<String, ArrayList<String>> getStudentData(){
		return studentMap;
	}
	
	public int size()
	{
		return studentMap.size();
	}

}
