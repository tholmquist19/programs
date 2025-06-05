package lab2.cscd211methods;

import lab2.cscd211classes.Person;
import lab2.cscd211enums.Color;

import java.util.Scanner;

public class CSCD211Lab2Methods {


    public static Color convertColor(final String color)
    {
        if(color == null) {
            throw new IllegalArgumentException("String is null");
        }
        return Color.valueOf(color.toUpperCase().trim());
    }

    public static Person[] fillArray(Scanner fin, int total) {
        if(fin == null){
            throw new IllegalArgumentException("Scanner is null");
        }
        if(total<= 0){
            throw new IllegalArgumentException("Total is invalid");
        }
        Person[] people = new Person[total];
        String firstName;
        String lastName;
        String color;
        for(int i=0; i<total; i++) {
                firstName = fin.nextLine();
                lastName = fin.nextLine();
                color = fin.nextLine();
                people[i] = new Person(firstName, lastName, convertColor(color)) {
                    @Override
                    public int compareTo(Person o) {
                        return 0;
                    }
                };
        }

        return people;
    }

    public static int menu(Scanner kb) {
        if(kb == null){
            throw new IllegalArgumentException("Scanner is null");
        }
        int choice;
        do{System.out.println("1. print the array to the screen");
            System.out.println("2. Display all people that contain a certain color");
            System.out.println("3. Sort the array by color");
            System.out.println("4. sort the array by the natural order");
            System.out.println("5. to quit");
            System.out.println("Choice:");
            choice = Integer.parseInt(kb.nextLine());
            System.out.println();

        }while(choice <1 ||choice>5);
        return choice;
    }

    public static void printArray(Person[] myPeeps) {
        if(myPeeps == null){
            throw new IllegalArgumentException("Array is null");
        }
        for(int i=0; i<myPeeps.length; i++){
            System.out.println(myPeeps[i]);
        }
    }


    public static Color readColor(Scanner kb) {
        if(kb == null){
            throw new IllegalArgumentException("Scanner is null");
        }
        String c = null;
        System.out.println("Enter color: ");
        c = kb.nextLine();
        return convertColor(c);
    }

    public static void displayAll(Color toFind, Person[] myPeeps) {
        if(myPeeps == null){
            throw new IllegalArgumentException("Array is null");
        }
        for(Person p: myPeeps){
            if(p.getColor().equals(toFind)){
                System.out.println(p + "\n");
            }

        }
    }

}
