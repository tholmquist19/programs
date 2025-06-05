
import cscd211lab8exceptions.UnknownPackage;
import cscd211package.type.*;
import cscd211package.type.Package;
import cscd211package.vehicle.Truck;


//some modules from junit
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

//Some stuff for me to read in files and write to files.
//As well as change System.in/out
import java.io.*;
import java.util.Date;
import java.util.Scanner;


public class CSCD211Lab8Tests {

    //Hopefully everyone is looking at this. I have decided to add some comments just for your knowledge.
    //By this point hopefully everyone is looking and studying the test :P
    //You have used most of these methods and object types indirectly in the past.

    //these four objects are saving the original System.in and System.out
    //and making a temporary one for the auto grader.
    private final PrintStream ORIGINALOUT = System.out;
    private final InputStream ORIGINALIN = System.in;
    private ByteArrayOutputStream testOut;
    private ByteArrayInputStream testIn;


    //before each test this runs and sets the testOut to a new ByteArrayOutputStream
    //then changes System.out (which is how you print to the console) to the testOut
    //this way I can check the output of the program.
    @BeforeEach
    public void init() {
        this.testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(this.testOut));
    }

    //As a good programmer we clean up after ourselves.
    //This runs after each test.
    //It sets System.out and System.in back to the original.
    //Yep, you guess it thats what we use to read in from the keyboard by wrapping it in a scanner
    //and when we print out to the console.
    @AfterEach
    public void cleanUp() {
        System.setOut(this.ORIGINALOUT);
        System.setIn(this.ORIGINALIN);
    }


    //this is a helper method that takes a string and injects it into the System.in
    //If you noticed I combined a the String msg with a System.lineSeparator() so all OS will work.
    private void injectInput(final String msg) {
        this.testIn = new ByteArrayInputStream((msg +System.lineSeparator()).getBytes());
        System.setIn(this.testIn);
    }

    //Now that we have set everything up we will now start the tests. I have been nesting classes for you to be able to read easier.
    //You should know how to do this cause we do it in the LinkedList lab.
    //With unit test I have to annotate that they are nested classes with @Nested
    //Here is the api link if you want to make your own test in here.
    //https://junit.org/junit5/docs/5.8.1/api/index.html
    @Nested
    class OutputTestsandFormulaTests {
        //before every test I have to write @Test
        @Test
        public void packageCompareToTest() {
            //I am creating two packages with the same tracking number and weight.
            //I am then comparing them to each other.
            //I am expecting a 0 because they are the same.
            Package p1 = new MetalCrate(1930394, 25, 28, 39, 10, "FRAGile  ");
            Package p2 = new Letter(190234, 10, 23, 34);
            assertEquals(1, p1.compareTo(p2));
        }

        @Test
        public void packageCompareToMetalCratesDifferentWeightTest() {
            //I am creating two packages with the same tracking number and weight.
            //I am then comparing them to each other.
            Package p1 = new MetalCrate(1930394, 25, 28, 39, 10, "FRAGile  ");
            Package p2 = new MetalCrate(1930394, 4, 28, 39, 10, "FRAGile  ");
            assertEquals(21, p1.compareTo(p2));
        }

        @Test
        public void boxToStringTest() {
            //I am creating a box and then calling the toString method.
            //I am expecting the toString method to return the correct string.
            Package p1 = new Box(1930394, 25, 28, 39, 10);
            assertEquals("Package Type: box\n" +
                    "Tracking Number: 1930394\n" +
                    "Weight: 25\n" +
                    "Length: 28 inches\n" +
                    "Width: 39 inches\n" +
                    "Height: 10 inches\n", p1.toString().replaceAll("\r", ""));

        }

        @Test
        public void letterToStringTest() {
            //I am creating a letter and then calling the toString method.
            //I am expecting the toString method to return the correct string.
            Package p1 = new Letter(1930394, 25, 28, 39);
            assertEquals("Package Type: letter\n" +
                    "Tracking Number: 1930394\n" +
                    "Weight: 25\n" +
                    "Length: 28 inches\n" +
                    "Width: 39 inches\n", p1.toString().replaceAll("\r", ""));

        }

        @Test
        public void woodCrateToStringTest() {
            //I am creating a woodCrate and then calling the toString method.
            //I am expecting the toString method to return the correct string.
            Package p1 = new WoodCrate(1930394, 25, 28, 39, 10, "FRAGile  ");
            assertEquals("Package Type: woodcrate\n" +
                    "Tracking Number: 1930394\n" +
                    "Weight: 25\n" +
                    "Length: 28 inches\n" +
                    "Width: 39 inches\n" +
                    "Height: 10 inches\n" +
                    "Contents: fragile\n", p1.toString().replaceAll("\r", ""));

        }

        @Test
        public void truckLoadTest() {
            //I am injected input into system.in for the scanner
            injectInput("3\n19\n19\n19\n19\nfragile\n2\n10\n100000\n2\n1\nnot fragile\n1\n4\n5\n6\n3\n10\n1\n3\n4");
            //making a scanner with the system.in that is changed
            Scanner kb = new Scanner(System.in);
            Truck rickyBobby = new Truck("Ricky Bobby", 2);
            //sending the information to read the scanner instead of the fin scanner
            //changing the printstream to my custom one
            rickyBobby.load(kb, System.out);
            String testOutput = "Driver name: Ricky Bobby\n" +
                    "Maximum packages truck can carry: 2\n" +
                    "\n" +
                    "PACKAGE LOADING INFORMATION:\n" +
                    "---------------\n" +
                    "Package Type: woodcrate\n" +
                    "Tracking Number: 3\n" +
                    "Weight: 19\n" +
                    "Length: 19 inches\n" +
                    "Width: 19 inches\n" +
                    "Height: 19 inches\n" +
                    "Contents: fragile\n" +
                    "LOADED\n" +
                    "\n" +
                    "Package Type: metalcrate\n" +
                    "Tracking Number: 2\n" +
                    "Weight: 10\n" +
                    "Length: 100000 inches\n" +
                    "Width: 2 inches\n" +
                    "Height: 1 inches\n" +
                    "Contents: not fragile\n" +
                    "NOT LOADED: TOO BIG\n" +
                    "\n" +
                    "Package Type: box\n" +
                    "Tracking Number: 1\n" +
                    "Weight: 4\n" +
                    "Length: 5 inches\n" +
                    "Width: 6 inches\n" +
                    "Height: 3 inches\n" +
                    "LOADED\n" +
                    "\n" +
                    "Package Type: letter\n" +
                    "Tracking Number: 10\n" +
                    "Weight: 1\n" +
                    "Length: 3 inches\n" +
                    "Width: 4 inches\n" +
                    "NOT LOADED: TRUCK FULL\n" +
                    "\n";

            assertEquals(testOutput, testOut.toString().replaceAll("\r", ""));
        }

        Date date = new Date();

        @Test
        public void getPackageExceptionsMessage() {
            Truck rickyBobby = new Truck("Ricky Bobby", 2);
            String[] test = {"9090909", "idk doesnt matter", "idc", "who cares", "8", "do you really care"};
            String expectedOutput = "Package Type: unknown\n" +
                    "Tracking Number: 9090909\n" +
                    "Weight: idk doesnt matter\n" +
                    "Length: idc inches\n" +
                    "Width: who cares inches\n" +
                    "Height: 8 inches\n" +
                    "NOT LOADED: PACKAGE TYPE UNKNOWN\n\n";
            //forcing an output to get the exception
            try {
                rickyBobby.getPackage(test);
                fail();
            } catch (UnknownPackage e) {
                //comparing the expected output to the actual output from your error message
                assertEquals(expectedOutput, e.getMessage().replaceAll("\r", ""));
            }
        }

        @Test
        public void grabPackageInfoTest() {
            Truck rickyBobby = new Truck("Ricky Bobby", 2);
            injectInput("3\n19\n19\n19\n19\nfragile\n");
            Scanner kb = new Scanner(System.in);
            String[] expected = {"3", "19", "19", "19", "19", "fragile"};
            String[] test = rickyBobby.grabPackageInfo(kb);
            assertArrayEquals(expected, test);
        }

        @Test
        public void attemptToLoadTest() {
            Truck rickyBobby = new Truck("Ricky Bobby", 2);
            Crate WoodCrate = new WoodCrate(3, 19, 19, 19, 19, "fragile");
            String expectedOutput = "Package Type: woodcrate\n" +
                    "Tracking Number: 3\n" +
                    "Weight: 19\n" +
                    "Length: 19 inches\n" +
                    "Width: 19 inches\n" +
                    "Height: 19 inches\n" +
                    "Contents: fragile\n" +
                    "LOADED\n\n";
            rickyBobby.attemptToLoad(System.out, WoodCrate);
            assertEquals(expectedOutput, testOut.toString().replaceAll("\r", ""));
        }


        //I am not testing the sort method
        @Test
        public void driveTestToString() {
            Truck rickyBobby = new Truck("Ricky Bobby", 6);
            Crate woodCrate = new WoodCrate(3, 19, 19, 19, 19, "fragile");
            Crate metalCrate = new MetalCrate(2, 10, 100, 20, 1, "not fragile");
            Box box = new Box(1, 4, 5, 6, 3);
            Letter letter = new Letter(10, 1, 3, 4);
            Letter letter2 = new Letter(11, 1, 3, 4);
            MetalCrate metalCrate2 = new MetalCrate(12, 10, 100, 20, 1, "not fragile");
            rickyBobby.loadPackage(woodCrate, 0);
            rickyBobby.loadPackage(metalCrate, 1);
            rickyBobby.loadPackage(box, 2);
            rickyBobby.loadPackage(letter, 3);
            rickyBobby.loadPackage(letter2, 4);
            rickyBobby.loadPackage(metalCrate2, 5);
            rickyBobby.drive(System.out);
            String expected = "DELIVERY INFORMATION:\n" +
                    "---------------\n" +
                    "TRUCK DEPARTURE DATE: " + date.toString() + "\n\n" +
                    "Packages sorted by type then weight.\n\n";
            assertEquals(expected, testOut.toString().replaceAll("\r", ""));


        }

        @Test
        public void unloadTruckTest() {
            Truck rickyBobby = new Truck("Ricky Bobby", 6);
            Crate woodCrate = new WoodCrate(3, 19, 19, 19, 19, "fragile");
            Crate metalCrate = new MetalCrate(2, 10, 100, 20, 1, "not fragile");
            Box box = new Box(1, 4, 5, 6, 3);
            Letter letter = new Letter(10, 1, 3, 4);
            Letter letter2 = new Letter(11, 1, 3, 4);
            MetalCrate metalCrate2 = new MetalCrate(12, 10, 100, 20, 1, "not fragile");
            rickyBobby.loadPackage(woodCrate, 0);
            rickyBobby.loadPackage(metalCrate, 1);
            rickyBobby.loadPackage(box, 2);
            rickyBobby.loadPackage(letter, 3);
            rickyBobby.loadPackage(letter2, 4);
            rickyBobby.loadPackage(metalCrate2, 5);
            rickyBobby.unload(System.out);
            String expected = "PACKAGE UNLOADING INFORMATION:\n" +
                    "---------------\n" +
                    "Package Type: woodcrate\n" +
                    "Tracking Number: 3\n" +
                    "Weight: 19\n" +
                    "Length: 19 inches\n" +
                    "Width: 19 inches\n" +
                    "Height: 19 inches\n" +
                    "Contents: fragile\n" +
                    "\n" +
                    "Package Type: metalcrate\n" +
                    "Tracking Number: 2\n" +
                    "Weight: 10\n" +
                    "Length: 100 inches\n" +
                    "Width: 20 inches\n" +
                    "Height: 1 inches\n" +
                    "Contents: not fragile\n" +
                    "\n" +
                    "Package Type: box\n" +
                    "Tracking Number: 1\n" +
                    "Weight: 4\n" +
                    "Length: 5 inches\n" +
                    "Width: 6 inches\n" +
                    "Height: 3 inches\n" +
                    "\n" +
                    "Package Type: letter\n" +
                    "Tracking Number: 10\n" +
                    "Weight: 1\n" +
                    "Length: 3 inches\n" +
                    "Width: 4 inches\n" +
                    "\n" +
                    "Package Type: letter\n" +
                    "Tracking Number: 11\n" +
                    "Weight: 1\n" +
                    "Length: 3 inches\n" +
                    "Width: 4 inches\n" +
                    "\n" +
                    "Package Type: metalcrate\n" +
                    "Tracking Number: 12\n" +
                    "Weight: 10\n" +
                    "Length: 100 inches\n" +
                    "Width: 20 inches\n" +
                    "Height: 1 inches\n" +
                    "Contents: not fragile\n" +
                    "\n" +
                    "FINAL TRUCK INFORMATION\n" +
                    "---------------\n" +
                    "Packages Delivered: 6\n" +
                    "Total weight of packages: 45\n";
            assertEquals(expected, testOut.toString().replaceAll("\r", ""));
        }

        @Test
        public void unloadTruckArray() {
            Truck rickyBobby = new Truck("Ricky Bobby", 6);
            Crate woodCrate = new WoodCrate(3, 19, 19, 19, 19, "fragile");
            Crate metalCrate = new MetalCrate(2, 10, 100, 20, 1, "not fragile");
            Box box = new Box(1, 4, 5, 6, 3);
            Letter letter = new Letter(10, 1, 3, 4);
            Letter letter2 = new Letter(11, 1, 3, 4);
            MetalCrate metalCrate2 = new MetalCrate(12, 10, 100, 20, 1, "not fragile");
            rickyBobby.loadPackage(woodCrate, 0);
            rickyBobby.loadPackage(metalCrate, 1);
            rickyBobby.loadPackage(box, 2);
            rickyBobby.loadPackage(letter, 3);
            rickyBobby.loadPackage(letter2, 4);
            rickyBobby.loadPackage(metalCrate2, 5);
            rickyBobby.unload(System.out);
            Package[] expected = new Package[6];
            assertArrayEquals(expected, rickyBobby.getThePackages());
        }
    }
    @Nested
    class ExceptionMessages {
        @Test
        public void truckNameException() {
            assertThrows(IllegalArgumentException.class, () -> {
                Truck rickyBobby = new Truck("  ", 6);
            });
        }

        @Test
        public void truckNameException2() {
            assertThrows(IllegalArgumentException.class, () -> {
                Truck rickyBobby = new Truck(null, 6);
            });
        }
        @Test
        public void truckCapacityException() {
            assertThrows(IllegalArgumentException.class, () -> {
                Truck rickyBobby = new Truck("Ricky Bobby", 0);
            });
        }
        @Test
        public void truckNameExceptionMessage() {
            try {
                Truck rickyBobby = new Truck("  ", 6);
            } catch (IllegalArgumentException e) {
                assertEquals("Bad params Truck constructor", e.getMessage());
            }
        }
        @Test
        public void boxException() {
            assertThrows(IllegalArgumentException.class, () -> {
                Box box = new Box(1, 2, 5, 6, 0);
            });
        }

        @Test
        public void boxExceptionMessage() {
            try {
                Box box = new Box(1, 2, 5, 6, 0);
            } catch (IllegalArgumentException e) {
                assertEquals("Bad params Box constructor", e.getMessage());
            }
        }

        @Test
        public void crateException() {
            assertThrows(IllegalArgumentException.class, () -> {
                Crate crate = new MetalCrate(1, 2, 5, 6, 0, "frdfdfaagile");
            });
            try {
                Crate crate = new WoodCrate(1, 2, 5, 6, 0, "frdfdfaagile");
            } catch (IllegalArgumentException e) {
                assertEquals("Bad params Crate constructor", e.getMessage());
            }
        }

        @Test
        public void crateExceptionheight() {
            assertThrows(IllegalArgumentException.class, () -> {
                Crate crate = new WoodCrate(1, 2, 5, 6, 0, "fragile");
            });
            try {
                Crate crate = new MetalCrate(1, 2, 5, 6, 0, "fragile");
            } catch (IllegalArgumentException e) {
                assertEquals("Bad params Crate constructor", e.getMessage());
            }
        }

        @Test
        public void packageException() {
            assertThrows(IllegalArgumentException.class, () -> {
                Package pack = new Letter(0, 2, 5, 6);
            });
            try {
                Package pack = new Box(0, 2, 5, 6, 1);
            } catch (IllegalArgumentException e) {
                assertEquals("Bad params Package constructor", e.getMessage());
            }
        }

        @Test
        public void packageExceptionWeight(){
            assertThrows(IllegalArgumentException.class, () -> {
                Package pack = new Letter(1, 0, 5, 6);
            });
            try {
                Package pack = new WoodCrate(1, 0, 5, 6, 2, "fragile");
            } catch (IllegalArgumentException e) {
                assertEquals("Bad params Package constructor", e.getMessage());
            }
        }

        @Test
        public void packageExceptionLength(){
            assertThrows(IllegalArgumentException.class, () -> {
                Package pack = new Letter(1, 2, 0, 6);
            });
            try {
                Package pack = new MetalCrate(1, 2, 0, 6, 2, "NOT fragile");
            } catch (IllegalArgumentException e) {
                assertEquals("Bad params Package constructor", e.getMessage());
            }
        }

        @Test
        public void packageExceptionWidth(){
            assertThrows(IllegalArgumentException.class, () -> {
                Package pack = new Letter(1, 2, 5, 0);
            });
            try {
                Package pack = new Box(1, 2, 5, 0, 2);
            } catch (IllegalArgumentException e) {
                assertEquals("Bad params Package constructor", e.getMessage());
            }
        }

        @Test
        public void UnknownPackageException(){
            assertThrows(IllegalArgumentException.class, () -> { new UnknownPackage(null);});
        }

        @Test
        public void UnknownPackageExceptionMessage(){
            try {
                new UnknownPackage("  ");
            } catch (IllegalArgumentException e) {
                assertEquals("Bad params UnknownPackage constructor", e.getMessage());
            }
        }


    }


}
