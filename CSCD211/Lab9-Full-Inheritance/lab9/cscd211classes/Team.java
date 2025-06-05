package lab9.cscd211classes;

import java.util.*;
import lab9.cscd211interfaces.*;
import lab9.cscd211classes.players.*;

/**
 * The Team class that defines the information about a team.
 */
public class Team implements Taxable, Payroll, Comparable<Team>{
   protected String city;
   protected String teamName;
   protected int payroll;
   protected ArrayList<Player> players;

   public Team(String city, String teamName, Player[] players)throws CloneNotSupportedException{
      this.city = city;
      this.teamName=teamName;
      this.players = new ArrayList<>();

      for (Player player: players)
         this.players.add(player.clone());
   }

   public String getTeamName(){
      return this.teamName;
   }

   public ArrayList<Player> getPlayers(){
      return this.players;
   }

   public String getCity(){
      return this.city;
   }

   public int getPayroll(){
      return this. payroll;
   }

   @Override
   public int compareTo(Team pi) {
      if(this.city.equals(pi.city)){
         return CharSequence.compare(this.teamName, pi.teamName);
      }
      else return CharSequence.compare(this.city, pi.city);
   }

   @Override
   public int calculatePayroll() {
      for(int i=0; i<players.size();i++){
         this.payroll += players.get(i).getSalary();
      }

      return this.payroll+BASE_PAYROLL;
   }

   @Override
   public double calculateTaxes() {
      double taxes=0;
      for(int i=0; i<players.size(); i++){
         taxes=players.get(i).getSalary();
         if(taxes>250000){
            taxes *= BASE_TAX_RATE;
         }
         else{
            taxes *= (BASE_TAX_RATE-.1);
         }
      }
      return taxes;
   }

   public String toString(){
      return getCity()+"-"+getTeamName()+"\n" +
              "Payroll: "+calculatePayroll()+"\n" +
              "Taxes "+calculateTaxes()+"\n" +
              "PLAYER NAME     SSN     SALARY     POSITION     STATS      NUMBER\n"
              +"-----------------------------------------------------------------\n"+getPlayers()+"\n";
   }
}// end class