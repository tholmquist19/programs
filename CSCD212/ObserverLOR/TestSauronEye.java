/**
 * This program implements the observer pattern. EyeOfSauron is the subject, BadGuys is the observable, goodguys is the data.
 * This program uses the pull method to get data to the observers.
 * As with assignment 1, develop a simple set of Java classes using the Observer pattern to represent the following scenario:
 *  In the land of Middle Earth battle wages between good and bad.  On the side of 'good' are Hobbits, Elves, Dwarves, and Men.  
 *  On the side of 'bad' are the wizard Saruman and the Witch King of Angmar (leader of the Nazgul).  The ever watching Eye of Sauron 
 *  is always on the lookout for the agents of 'good'.  Saruman and the Witch King would like to be notified any time the Eye of Sauron 
 *  spots one of the good guys.
 *  Use the Observer pattern to model the above.  Properly utilize Java's Observer interface and Observable class as part of your
 *  implementation. Do try this out and see if you can get it to work.  NOTE: Depending on the version of the Java you use, you may 
 *  get a warning that Observer and Observable are deprecated.  This is NOT an error and it is ok to proceed with your solution.  Use
 *  these steps to help you complete this assignment.  Follow the Weather Data example from HFDP to aid you in your task.  
 */

public class TestSauronEye
{

    public static void main(String[] args)
    {
         GoodGuys gg = new GoodGuys(0,0,0,0);
    
         EyeOfSauron eye = new EyeOfSauron(); // Subject
         
         BadGuy saruman = new BadGuy(eye, "Sauruman"); // Observer
         
         eye.enemiesSpotted(gg);
           
         BadGuy witchKing = new BadGuy(eye, "Witch King"); // Observer

         gg = new GoodGuys(1,1,2,0); // Data Object

         eye.enemiesSpotted(gg); // Method to get data to subject

         witchKing.defeated(); //Removes from Observer list

         gg = new GoodGuys(4,2,2,100);

         eye.enemiesSpotted(gg);

   }

}