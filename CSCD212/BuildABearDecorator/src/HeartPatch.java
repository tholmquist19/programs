public class HeartPatch extends BearDecorator
{
   
   public HeartPatch(final BearProduct bear, final double cost)
   {
       super(bear, cost);
   }
    
   public String decorated()
   {
       return super.decorated() + getDecoration();
   }
    
   private String getDecoration()
   {
       return " with Heart Patch";
   }    
}