/**************************************************************************
*                                                                         *
*     Program Filename:  Khan2.java                                       *
*     Author          :  Sarim Khan                                       *
*     Date Written    :  May 30, 2017                                     *
*     Purpose         :  To count the number of legs between two matrices *
*     Input from      :  Keyboard                                         *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*; 

public class Khan2
{
   public static void main (String[] args) throws IOException
   {
      String FileName;
      Scanner Keyboard = new Scanner (System.in); 
      Scanner InFile;  
      int Total, i, j; 
      int Counter = 0;
      int Counter2 = 0;  
      int countLegs; 
      Integer index1 = 0; 
      Integer index2 = 0;  
      String x, y, input1, input2;  

      System.out.println("Please enter the name of the input file: "); 
      FileName = Keyboard.nextLine(); 
      InFile = new Scanner (new File(FileName)); 
      //user input file name 

      Total = InFile.nextInt();  
      //Store total amount of lines 
      final int multiply = Total - 1;  

      if (Total > 39) 
      {
         System.out.println("The data file contains 40 or more lines"); 
         System.exit(0); 
      }    
      //end run if data file >39      

      String[] words = new String[Total];
      int[][] AdjMatrix = new int[Total][Total];
      int[][] AdjMatrix2 = new int [Total][Total];
      //declare matrices 
      
      InFile.nextLine(); 
      for (i=0; i<Total; i++) 
      {
         words[i] = InFile.nextLine();
      } 
      //load data file into array 

      for (i=0; i<Total; i++)
      {  
         for(j=0;j<Total; j++)
         {
            x = words[i];
            y = words[j];
           
            if(x.substring(x.length()-1).compareTo(y.substring(0,1)) == 0)
            {
               AdjMatrix[i][j] = 1; 
               AdjMatrix2[i][j] = 1; 
            }           
         }    
      }  
      //test for adjaceny       
      
      System.out.println("Please enter the first word you would like to compare: "); 
      input1 = Keyboard.nextLine().toUpperCase(); 
      System.out.println("Please enter the second word you would like to compare: "); 
      input2 = Keyboard.nextLine().toUpperCase();  
      //user input 
 
      for (i=0; i<=multiply; i++)
      {
         if(input1.compareTo(words[i]) == 0)
         {
            Counter++; 
            index1 = i;   
         }  
      }
 
      for (i=0; i<=multiply; i++)
      {
         if(input2.compareTo(words[i]) == 0)
         {
            Counter2++; 
            index2 = i; 
         }         
      }         
 
      if (Counter == 0 || Counter2 == 0)
      {
         System.out.println("Either one or both of the words you entered were not found in the input file."); 
         System.exit(0); 
      }   
         //test for user input        

      for (countLegs=1; countLegs<=Total; countLegs++)
      { 
         if(AdjMatrix2[index1][index2] != 0) 
         {
            System.out.println("The shortest path which begins with " + input1 + " and ends with " + input2 + " has a length of " + countLegs);  
            break; 
         }
         else
         {
            MatrixProduct(AdjMatrix2, AdjMatrix, Total);
         }   
         if (countLegs == Total)
         {   
            System.out.println("There is no path connecting " + input1 + " and " + input2);  
            System.exit(0); 
         }
      }                   
}

public static void MatrixProduct(int[][] a, int[][] b, int size)
{
   int[][] product = new int[size][size];
   int i, j, k;

   for (i = 0; i < size; i++)
      for (j = 0; j < size; j++)
      {
         product[i][j] = 0;

         for (k = 0; k < size; k++)
            product[i][j] = product[i][j] + a[i][k]*b[k][j];
         // end for
      }
      // end for
   // end for

   for (i = 0; i < size; i++)
      for (j = 0; j < size; j++)
         a[i][j] = product[i][j];
      // end for
   // end for

   return;
}
// end public method MatrixProduct


public static void MatrixPrint(int[][] a, int size)
{
   int i, j;

   for (i = 0; i < size; i++)
   {
      for (j = 0; j < size; j++)
         System.out.format("%5d", a[i][j]);
      // end for

      System.out.println();
   }
   // end for

   return;
}
    
}