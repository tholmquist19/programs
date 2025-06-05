package lab9.cscd211methods;

import java.util.*;
import lab9.cscd211classes.*;
import lab9.cscd211classes.players.*;

/**
 * I have provided the menu method for you.  You must write the fill method. Please look at the file teamlist.txt
 * <br>
 * The file format is City\n Number of teams\n Type, Team Name\n Number of Players\n <br>
 * player name, ssn, salary, position, specific info based on type <br>
 * if football then # of touch downs, jersey number <br>
 * if baseball then batting average <br>
 * if hockey then jersey number <br>
 *
 * @NOTE All parameters passed must be final
 */
public class CSCD211Lab9Methods
{	
   /**
    * reads from the file and creates the appropriate player for the array and 
    * creates the appropriate team
    *
    * @param fin Scanner object
    * @param myTeam ArrayList of type Team
    *
    * @throws IllegalArgumentException for fin or myTeam being null
    * @throws CloneNotSupportedException to propagate the clone method
    *
    * @NOTE To add to MyArrayList it is an addLast method call myTeam.addLast(team stuff)
    */
   public static void fillArrayList(final Scanner fin, final ArrayList<Team>myTeam)throws CloneNotSupportedException
   {
      /**  if (fin == null) {
            throw new IllegalArgumentException("scanner is null");
        }
        if (total < 1) {
            throw new IllegalArgumentException("total is invalid(less than 1)");
        }
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Players[] players = new Players[total];
        for(int i=0; i<total; i++) {
            String data = fin.nextLine().trim();
            String[] playerData = data.split(",");
            players[i]= new Players(playerData[0],
                    Integer.parseInt(playerData[1]),
                    Integer.parseInt(playerData[2]), Integer.parseInt(playerData[3]),
                    playerData[4], playerData[5], playerData[6],
                    playerData[7], playerData[8], playerData[9],
                    Integer.parseInt(playerData[10]), Integer.parseInt(playerData[11]),
                    playerData[12].charAt(0),
                    playerData[13].charAt(0),
                    format.parse(playerData[14]),
                    format.parse(playerData[15]), playerData[16], playerData[17]);
        }
        return players;
        */
      if(fin == null){
         throw new IllegalArgumentException("Scanner is null");
      }
      if(myTeam == null){
         throw new IllegalArgumentException("Array list is null");
      }
      String city, teamName, ssn, position, sport;
      String name, salary_s, jn_s = "", stat_s;
      int  salary, jn, teamNum;
      Player[] players;


      while (fin.hasNext()) {
         city = fin.nextLine();
         teamNum = Integer.parseInt(fin.nextLine());
         while (teamNum > 0) {
            String name2 = fin.nextLine().trim();
            String[] tName = name2.split(",");
            sport = tName[0];
            teamName=tName[1];

            int num = Integer.parseInt(fin.nextLine());

            players = new Player[num];

            for (int i = 0; i < players.length; i++) {
               String data = fin.nextLine().trim();
               String[] playerData = data.split(",");
               name = playerData[0].trim();
               ssn = playerData[1];
               salary_s = playerData[2];
               position = playerData[3];
               stat_s = playerData[4];
               salary = Integer.parseInt(salary_s.trim());
               if (stat_s.contains(".")) {
                  players[i] = new BaseballPlayer(name, ssn, salary, position, Double.parseDouble(stat_s.trim()));
               } else if (sport.equals("Football")) {
                  jn_s = playerData[5];
                  jn = Integer.parseInt(jn_s.trim());
                  players[i] = new FootballPlayer(name, ssn, salary, position, Integer.parseInt(stat_s.trim()), jn);
               } else {
                  players[i] = new HockeyPlayer(name, ssn, salary, position, Integer.parseInt(stat_s.trim()));
               }
            }

            myTeam.add(new Team(city, teamName, players));
            teamNum--;
         }
      }

   }// end createAndFill
   
   /**
    * The menu method ensures a valid choice is entered and returns that value
    * <br> 1 Print all Teams
    * <br> 2 Sort all Teams by city and team name
    * <br> 3 Sort all Teams by Payroll
    * <br> 4 Exit program
    *
    * @param kb Representing a valid Scanner object
    * @return int Representing the menu choice
    *
    * @throws IllegalArgumentException If Scanner is null
    */
   public static int menu(final Scanner kb)
   {
      if (kb == null)
         throw new IllegalArgumentException("Error Precond: Scanner cannot be null - menu");
         
      int choice;
      
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) Print all Teams");
         System.out.println("2) Sort all Teams by city and team name");
         System.out.println("3) Sort all Teams by Payroll");
         System.out.println("4) Exit program");
         System.out.print("Choice --> ");
         choice = kb.nextInt();
         kb.nextLine();
      } while (choice < 1 || choice > 4);
      
      return choice;  
   }// end menu
   
}// end class