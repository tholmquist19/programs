package GameCharacters;

import GuitarTypes.GuitarType;
import SoloTypes.SoloType;

public abstract class GameCharacter
{
	protected GuitarType guitar;
	protected SoloType solo;
   private String name;
	
	public GameCharacter(final String name, final GuitarType guitar, final SoloType solo)
   {
		this.guitar = guitar;
		this.solo = solo;
      this.name = name;
	}

	public void setGuitar(final GuitarType newGuitar)
   {
		this.guitar = newGuitar; 
	}

	public void setSolo(final SoloType newSolo)
   {
		this.solo = newSolo; 
	}

	public void playGuitar()
   {
		System.out.println(this.guitar.createSound() + "!");
	}

	public void playSolo()
   {
		this.solo.performSolo();

	}
   
   public String getName(){return this.name;}

}
