package GuitarTypes;

public class FenderTelecaster extends Guitar
{
   public FenderTelecaster(final String guitarName)
   {
      super(guitarName);
   }


	public String createSound()
   {
		return super.getGuitarName();
	}

}
