//----------------------------------------------------------------------
// PostFixEvaluator.java       by Dale/Joyce/Weems             Chapter 2
//
// Provides a postfix expression evaluation.
//----------------------------------------------------------------------

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class PostFixEvaluator
{
public static Dictionary<String, Integer> evaluate(String expression)
  {
	Dictionary<String, Integer> hold = new Hashtable<String, Integer>();
	Scanner tokenizer = new Scanner(expression);
    StackInterface<Integer> stack = new ArrayListStack<Integer>();  

    int value, operand1, operand2;
    String operator;
    int result = 0, count = 0, sum = 0, average = 0;
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    while (tokenizer.hasNext()){

	      if (tokenizer.hasNextInt()){
	        // Process operand.
	        value = tokenizer.nextInt();
	        max = Math.max(max, value);
	        min = Math.min(value, min);
	        sum = sum + value;
	        
	        if (stack.isFull()){
		        throw new PostFixException("Too many operands-stack overflow");
	        }
	        stack.push(value);
	        
	        count++;
	        
	      }
	      else {
	        // Process operator.
	        operator = tokenizer.next();
	        
	        // Check for illegal symbol
	        if (!(operator.equals("/") || operator.equals("*") ||
	              operator.equals("+") || operator.equals("-") || 
	              operator.equals("^"))) {
		          throw new PostFixException("Illegal symbol :" + operator);
	        }

	  
	        // Obtain second operand from stack.
	        if (stack.isEmpty()) {
		          throw new PostFixException("Not enough operands-stack underflow");
	        }
	        operand2 = stack.top();
	        stack.pop();
	
	        // Obtain first operand from stack.
	        if (stack.isEmpty()) {
		        throw new PostFixException("Not enough operands-stack underflow");
		          
	        }	        
	        operand1 = stack.top();
	        stack.pop();
	
	        // Perform operation.
	        if (operator.equals("/")){
	        	//checks if divisible by zero
	        	if (operand2 == 0) {
	        		throw new PostFixException("illegal to divide by zero");
	        	}
	        	else {
	                result = operand1 / operand2;
	        	}
	        }
	        else if(operator.equals("*")) 
	          result = operand1 * operand2;
	        else if(operator.equals("+"))
	          result = operand1 + operand2;
	        else if(operator.equals("-"))
	          result = operand1 - operand2;
	        else if(operator.equals("^"))
	          result = Math.max(operand1, operand2);
	 
	        // Push result of operation onto stack.
	        stack.push(result);
	      //}
    	}
    }

    // Obtain final result from stack. 
    if (stack.isEmpty()) {
    	throw new PostFixException("Not enough operands-stack underflow");
    }
    result = stack.top();
    stack.pop();

    // Stack should now be empty.
    if (!stack.isEmpty()) {
    	throw new PostFixException("Too many operands-operands left over");
    }
    
    average = sum / count;
    hold.put("Result", result);
    hold.put("Average", average);
    hold.put("Max", max);
    hold.put("Min", min);
    hold.put("Count", count);
    tokenizer.close();
    
	return hold;
    
  }

}
