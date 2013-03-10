package filehandling;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 41407
 */
public class FileReader {
    
    private File file;
   
    private Scanner scanner;

    private ArrayList<String> rawLines;

    public FileReader(String filePath) throws Exception {
        this.file = new File(filePath);
        scanner = new Scanner(file);
        this.rawLines = new ArrayList();
        rivitTalteen();
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
