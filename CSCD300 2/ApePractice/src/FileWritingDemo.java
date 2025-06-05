import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;

public class FileWritingDemo {
    public static void main(String[] args) {
        String destination = "file1.txt";
        float a = 3.134f;
        int age = 22;
        PrintStream ps = null;

        try {
            ps = new PrintStream(destination);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ps.println("File IO seems fun.");
        ps.println();
        ps.println("I love Java!");
        ps.print(a + "," + age + "\n");
        ps.printf("Today is: %1$tm/%1$td/%1$tY", LocalDate.now());

        if(ps != null)
            ps.close();

    }
}