public class ObserverUsingPropertyChangeExampleMain
{
   public static void main(final String [] args)
   {
      ThingWithData aThing = new ThingWithData();
      System.out.println(aThing);
      
      Observer1 obs1 = new Observer1(aThing);
      System.out.println(obs1);
      System.out.println();
            
      aThing.changeAll(42, 3.14159);
      System.out.println();

      System.out.println(aThing);
      System.out.println();

      
      Observer2 obs2 = new Observer2(aThing);
      aThing.changeInt(-12);
      System.out.println();

   
   }

}
