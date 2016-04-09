//********************************************************************
//  Zero.java       Author: Lewis/Loftus
//
//  Demonstrates an uncaught exception.
//********************************************************************

public class ZeroCaught
{
   //-----------------------------------------------------------------
   //  Deliberately divides by zero to produce an exception.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      int numerator = 10;
      int denominator = 0;

      try {
            System.out.println (numerator / denominator);
      }
      catch (Exception e) {
        System.out.println("Bad stuff man");
      }
      System.out.println ("This text will not be printed.");
   }
}
