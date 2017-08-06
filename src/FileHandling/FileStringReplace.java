package FileHandling;
/**
 * In here importing classes, which are belong from java.io.package
 */
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 /**
  * 
  * @author Vishwas
  * Creating a class FileStringReplace and and 
  * stringReplace method and passing arguments
  *
  */
public class FileStringReplace
{    
    static void stringReplace(String filePath, String oldString, String newString)
    {
    	/**
    	 * In here creating object of file class 
    	 * and declaring of oldStringChange
    	 * 
    	 */
        File ModifyInfile = new File(filePath);
         
        String oldStringChange = "";
         /**
          *  creating instance of BufferedReader and initializing by null;
          *  and also creating instance of FileWriter and initializing by null;
          *  than creating a try and catch to handling exception 
          */
        BufferedReader buffReader = null;
        
        FileWriter fileWriter = null;
         
        try
        {
        	/**
        	 * in here initializing buffReader and in the 
        	 * BufferedReader constructor calling FileReader and 
        	 * passing ModifyInfile and than declaring variable than 
        	 * 
        	 */
        	buffReader = new BufferedReader(new FileReader(ModifyInfile));
             
            String line = buffReader.readLine();
             /**
              * In here i've created  a while loop to read every line
              * in this while loop assigning each line which 
              * will read from the file, to this 'line' variable 
              * to this checking file is null or not, 
              * if null out of the loop than print the file.
              */
            while ((line = buffReader.readLine())!= null) 
            {
            	oldStringChange = oldStringChange + line + System.lineSeparator();
                 
                line = buffReader.readLine();
            }
             
            //Replacing old word with new word..
             
            String newContent = oldStringChange.replaceAll(oldString, newString);
             
            fileWriter = new FileWriter(ModifyInfile);
             
            fileWriter.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                 
            	buffReader.close();
                 
            	fileWriter.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
     /**
      * creating main method and calling 
      * stringReplace method and in constructor
      * passing path of the file and replacing 
      * word 'sam' to 'vishwas'  than printing the window console
      *         
      */
    public static void main(String[] args)
    {
    	stringReplace("E:/File In Java/DemoString.txt", "sam", "vishwas");
         
        System.out.println("\nYou've successfully replace specific String in text file");
    }
}
