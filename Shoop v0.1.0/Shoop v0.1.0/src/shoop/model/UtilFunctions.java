package shoop.model;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.text.DateFormat;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**Class used for various operations
 * @author Francisco Gonzalez
 */
public class UtilFunctions
{
/**Method used to convert characters to numbers
 * 
 * @param string
 * @return 
 */
     public static int stringToInteger(String string)
    {
        return Integer.parseInt(string);
    }
    /**Method used to convert numbers to characters
     * 
     * @param integer
     * @return 
     */
    public static String integerToString(int integer)
    {
        return Integer.toString(integer);
    }
    /**Method used to eliminate particular characters and replace it for new ones
     * 
     * @param string
     * @return 
     */
    public static String removeStrangeCharacters(String string)
    {
        string.replace("¡", "!");
        string.replace("ñ", "n");
        
        return string;
    }
    
      /**
     * List all the files and folders from a directory
     * @param directoryName to be listed
     */
    public static void listFilesAndFolders(String directoryName)
    {
 
        File directory = new File(directoryName);
 
        //get all the files from a directory
        File[] fList = directory.listFiles();
 
        for (File file : fList){
            System.out.println(file.getName());
        }
    }
 
    /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public static void listFiles(String directoryName)
    {
 
        File directory = new File(directoryName);
 
        //get all the files from a directory
        File[] fList = directory.listFiles();
 
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getName());
            }
        }
    }
 
    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public static void listFolders(String directoryName)
    {
 
        File directory = new File(directoryName);
 
        //get all the files from a directory
        File[] fList = directory.listFiles();
 
        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getName());
            }
        }
    }
 
    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     */
    public static void listFilesAndFilesSubDirectories(String directoryName)
    {
        File directory = new File(directoryName);
 
        //get all the files from a directory
        File[] fList = directory.listFiles();
 
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }

    public static  String changeDatToString (Date birthDay)
    {
         DateFormat Df;
            
         Df = new SimpleDateFormat("dd/MM/yyyy");
       
         return Df.format(birthDay);
    }

    

    public static  Date changeStringToDate(String birthDay){
            DateFormat Df;
            Date Date = null;
            
            Df = new SimpleDateFormat("dd/MM/yyyy");
        try {
           
            Date = Df.parse(birthDay);
            
           
        } catch (ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
         return Date;
        }
   }
}


