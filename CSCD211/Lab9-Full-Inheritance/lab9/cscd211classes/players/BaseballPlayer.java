package  lab9.cscd211classes.players;

public class BaseballPlayer extends Player implements Cloneable{

    protected double batAvg;
    public BaseballPlayer(String name, String ssn, int salary, String position, double batAvg) {
        super(name, ssn, salary, position);
        this.batAvg =batAvg;
    }

    public String toString(){
        return super.toString()+" Batting Avg: "+ this.batAvg+"\n";
    }

    public BaseballPlayer clone()throws CloneNotSupportedException{
        return (BaseballPlayer)super.clone();
    }
}
