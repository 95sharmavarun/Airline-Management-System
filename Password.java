

import java.io.Console;

public class Password {

	public static void main(String[] args) {
		 Console cnsl = null;
	      String alpha = null;
	      
	      try {
	         // creates a console object
	    	  System.out.println("Llllll");
	         cnsl = System.console();

	         // if console is not null
	         if (cnsl != null) {
	            
	            // read line from the user input
	            alpha = cnsl.readLine("Name: ");
	            
	            // prints
	            System.out.println("Name is: " + alpha);
	            
	            // read password into the char array
	            char[] pwd = cnsl.readPassword("Password: ");
	            
	            // prints
	            //System.out.println("Password is: "+pwd.length);


 for(int i=0;i<pwd.length;i++){
	            System.out.print(pwd[i]);
	            }


	         } 
	         else {
	        	 System.out.println("no exec");
	         }
	         
	      } catch(Exception ex) {
	         // if any error occurs
	         ex.printStackTrace();      
	      }
	}

}
