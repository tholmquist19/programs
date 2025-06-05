package lab2.cscd211classes;

import lab2.cscd211enums.Color;


public abstract class Person implements Comparable<Person>{
    private String fName;
    private String lName;
    private Color color;

    public Person(final String fName, final String lName, Color color){
        this.fName =fName;
        this.lName =lName;
        this.color =color;

    }


    public int compareTo(final Person o1, final Person o2){
        if(o1 == null || o2 == null){
            throw new IllegalArgumentException("Persons are null");
        }

        int comp;

        if(o1.lName != o2.lName)
            comp =o1.lName.compareTo(o2.lName);
        else if(o1.lName == o2.lName)
            comp = o1.fName.compareTo(o2.fName);
        else
            comp = o1.color.compareTo(o2.color);

        return comp;
    }

    public Color getColor() {
        return this.color;
    }
    public String toString(){
        return this.fName + " " + this.lName + " " + this.color;
    }
}
