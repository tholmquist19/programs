/**
 * This is the subject class, extends Observable. Updates observers
 */

import java.util.*;


@SuppressWarnings("deprecation")
public class EyeOfSauron extends Observable
{
	private int hobbits;
	private int elves;
	private int dwarves;
	private int humans;
	
	// Updates own fields, calls method to notify observers
	public void enemiesSpotted(GoodGuys gg)
   {
		this.hobbits = gg.getHobbits();
		this.elves = gg.getElves();
		this.dwarves = gg.getDwarves();
		this.humans = gg.getHumans();
		this.setChanged();
		this.notifyObservers();

	}
	
	public int getHobbits() {return this.hobbits;}
	
	public int getElves() {return this.elves;}
	
	public int getDwarves() {return this.dwarves;}
	
	public int getHumans() {return this.humans;}
}

