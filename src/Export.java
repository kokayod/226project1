import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Export {

	private ArrayList<String> studentData;
	private Students student;
	private FileWriter writer;
	private String ID;

	public Export(String ID, String fileName){
		student = new Students();
		this.ID = ID;
		try{
			writer = new FileWriter(fileName);
			writer.append(ID);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void saveToCSV(){
		student.here(ID);
		studentData = Students.studentMap.get(ID);
		try{	
			for(int i = 0; i < studentData.size(); i++){
				writer.append(',');
				writer.append(studentData.get(i));
			}
			writer.flush();
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
