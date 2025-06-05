import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ThingWithData
{
   private int intVal;
   private double doubleVal;
   private PropertyChangeSupport propChangeSupport;
   
   public ThingWithData()
   {
      this.intVal = 0;
      this.doubleVal = 0;
      this.propChangeSupport  = new PropertyChangeSupport(this);
   }
  
   public int getIntVal(){return this.intVal;}
   public double getDoubleVal(){return this.doubleVal;}
   
   public void changeInt(final int intVal)
   {
      int old = this.intVal;
      this.intVal = intVal;
      this.propChangeSupport.firePropertyChange("INT", old, intVal);
   }
   
   public void changeAll(final int intVal, final double doubleVal)
   {
      int oldInt = this.intVal;
      double oldDouble = this.doubleVal;
      
      this.intVal = intVal;
      this.doubleVal = doubleVal;
      
      this.propChangeSupport.firePropertyChange("Int Value", oldInt, intVal);
      this.propChangeSupport.firePropertyChange("Double Value", oldDouble, doubleVal);
   }

   
   
   
   public String toString()
   {
      return "In ThingWithData - intVal: " + this.intVal + " doubleVal: " + this.doubleVal;
   }
   
   public void addPropertyChangeListener(PropertyChangeListener listener)
   {
      propChangeSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener)
   {
      propChangeSupport.removePropertyChangeListener(listener);
   }

}