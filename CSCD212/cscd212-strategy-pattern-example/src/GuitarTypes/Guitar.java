package GuitarTypes;

public abstract class Guitar implements GuitarType
{
   private String guitarName;
      
   public Guitar(final String guitarName)
   {
      this.guitarName = guitarName;
   
   }
   
   public String getGuitarName(){return this.guitarName;}

}