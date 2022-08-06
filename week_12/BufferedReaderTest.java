import java.io.*;

/**
   This program demonstrates reading a file using only
   a FileReader object.
*/

public class BufferedReaderTest
{
   public static void main(String[] args)
   {
      String rawData;        // To hold a character code
      char ch;            // To hold a character

      try
      {
         // Open the file.
         FileReader freader =
                new FileReader("GoodFile.txt");

         BufferedReader bReader = new BufferedReader(freader);
         // Read a character code from the file.
         
         rawData = bReader.readLine();

        
         while (rawData != null)
         {
            // Convert the code to a character.
           
            // Print the character.
            System.out.println(rawData);
            // Get the next code from the stream.
            rawData = bReader.readLine();
           
	   
         }

          System.out.println(rawData);
      }
      catch (IOException e)
      {
         System.out.println("Error: " +
                            e.getMessage());
      }
   }
}