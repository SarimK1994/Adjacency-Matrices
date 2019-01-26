/**************************************************************************
*                                                                         *
*     Program Filename:  InputFileDemo.java                               *
*     Author          :  John B. Student                                  *
*     Date Written    :  May 24, 2017                                     *
*     Purpose         :  To sum the integers in a file                    *
*     Input from      :  Keyboard and a file named at the keyboard        *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;

public class InputFileDemo
{
   public static void main(String[] args) throws IOException
   {
      int     Number, Sum=0, Counter=0;
      String  FileName;
      Scanner Keyboard = new Scanner(System.in);
      Scanner InFile;

      System.out.print("Please enter the name of the input file: ");
      FileName = Keyboard.nextLine();
      InFile = new Scanner(new File(FileName));

      while (InFile.hasNext())
      {
         Number = InFile.nextInt();
         Sum = Sum + Number;
         Counter++;
      }
      // end while

      System.out.println("The sum of the " + Counter + " integers is " + Sum);
   }
   // end function main
}
// end class InputFileDemo
