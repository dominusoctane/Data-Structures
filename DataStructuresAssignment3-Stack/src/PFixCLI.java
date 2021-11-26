import java.util.Scanner;
import java.util.Dictionary;


public class PFixCLI 
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);

    String expression = null;    // expression to be evaluated
    final String STOP = "X";     // indicates end of input

    while(!STOP.equals(expression))
    {
      // Get next expression to be processed.
      System.out.print("\nPostfix Expression (" + STOP + " to stop): ");
      expression = scan.nextLine();
      
      if (!STOP.equals(expression))
      {      
         // Obtain and output result of expression evaluation.
         try{
        	 // save the info in a Dictionary object
    	     Dictionary<String, Integer> data = PostFixEvaluator.evaluate(expression);
    	     // Print out onto terminal
	        System.out.println("RESULT = " + data.get("Result"));
	       	System.out.println("**STATISTICS**");
	    	System.out.println("Largest Number: " + data.get("Max"));
	    	System.out.println("Smallest Number: " + data.get("Min"));
	    	System.out.println("Count: " + data.get("Count"));
	    	System.out.println("Average: " + data.get("Average"));
   
           // Output result.
         }
         catch (PostFixException error){        
           // Output error message.

            System.out.println("Error in expression - " + error.getMessage());
         }

      }
    }
  }
}