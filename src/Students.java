import java.util.ArrayList;
import java.util.HashMap;

public class Students{

	static HashMap <String, ArrayList<String>> files, studentMap;
	private FileParser fp;

	public Students(){
		studentMap = new HashMap <String, ArrayList<String>>(); 
		files = Files.classMap;
	}

	public void here(String stuID){
		ArrayList<String> stuData = new ArrayList<String>();

		for(String key: files.keySet()){
			ArrayList<String> rawData = files.get(key);

			int IDindex = findPosition("Student ID", rawData), grade = 0;

			if(IDindex == -1){
				IDindex  = findPosition("User ID", rawData);
			}
			if(IDindex != -1){
				grade -= IDindex;
				IDindex = findPosition(stuID, rawData);
				if(IDindex == -1){
					System.out.println("---------------");
					System.out.println("ERROR: Invalid ID entry!");
					System.out.println("---------------");
					return;
				}
				grade += IDindex;

				fp = new FileParser(key);
				fp.readFile();

				int endRow = IDindex + (fp.getNumOfColumns()-1) - (IDindex % fp.getNumOfColumns())+1;
				String keyShort = key.substring(0, key.length()-4) + "-";
				grade += fp.getNumOfColumns()-1;

				for(int i = IDindex + 1; i < endRow; i++){
					int assnIndex = findPosition(rawData.get(i), rawData);

					if(isInteger(rawData.get(i)) && !rawData.get((i % fp.getNumOfColumns())).equalsIgnoreCase("Total")){
						if(assnIndex != -1){
							int j = i % fp.getNumOfColumns();
							String found = rawData.get(j);
							stuData.add(keyShort + found);
						}
					}
				}
				stuData.add(keyShort + rawData.get((grade)));
				studentMap.put(rawData.get(IDindex), stuData);
			}else 
				System.out.println("Cannot determine unique IDs for students. "
						+ "Please make sure ID columns are labeled \"Student ID\" or \"User ID\"");
		}
	}

	public boolean isInteger(String input){
		try{
			Integer.parseInt(input);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	private int findPosition(String keyword, ArrayList<String> rawData){		
		int pos = -1;
		for(int j = 0; j < rawData.size(); j++){
			if(rawData.get(j).equalsIgnoreCase(keyword)){
				pos = j;
				break;
			}
		}
		return pos;
	}

	public ArrayList<String> getStudentData(String ID){
		return studentMap.get(ID);
	}

	public int size(){
		return studentMap.size();
	}
}
