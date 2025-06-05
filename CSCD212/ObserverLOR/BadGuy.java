import java.util.*;

@SuppressWarnings("deprecation")
public class BadGuy implements Observer
{
	private Observable eye;
	private String name;
	private int hobbits;
	private int elves;
	private int dwarves;
	private int humans;
	
	public BadGuy(Observable eye, String name)
   {
		this.eye = eye;
		this.name = name;
		this.eye.addObserver(this);
	}
	
   @Override
	public void update(Observable o, Object arg)
   {
		EyeOfSauron eye = (EyeOfSauron) o;
		this.hobbits = eye.getHobbits();
		this.elves = eye.getElves();
		this.dwarves = eye.getDwarves();
		this.humans = eye.getHumans();
		this.display();
	}

	// Prints this objects fields
	public void display()
   {
		System.out.println(name + " knows about -");
		System.out.println("Hobbits: " + getHobbits());
		System.out.println("Elves: " + getElves());
		System.out.println("Dwarves: " + getDwarves());
		System.out.println("Humans: " + getHumans());
		System.out.println();
	}
	
	// Removes from list
	public void defeated()
   {
		System.out.println(name + " was defeated");
		eye.deleteObserver(this);
		System.out.println();
	}
	

	public int getHobbits() {return this.hobbits;}
	
	public int getElves() {return this.elves;}
	
	public int getDwarves() {return this.dwarves;}
	
	public int getHumans() {return this.humans;}
   
}// end class
