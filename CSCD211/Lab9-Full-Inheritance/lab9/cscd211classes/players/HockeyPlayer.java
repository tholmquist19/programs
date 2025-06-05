package lab9.cscd211classes.players;

public class HockeyPlayer extends Player implements Cloneable{

    protected int jerseyNumber;
    public HockeyPlayer(String name, String ssn, int salary, String position, int jerseyNumber) {
        super(name, ssn, salary, position);
        this.jerseyNumber=jerseyNumber;
    }

    public String toString(){
        return super.toString()+"  "+this.jerseyNumber+"\n";
    }

    public HockeyPlayer clone()throws CloneNotSupportedException{
        return (HockeyPlayer)super.clone();
    }
}
