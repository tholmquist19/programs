public abstract class BearDecorator implements BearProduct
{
    private BearProduct bear;
    private double cost;
          
    public BearDecorator(final BearProduct bear, final double cost)
    {
      this.bear = bear;
      this.cost = cost;
    } 
    
    @Override
    public String decorated()
    {
         return bear.decorated();
    }
    
    public double getCost()
    {
      return bear.getCost() + this.cost;
    }
}