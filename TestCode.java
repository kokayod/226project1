/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcode;

/**
 *
 * @author marlf
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        thoughtProcess sup = new thoughtProcess();
//        
//        sup.saveData("/Users/marlf/Documents/testerFile.csv");
        
        BufferedReader fileBuffer = null;
        		try {
			String line;
			fileBuffer = new BufferedReader(new FileReader("/Users/marlf/Documents/437-fall-2002.csv"));
			
			// Print out data
			while ((line = fileBuffer.readLine()) != null) {
				System.out.println("Raw CSV data: " + line);
				System.out.println("Converted ArrayList data: " + arrayListConvert(line) + "\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileBuffer != null) fileBuffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static ArrayList<String> arrayListConvert(String csvFile) {
		ArrayList<String> result = new ArrayList<String>();
		
		if (csvFile != null) {
			String[] splitData = csvFile.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					result.add(splitData[i].trim());
				}
			}
		}
		
		return result;
	}
    }


