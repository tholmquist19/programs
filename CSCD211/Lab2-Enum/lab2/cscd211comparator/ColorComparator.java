package lab2.cscd211comparator;

import lab2.cscd211classes.Person;

public class ColorComparator implements java.util.Comparator<Person>{
    public int compare(final Person p1, final Person p2){
        if(p1 == null || p2 == null){
            throw new IllegalArgumentException("Persons are null");
        }
        return p1.getColor().compareTo(p2.getColor());
    }

}
