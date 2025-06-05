/*****************************
Query the University Database
*****************************/
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.util.*;
import java.lang.String;
import java.util.Scanner;
import java.sql.Types;


public class MyQuery {

    private Connection conn = null;
	 private Statement statement = null;
	 private ResultSet resultSet = null;
    
    public MyQuery(Connection c)throws SQLException
    {
        conn = c;
        // Statements allow to issue SQL queries to the database
        statement = conn.createStatement();
    }
    
    public void findFall2009Students() throws SQLException
    {
        String query  = "select distinct name from student natural join takes where semester = \'Fall\' and year = 2009;";

        resultSet = statement.executeQuery(query);
    }
    
    public void printFall2009Students() throws IOException, SQLException
    {
	      System.out.println("******** Query 0 ********");
         System.out.println("name");
         while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number which starts at 1
			String name = resultSet.getString(1);
         System.out.println(name);
   		}        
    }

    public void findGPAInfo() throws SQLException
    {
        String query  = "SELECT distinct s.id, s.name, " +
                "round(sum(case t.grade when 'A'  then 4.0 when 'A-' then 3.7 when 'B+' then 3.3 when 'B'  "+
                "then 3.0 when 'B-' then 2.7 when 'C+' then 2.3 when 'C'  then 2.0 when 'C-' then 1.7 when 'D+' " +
                "then 1.3 when 'D'  then 1.0 when 'D-' then 0.7 when 'F'  then 0.0 else NULL end * c.credits) " +
                "/ sum(c.credits), 2) as GPA\n" +
                "FROM student s\n" +
                "left join takes t on s.id = t.id\n" +
                "left join course c on t.course_id = c.course_id\n" +
                "WHERE t.grade is not NULL\n" +
                "GROUP BY s.id, s.name;";

        resultSet = statement.executeQuery(query);
    }
    
    public void printGPAInfo() throws IOException, SQLException
    {
		   System.out.println("******** Query 1 ********");

        System.out.printf("%-10s %-10s %-10s%n", "ID", "Name", "GPA");

        while (resultSet.next()) {
            // Retrieve data by column index
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String gpa = resultSet.getString(3);

            // Print data
            System.out.printf("%-10s %-10s %-10s%n", id, name, gpa);
        }
    }

    public void findMorningCourses() throws SQLException
    {
        String query  = "SELECT distinct c.course_id, s.sec_id, c.title, s.semester, s.year, i.name as instructor_name, " +
                "enrollment.enrollment_number\n" +
                "FROM course c join section s on c.course_id = s.course_id join time_slot ts on s.time_slot_id = ts.time_slot_id "+
                "and ts.start_hr<12 join teaches t on s.course_id = t.course_id and s.sec_id = t.sec_id and s.semester = t.semester " +
                "and s.year = t.year join instructor i on t.id = i.id\n" +
                "join(SELECT tk.course_id, tk.sec_id, tk.semester, tk.year, count(DISTINCT tk.id) as enrollment_number\n" +
                "    FROM takes tk GROUP BY tk.course_id, tk.sec_id, tk.semester, tk.year)enrollment on " +
                "s.course_id = enrollment.course_id and s.sec_id = enrollment.sec_id and " +
                "s.semester = enrollment.semester and s.year = enrollment.year\n" +
                "WHERE enrollment.enrollment_number > 0 ORDER BY c.course_id, s.sec_id;";

        resultSet = statement.executeQuery(query);
    }

    public void printMorningCourses() throws IOException, SQLException
    {
	   	System.out.println("******** Query 2 ********");

        System.out.printf("%-10s %-10s %-30s %-10s %-10s %-20s %-10s%n", "course_id", "sec_id", "title", "semester", "year", "instructor_name", "enrollment");

        while (resultSet.next()) {
            String course_id = resultSet.getString(1);
            String sec_id = resultSet.getString(2);
            String title = resultSet.getString(3);
            String semester = resultSet.getString(4);
            String year = resultSet.getString(5);
            String name = resultSet.getString(6);
            String enrollment = resultSet.getString(7);

            System.out.printf("%-10s %-10s %-30s %-10s %-10s %-20s %-10s%n", course_id, sec_id, title, semester, year, name, enrollment);
        }
    }

    public void findBusyClassroom() throws SQLException
    {
        String query  = "SELECT room.building, room.room_number, room.frequency\n" +
                "FROM (SELECT building, room_number, count(*) as frequency FROM section " +
                "GROUP BY building, room_number) as room\n" +
                "WHERE room.frequency = (\nSELECT max(frequency)\n" +
                "    FROM (SELECT building, room_number, count(*) as frequency FROM section \n" +
                "    GROUP BY building, room_number) as classroom_frequency);";

        resultSet = statement.executeQuery(query);
    }

    public void printBusyClassroom() throws IOException, SQLException
    {
		   System.out.println("******** Query 3 ********");

            System.out.printf("%-10s %-13s %-10s%n", "building", "room_number", "frequency");

            while (resultSet.next()) {
                String building = resultSet.getString(1);
                String room_number = resultSet.getString(2);
                String frequency = resultSet.getString(3);

                System.out.printf("%-10s %-13s %-10s%n", building, room_number, frequency);
            }
    }

    public void findPrereq() throws SQLException
    {
        String query  = "SELECT c.title as course, coalesce(p2.title, 'N/A') as prereq\n" +
                "FROM course c LEFT JOIN prereq p on c.course_id = p.course_id " +
                "LEFT JOIN course p2 on p.prereq_id = p2.course_id\n ORDER BY c.course_id;";

        resultSet = statement.executeQuery(query);
    }

    public void printPrereq() throws IOException, SQLException
    {
		   System.out.println("******** Query 4 ********");

            System.out.printf("%-40s %-10s%n", "course", "prereq");

            while (resultSet.next()) {
                String course = resultSet.getString(1);
                String prereq = resultSet.getString(2);

                System.out.printf("%-40s %-10s%n", course, prereq);
            }
    }

    public boolean StudentCopyCreated() throws SQLException {
        String checkTable = "SHOW TABLES LIKE 'studentCopy';";
        ResultSet resultSet = statement.executeQuery(checkTable);
        return resultSet.next();
    }
    public void updateTable() throws SQLException
    {
        if (!StudentCopyCreated()) {
            // Create BookCopy table as a copy of BOOKS
            String createCopy = "CREATE TABLE studentCopy as SELECT * FROM student;";
            statement.execute(createCopy);
            System.out.println("studentCopy table created.");
        } else {
            System.out.println("studentCopy table already exists.");
        }

        String update = "UPDATE studentCopy sc\n" +
                "        JOIN (SELECT s.id, sum(c.credits) as total_credits FROM student s LEFT JOIN takes t on s.id = t.id\n" +
                "        LEFT JOIN course c on t.course_id = c.course_id\n" +
                "        WHERE t.grade is not null and t.grade <> 'F'\n" +
                "        group by s.id) credits on sc.id = credits.id set sc.tot_cred = credits.total_credits;";
        statement.executeUpdate(update);

        String query  = "SELECT sc.id, sc.name, sc.dept_name,sc.tot_cred, ifnull(course_count.course_num, 0) as course_num\n" +
                "FROM studentCopy sc\n LEFT JOIN (SELECT t.id, count(DISTINCT t.course_id) as course_num FROM takes t GROUP BY t.id) \n" +
                "course_count on sc.id = course_count.id;";

        resultSet = statement.executeQuery(query);
    }

    public void printUpdatedTable() throws IOException, SQLException
    {
		   System.out.println("******** Query 5 ********");

            System.out.printf("%-10s %-10s %-15s %-10s %-10s%n", "id", "name", "dept_name", "tot_cred", "# of courses");

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String dept_name = resultSet.getString(3);
                String tot_cred = resultSet.getString(4);
                String courses = resultSet.getString(5);

                System.out.printf("%-10s %-10s %-15s %-10s %-10s%n", id, name, dept_name, tot_cred, courses);
            }
    }

    public void findDeptInfo(String deptName) throws SQLException {
        String query = "{CALL getDeptInfo(?)}";
        try (CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, deptName);
            boolean hasMoreResults = stmt.execute();
            while (hasMoreResults) {
                try (ResultSet rs = stmt.getResultSet()) {
                    while (rs.next()) {
                        System.out.println(rs.getString("Department_Information"));
                    }
                }
                hasMoreResults = stmt.getMoreResults();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }










    public void findFirstLastSemester() throws SQLException
    {
        String query  = "SELECT s.id, s.name, concat(case\n" +
                "            when min(concat(t.year, '-', field(t.semester, 'Spring', 'Summer', 'Fall'))) like '%-1' then 'Spring'\n" +
                "            when min(concat(t.year, '-', field(t.semester, 'Spring', 'Summer', 'Fall'))) like '%-2' then 'Summer'\n" +
                "            when min(concat(t.year, '-', field(t.semester, 'Spring', 'Summer', 'Fall'))) like '%-3' then 'Fall'\n" +
                "        end,' ', substring(min(concat(t.year, '-', field(t.semester, 'Spring', 'Summer', 'Fall'))), 1, 4)) as first_semester,\n" +
                "    concat(case \n" +
                "            when max(concat(t.year, '-', field(t.semester, 'Spring', 'Summer', 'Fall'))) like '%-1' then 'Spring'\n" +
                "            when max(concat(t.year, '-', field(t.semester, 'Spring', 'Summer', 'Fall'))) like '%-2' then 'Summer'\n" +
                "            when max(concat(t.year, '-', field(t.semester, 'Spring', 'Summer', 'Fall'))) like '%-3' then 'Fall'\n" +
                "        end,' ',substring(max(concat(t.year, '-', field(t.semester, 'Spring', 'Summer', 'Fall'))), 1, 4)) as last_semester\n" +
                "FROM takes t natural join student s\n" +
                "GROUP BY s.id, s.name;";

        resultSet = statement.executeQuery(query);
    }

    public void printFirstLastSemester() throws IOException, SQLException
    {
        System.out.println("******** Query 7 ********");

        System.out.printf("%-10s %-10s %-15s %-10s%n", "id", "name", "first_semester", "last_semester");

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String first_semester = resultSet.getString(3);
            String last_semester = resultSet.getString(4);

            System.out.printf("%-10s %-10s %-15s %-10s%n", id, name, first_semester, last_semester);
        }
    }

}
