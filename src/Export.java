/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author marlf
 */
public class Export {

    ArrayList<String> keys = new ArrayList<>();

    
    public Export()
    {
        
    }
    
    // Accepts ArrayList from other file for use here
    public ArrayList getArrayList(ArrayList CSVList)
    {
        keys = CSVList;
        return keys;
    }
    
    // Asks for a file name from the user
    public void askFile()
    {

        Scanner myIn = new Scanner(System.in);
        
        System.out.println("Please print file name.");
        String file = myIn.next();
       
        String myFile = System.getProperty("user.home") + "/Documents/" + file + ".csv";
        
        saveToCSV(myFile);
        
        System.out.println("File " + file + " saved to Documents folder.");
        
       
    }
    
    public void saveToCSV(String FileName)
    {
        
        try{
            
        // Use other class to input a Export.saveToCSV(~name of file~)
        FileWriter writer = new FileWriter(FileName);
               
        for(int i = 0; i < keys.size(); i++)
        {
            writer.append(keys.get(i));
            writer.append(',');
        }
       
         writer.flush();
         writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
    
    //        public void saveToCSV()
//    {
//        StringBuilder keyRow = new StringBuilder();
//    
//        Iterator keys = studentMap.keySet().iterator();
//        Map<String, ArrayList> values = new HashMap<>();
//        boolean notFirst = true;
//        
//        while(keys.hasNext())
//        {
//        String key = (String)keys.next();
//        ArrayList list = (ArrayList)studentMap.get(key);
//        if(!notFirst)
//        {
//            keyRow.append(",");
//
//        }
//        
//        keyRow.append(key);
//
//        notFirst = false;
//    }
}
