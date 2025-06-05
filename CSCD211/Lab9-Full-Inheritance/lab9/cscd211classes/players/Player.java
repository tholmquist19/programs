package  lab9.cscd211classes.players;

public class Player implements Cloneable{
    protected String name;
    protected String position;
    protected int salary;
    protected String ssn;

    protected Player(String name, String ssn, int salary, String position){
        this.name=name;
        this.ssn=ssn;
        this.salary=salary;
        this.position=position;
    }

    public int getSalary(){
        return this.salary;
    }

    public String getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public String getSsn(){
        return this.ssn;
    }

    public String toString(){
        return getName().trim()+ " " + getSsn()+ " " + getSalary()+ " "+ getPosition().trim();
    }

    @Override
    public Player clone() throws CloneNotSupportedException{
        return (Player)super.clone();
    }


}
