package Ex12_12;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ReadWriteTest {

  @Test
  void testReadWrite() throws IOException {
    String expected = "\r\npublic class Test {\r\n  public static void main(String[] args) {\r\n    //Some Statements\r\n  }\r\n}";
    String actual;
    Scanner userIn = new Scanner(System.in);
    
    //Open testing file
    System.out.println("Enter the file \"TestingReadWrite.txt\"");
    File sourceFile = new File(userIn.next());
    while (!sourceFile.exists()) {
      System.out.println("Source file " + sourceFile.toString() + " does not exist.");
      System.out.println("Open TestingReadWrite.txt with a valid directory.");
      sourceFile = new File(userIn.next());
    }
    
    //Retrieve actual output using test file
    Exercise12_12.readWrite(new Scanner(sourceFile));
    actual = Exercise12_12.getBuffer();
    //System.out.println(actual);
    //System.out.println(expected);
    //System.out.println(expected.equals(actual));
    
    //Compare
    if(!actual.equals(expected)) {
      System.out.println("The output did not match.");
      System.out.println("Please verify file TestingReadWrite.txt was used, and try again.");
    }
    Assert.assertTrue(actual.equals(expected));
    
  }

}
