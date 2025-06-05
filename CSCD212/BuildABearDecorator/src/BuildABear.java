public class BuildABear
{
   public static void main(String [] args)
   {
      BearProduct bear = new Bear("Harry Potter Bear");
      System.out.println(bear.decorated() + " that costs $" + bear.getCost());
      
      bear = new HeartPatch(bear, 6.50);
      System.out.println(bear.decorated() + " that costs $" + bear.getCost());
      
      bear = new RecordedVoice(bear, 8.00);
      System.out.println(bear.decorated() + " that costs $" + bear.getCost());
   }
}