/**
 * This program displays the arguments passed to
 * it from the operating system command line.
 */

// File location typing cmd
// compile the file javac <File_Name> with .jav
// java <file_name> without .java and with agrms

public class CommandLine {
   public static void main(String[] args) {
      for (int index = 0; index < args.length; index++)
         System.out.println(args[index]);
   }
}
