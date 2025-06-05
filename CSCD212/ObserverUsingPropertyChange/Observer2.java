import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Observer2 implements PropertyChangeListener
{
   private ThingWithData twd;
   
   
   public Observer2(final ThingWithData twd)
   {
      this.twd = twd;
      this.twd.addPropertyChangeListener(this);
      this.display(twd.getIntVal(), twd.getDoubleVal());
   }
   
   @Override
   public void propertyChange(PropertyChangeEvent event)
   {
      if(event.getPropertyName().equals("INT"))
      {
         System.out.println(this.getClass().getSimpleName() + " - Changed intVal: " + " [old -> " + event.getOldValue() + "] | [new -> " + event.getNewValue() +"]");
      }
   }
      
   private void display(final int intVal, final double doubleVal)
   {
      System.out.println("In Observer 2 - intVal: " + intVal + " doubleVal: "+ doubleVal);
   
   }

}