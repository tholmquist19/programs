package lab11.cscd210classes;


/**
 * Represents the Clock class
 * <br> All parameters are passed as final and all preconditions will be 
 * enforced
 */
public class Clock
{
    private int hour;
    private int minute;
    private int seconds;
    public Clock(){
        this.hour = 12 ;
        this.minute = 0;
        this.seconds = 0;
    }
    public Clock(int hour, int minute, int seconds){
        if(hour<0){
            throw new UnsupportedOperationException("Hour is invalid");
        }
        if(minute<0){
            throw new UnsupportedOperationException("Minute is invalid");
        }
        if(seconds<0){
            throw new UnsupportedOperationException("Second value is invalid");
        }
        this.hour = hour ;
        this.minute = minute;
        this.seconds = seconds;
    }
    public int getMinutes() {
        return this.minute;
    }
    public int getSeconds() {
        return this.seconds;
    }
    public int getHour() {
        return this.hour;
    }
    public void setMinutes(int min) {
        this.minute += min;
        if(minute > 59) {
            setHour((minute/60));
            minute = minute % 60;
        }
    }
    public void setSeconds(int sec) {
        this.seconds += sec;
        if(seconds > 59) {
            setMinutes( minute + (seconds/60));
            seconds = seconds % 60;
        }
    }
    public void setHour(int hr) {
        this.hour += hr;
        if(hour > 23) {
            hour = hour % 24;
        }
    }

    public String toString() {
        return getHour()+":"+getMinutes()+":"+getSeconds();
    }

}// end class