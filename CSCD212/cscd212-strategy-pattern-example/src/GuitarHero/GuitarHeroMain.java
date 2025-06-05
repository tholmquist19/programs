package GuitarHero;

import GameCharacters.*;
import GuitarTypes.*;
import SoloTypes.*;

public class GuitarHeroMain
{

	public static void main(String[] args)
   {
      Guitar gibsonFlyingV = new GibsonFlyingV("Gibson Flying V");
      GameCharacter player1 = new GameCharacterSlash(gibsonFlyingV, new SetGuitarOnFire()); 
      player1.playGuitar();
      player1.playSolo();
      
      player1.setGuitar(new FenderTelecaster("Fender Telecaster"));
      player1.playGuitar();
      player1.setSolo(new SmashTheGuitar());
      player1.playSolo();
      
      System.out.println("\n");
      
      player1 = new GameCharacterHendrix(gibsonFlyingV, new JumpOffTheStage());
      player1.playGuitar();
      player1.playSolo();

	}
}
		
