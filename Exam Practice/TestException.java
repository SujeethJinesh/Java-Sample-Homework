//********************************************************************
//  TestException.java       Author: Stasko
//
//  Demonstrates an uncaught exception.
//********************************************************************

import java.util.Scanner;

public class TestException
{
   //-----------------------------------------------------------------
   //  Deliberately divides by zero to produce an exception.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      int i,j;
      try {
         System.out.println("Enter an int, 0, 1, or 2");
         Scanner scan = new Scanner(System.in);
         i = scan.nextInt();
         if (i==0)
            System.out.println("No problems");
         else if (i==1)
            j = i/0;
         else {
            String s = "abc";
            char c = s.charAt(5);
         }
      }
      catch (ArithmeticException ae) {
        System.out.println("Problems with arithmetic");
		  //int m = 1/0;
      }
		// Comment the next thing eventually
      catch (StringIndexOutOfBoundsException se) {
        System.out.println("String index problem");
      }
      catch (Exception se) {
        System.out.println("generic");
      }
		finally {
          System.out.println("Finally checking in");
      }
      System.out.println ("Text at the very end");
   }
}
