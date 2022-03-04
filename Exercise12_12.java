package Ex12_12;

import java.util.*;
import java.io.*;
public class Exercise12_12 {

  public static Scanner scnr = new Scanner(System.in);
  private static StringBuilder buffer = new StringBuilder();
  
  
  private static void checkComParam(String[] args) {
    if (args.length != 1) {
      System.out.println(
        "Usage: java Exercise12_12 filename");
      System.exit(1);
    }
  }
  
  private static void openFile(File sourceFile) {
    if (!sourceFile.exists()) {
       System.out.println("Source file " + sourceFile.toString() + " not exist");
       System.exit(2);
    }
  }
  
  public static void readWrite(Scanner inputFile) {
    while (inputFile.hasNext()) {
      String s = inputFile.nextLine();
      String trimmed = s.trim();
      addToBuffer(trimmed, s);
    }
    inputFile.close();
    return; 
  }
  
  public static void addToBuffer(String trimmed, String s) {
    if (trimmed.charAt(0) == '{') {
      buffer.append(" {");
      if (trimmed.length() > 1) buffer.append("\r\n" + s.replace('{', ' '));
    }
    else
      buffer.append("\r\n" + s);
    return;
  }
  
  private static void printToFile(File sourceFile) throws IOException {
    PrintWriter output = new PrintWriter(sourceFile);
    output.print(buffer.toString());
    output.close();
    return;
  }
  
  public static String getBuffer() {
    return buffer.toString();
  }
  
  
  public static void main(String[] args) throws Exception {
    File sourceFile = new File(args[0]);
    // Check command line parameter usage
    checkComParam(args);
    // Check if source file exists
    openFile(sourceFile);
    // Read source file and write new format to StringBuffer
    readWrite(new Scanner(sourceFile));
    // Write buffer into the file
    printToFile(sourceFile);
  }
  

}

