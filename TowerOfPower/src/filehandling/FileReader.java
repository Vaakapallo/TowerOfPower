package filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 41407
 */
public class FileReader {
    
    private File file;
   
    private Scanner scanner;

    private ArrayList<String> rawLines;

    public FileReader(String filePath) {
        try {
            this.file = new File(filePath);
            scanner = new Scanner(file);
            this.rawLines = new ArrayList();
            rivitTalteen();
        } catch (FileNotFoundException ex) {
            rawLines = null;
        }
    }
   
    private void rivitTalteen() {
        while (scanner.hasNext()) {
            rawLines.add(scanner.nextLine());
        }
    }

    public ArrayList<String> getRivit() {
        return rawLines;
    }
}
