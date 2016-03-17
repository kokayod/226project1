import java.io.File;
import java.util.ArrayList;


public class readTest
{

	public static void main(String[] args)
	{
		File file = new File("test.csv");
		
		fileReader reader = new fileReader();
		
		reader.readFile(file);
		
		ArrayList<ArrayList<ArrayList<ArrayList<String>>>> allData = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();
		
		allData = reader.getData();
		
		System.out.println(allData.get(0));
		System.out.println(allData.get(1));
		System.out.println(allData.size());

	}

}
