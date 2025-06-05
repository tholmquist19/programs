package lab9.cscd211classes.players;

public class FootballPlayer extends Player implements Cloneable{

    protected int td;
    protected int jerseyNumber;
    public FootballPlayer(String name, String ssn, int salary, String position, int td, int jerseyNumber) {
        super(name, ssn, salary, position);
        this.td=td;
        this.jerseyNumber=jerseyNumber;
    }

    public String toString(){
        return super.toString()+"  Touchdowns "+this.td+"   "+this.jerseyNumber+"\n";
    }

    public FootballPlayer clone()throws CloneNotSupportedException{
        return (FootballPlayer)super.clone();
    }
}
