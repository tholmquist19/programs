package GuitarTypes;

public class GibsonFlyingV extends Guitar 
{

   public GibsonFlyingV(final String guitarName)
   {
      super(guitarName);      
   }


	public String createSound()
   {
		 return super.getGuitarName();

	}

}
