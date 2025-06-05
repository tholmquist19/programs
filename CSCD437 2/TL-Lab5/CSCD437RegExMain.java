import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSCD437RegExMain 
{
	public static void main(String [] args)
	{
      int choice;
      String str= "";
      Scanner kb = new Scanner(System.in);
      
      do
      {
         choice = menu(kb);
     		
         switch(choice)
   		{
   		   case 1:
               str = readString("SSN pattern", kb);
   				CSCD437RegExMethods.SSNPattern(str, System.out);
   				break;
            case 2:
               str = readString("phone number pattern", kb);
   				CSCD437RegExMethods.phonePattern(str, System.out);
   				break;
   			case 3:
   			   str = readString("email pattern", kb);
            	CSCD437RegExMethods.emailPattern(str, System.out);
   				break;
   			case 4:
   			   str = readString("name pattern", kb);
            	CSCD437RegExMethods.namePattern(str, System.out);
   				break;
   			case 5:
   			   str = readString("date pattern", kb);
            	CSCD437RegExMethods.datePattern(str, System.out);
   				break;
   			case 6:
   			   str = readString("military time pattern", kb);
            	CSCD437RegExMethods.militaryTimePattern(str, System.out);
   				break;
   			case 7:
   			   str = readString("money pattern", kb);
            	CSCD437RegExMethods.moneyPattern(str, System.out);
   				break;
   			case 8:
   			   str = readString("password pattern", kb);
               CSCD437RegExMethods.passwordPattern(str, System.out);
   				break;
   			default: System.out.println("Ending!!!");
         }// end switch
   			
      }while(choice != 9);
		
		kb.close();
      		
	}//end main
   
   private static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("Bad kb Parameter to the method");

      int choice;
      
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) SSN");
         System.out.println("2) US Phone Number");
			System.out.println("3) E-mail Address");
			System.out.println("4) Name on Class Roster");
			System.out.println("5) Date MM-DD-YYYY");
			System.out.println("6) Military Time");
			System.out.println("7) US Currency");
			System.out.println("8) Password");
			System.out.println("9) Quit");
         System.out.print("Choice --> ");
         choice = Integer.parseInt(kb.nextLine());  
      }while(choice < 1 || choice > 9);
      
      return choice;
   
   }// end menu
   
   private static String readString(final String prompt, final Scanner kb)
   {
      if(prompt == null || prompt.isEmpty() || kb == null)
         throw new IllegalArgumentException("Bad Parameter to the method");
         
      String str = "";
      System.out.print("Please enter a(n) " + prompt + " ");
      return kb.nextLine();
      
   }// end readString
	
}// end class
