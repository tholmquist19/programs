import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Observer1 implements PropertyChangeListener
{
   private ThingWithData twd;   
   
   public Observer1(final ThingWithData twd)
   {
      this.twd = twd;
      this.twd.addPropertyChangeListener(this);
   }
   
   @Override
   public void propertyChange(PropertyChangeEvent event)
   {
        System.out.println(this.getClass().getSimpleName() + " - Changed property: " + event.getPropertyName() + " [old -> "
           + event.getOldValue() + "] | [new -> " + event.getNewValue() +"]");
   }
      
   public String toString()
   {
      return "In Observer 1 - intVal: " + twd.getIntVal() + " doubleVal: "+ twd.getDoubleVal();
   
   }

}