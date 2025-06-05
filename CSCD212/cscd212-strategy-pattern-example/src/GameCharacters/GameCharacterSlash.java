package GameCharacters;

import GuitarTypes.*;
import SoloTypes.*;


public class GameCharacterSlash extends GameCharacter
{

	public GameCharacterSlash(GuitarType guitar, SoloType solo)
   {
		super("Slash", guitar, solo);
	}
	
   public void playGuitar()
   {
      System.out.print(super.getName() + " is playing a " );
      super.playGuitar();      
	}
	
   @Override
	public void playSolo()
   {
		System.out.print(super.getName());
		super.playSolo();
	}
}
