public class Bear implements BearProduct
{
   private final String type;
   private final double cost;
   
   public Bear(final String type)
   {
      this.type = type;
      this.cost = 29.00;
   }
   
   public Bear(final String type, final double cost)
   {
      this.type = type;
      this.cost = cost;
   }

   
   @Override
   public String decorated()
   {
       return this.type;
   } 
   
   @Override
   public double getCost()
   {
       return this.cost;
   } 
}
