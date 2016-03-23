import java.util.ArrayList;
import java.util.HashMap;


public class Student{
	//Student id + data
	//hash map : Studentid, ArrayList<Strin[]> (adds String[arrays] to arraylist)
	private HashMap <String, ArrayList<String>> studentMap;
	
	private ArrayList<HashMap> studentList = new ArrayList<HashMap>();
	
	
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
	
	
	public HashMap<String, ArrayList<String>> getStudentData(){
		return studentMap;
	}
	
	public int size()
	{
		return studentMap.size();
	}

}
