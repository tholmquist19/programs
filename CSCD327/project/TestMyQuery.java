/*******************************************************
Tester for the project
By: Dan Li
*******************************************************/
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class TestMyQuery {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            try {
                    Connection conn = getConnection();
                    MyQuery mquery = new MyQuery(conn);
                    
     				     // Query 0
                    mquery.findFall2009Students();
                    mquery.printFall2009Students();
                    
                    // Query 1
                    mquery.findGPAInfo();
                    mquery.printGPAInfo();

                    // Query 2
                    mquery.findMorningCourses();
                    mquery.printMorningCourses();
                    
                    // Query 3
                    mquery.findBusyClassroom();
                    mquery.printBusyClassroom();
                    
                    // Query 4
                    mquery.findPrereq();
                    mquery.printPrereq();
                
                    // Query 5
                    mquery.updateTable();
                    mquery.printUpdatedTable();
                    
                    // Query 6
                    System.out.println("Please enter the Department name: ");
                    String deptName = scanner.nextLine();
                    mquery.findDeptInfo(deptName);
                    
                    // Query 7      
                    mquery.findFirstLastSemester();
                    mquery.printFirstLastSemester();
				
                    conn.close();
            } catch (SQLException e) {
                    e.printStackTrace();
            }
            catch (IOException e) {
                    e.printStackTrace();
            }
        }
        
        public static Connection getConnection() throws SQLException{
            Connection connection; 
            try {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                             
                 } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
            }

            //Create a connection to the database
            String serverName = "10.219.0.50:3306";
            String mydatabase = "s24tholmquist_universityDB"; //change needed
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a JDBC url
            String username = "s24tholmquist"; //change needed
            String password = "Seahawks24!?"; //change needed

            connection = DriverManager.getConnection(url, username, password);
            return connection;

        }
}
