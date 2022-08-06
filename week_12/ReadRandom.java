import java.io.*;

/**
   This program uses the RandomAccessFile class to open
   the file Letters.dat and randomly read letters from
   different locations.
*/

public class ReadRandom
{
   public static void main(String[] args) throws IOException
   {
      final int CHAR_SIZE = 2;// 2 byte characters
      long byteNum;           // The byte number
      char ch;                // A character from the file
      
      // Open the file for reading.
      RandomAccessFile randomFile =
                  new RandomAccessFile("Letters.dat", "r");
      
      // Move to the character 5. This is the 6th 
      // character from the beginning of the file.
      for(long i=0; i<26;i++){

      randomFile.seek(CHAR_SIZE*i);
      
     
      ch = randomFile.readChar();
      System.out.println(ch);
      
      }
      
      // Close the file.
      randomFile.close();
   }
}