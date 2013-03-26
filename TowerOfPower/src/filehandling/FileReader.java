package filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that is used to read a file and store its content into an arraylist
 * of lines.
 * 
 * @author 41407
 */
public class FileReader {
    
    /**
     * File in question
     */
    private File file;
   
    /**
     * Scanner to read the file
     */
    private Scanner scanner;

    /**
     * Arraylist to return
     */
    private ArrayList<String> rawLines;

    /**
     * If file is found, collects its contents into an arraylist, line by line.
     * If no file is found, the resulting arraylist will be null.
     * 
     * @param filePath Path to the file, starting from the project root.
     */
    public FileReader(String filePath) {
        try {
            this.file = new File(filePath);
            scanner = new Scanner(file);
            this.rawLines = new ArrayList();
            storeLines();
        } catch (FileNotFoundException ex) {
            rawLines = null;
        }
    }
   
    /**
     * Stores the file's content into an arraylist.
     */
    private void storeLines() {
        while (scanner.hasNext()) {
            rawLines.add(scanner.nextLine());
        }
    }

    public ArrayList<String> getRivit() {
        return rawLines;
    }
}
