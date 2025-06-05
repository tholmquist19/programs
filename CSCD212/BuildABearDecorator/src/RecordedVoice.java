public class RecordedVoice extends BearDecorator
{

    public RecordedVoice(final BearProduct bear, final double cost)
    {
        super(bear, cost);
    }
    
    public String decorated()
    {
        return super.decorated() + this.getDecoration();
    }
    
    private String getDecoration()
    {
        return " with Recorded Voice";
    }       
}