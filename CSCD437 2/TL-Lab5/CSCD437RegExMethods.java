import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Tyler Holmquist

public class CSCD437RegExMethods
{ 
   
   public static void SSNPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;

      if(str.matches("^\\d{3}[-|\\s]?\\d{2}[-|\\s]?\\d{4}"))
          res = true;

      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
     				
	}// end SSN

   
   public static void phonePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
         
      boolean res = false;

      if(str.matches("(\\+1)?[\\s-]?\\(?\\d{3}\\)?[\\s-]?\\d{3}[\\s-]?\\d{4}"))
          res = true;
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
        
	}// end phoneNumber


	public static void emailPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;

        if(str.matches("([A-Za-z0-9/.?]+)\\w@\\w.+\\b"))
            res = true;
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      

	}// end email
   
   
	public static void namePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;

      if(str.matches("\\w+\\W?+\\w+,\\s\\w+,\\s\\w+\\b"))
          res = true;
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      
   
	}// end name
	
   
   public static void datePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;

      if(str.matches("^(([469]|0[469]|1[1])([-/])([1-9]|0[1-9]|1[0-9]|2[0-9]|3[0])\\3|(([3578]|0[3578]|1[02])([-/])([1-9]|0[1-9]|1[0-9]|2[0-9]|3[1])\\7)|(([2]|0[2])([-/])([1-9]|0[1-9]|2[0-8])\\11))[0-9]{4}"))
          res = true;

        fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
         
      

	}// end date
	
      
   public static void militaryTimePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;

      if(str.matches("\\b(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]):(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9])\\b"))
          res = true;


        fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end militaryTime
	
   
   public static void moneyPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      if(str.matches("^(\\$)\\d\\d?\\d?[\\,\\.](\\d\\d\\d[\\,\\.])?(\\d\\d\\d[\\,\\.])?(\\d\\d\\d)?\\d\\d"))
          res = true;
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end money
	
       
   public static void passwordPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;

      if(str.matches("^(?!.*([a-z][a-z][a-z][a-z]))(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\\$!%*?&])[A-Za-z\\d@\\$!%*?&]{10,}$"))
          res = true;
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end password

}// end class
