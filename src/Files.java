import java.util.ArrayList;
import java.util.HashMap;

public class Files
{
	static HashMap <String, ArrayList<String>> classMap;
	private ArrayList<String> fileData;
	private FileParser reader;
	private static int numOfStudents = 0, studentsAdded = 0;
	private boolean isException;

	static{
		classMap = new HashMap <String, ArrayList<String>>();
	}

	public Files(String fileName){
		reader = new FileParser(fileName);
		isException = reader.getException();
		if(isException == false){
			fileData = reader.readFile();

			classMap.put(fileName, fileData);	
			studentsAdded = reader.getNumOfRows() - 1; 
			numOfStudents += studentsAdded;
		}
	}

	public int[] getGradesList(String num, String sem, String year){
		int[] gradeList = new int[5];
		String fileName = num + "-" + sem + "-" + year + ".csv";

		for(String key: classMap.keySet()){
			FileParser temp = new FileParser(fileName);
			fileData = temp.readFile();

			for(int j = temp.getNumOfColumns() - 1; j < classMap.get(key).size(); j += temp.getNumOfColumns()){
				if(key.equalsIgnoreCase((fileName)) || key.contains((sem + "-" + year)) || key.contains((num))){
					String grade = classMap.get(key).get(j);

					switch(grade){
					case "A":
						gradeList[0]++;
						break;

					case "B":
						gradeList[1]++;
						break;

					case "C":
						gradeList[2]++;
						break;

					case "D":
						gradeList[3]++;
						break;

					case "F":
						gradeList[4]++;
						break;
					}
				}else
					System.out.println("File does not exist!");
			}
		}
		return gradeList;
	}

	public int getNumberOfStudents(){
		return numOfStudents;
	}

	public int getStudentsAdded(){
		return studentsAdded;
	}

	public int getExistingStudents(){
		int existingStudents = numOfStudents-studentsAdded;

		if(existingStudents < 0 ){
			existingStudents = 0;
		}
		return existingStudents;
	}
}
