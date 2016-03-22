import java.util.ArrayList;
import java.util.HashMap;


public class Student{
	//Student id + data
	//hash map : Studentid, ArrayList<Strin[]> (adds String[arrays] to arraylist)
	private HashMap <String, ArrayList<String>> studentMap;
	
	
	public Student(String ID, ArrayList<String> studentData){
		studentMap = new HashMap <String, ArrayList<String>>();

		for(int i = 0; i < studentData.size(); i++){
					studentMap.put(ID, studentData);
		}
		
		
	}
	
	public HashMap getStudentData(){
		return studentMap;
	}
	
	public int size()
	{
		return studentMap.size();
	}

}
