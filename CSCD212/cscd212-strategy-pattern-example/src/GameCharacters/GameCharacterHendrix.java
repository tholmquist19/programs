package GameCharacters;

import GuitarTypes.*;
import SoloTypes.*;


public class GameCharacterHendrix extends GameCharacter {

	public GameCharacterHendrix(GuitarType guitar, SoloType solo)
   {
		super("Hendrix", guitar, solo);
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
