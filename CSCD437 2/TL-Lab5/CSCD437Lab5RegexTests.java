import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CSCD437Lab5RegexTests {

    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setup() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @Test
    public void emailPattern_valid_format_prints_valid_response() {
        String validEmail = "t.holmquist@gmail.com";
        CSCD437RegExMethods.emailPattern(validEmail, new PrintStream(testOut));
        assertFalse(testOut.toString().contains("NOT"));
    }

    @Test
    public void emailPattern_valid_format_prints_valid_response2() {
        String validEmail = "tholmquist@gmail.com";
        CSCD437RegExMethods.emailPattern(validEmail, new PrintStream(testOut));
        assertFalse(testOut.toString().contains("NOT"));
    }

    @Test
    public void emailPattern_valid_format_prints_valid_response3() {
        String validEmail = "t.holmquist.9080@ghost.com";
        CSCD437RegExMethods.emailPattern(validEmail, new PrintStream(testOut));
        assertFalse(testOut.toString().contains("NOT"));
    }

    @Test
    public void emailPattern_valid_format_prints_valid_response4() {
        String validEmail = "tholmquist9080@gmail.com";
        CSCD437RegExMethods.emailPattern(validEmail, new PrintStream(testOut));
        assertFalse(testOut.toString().contains("NOT"));
    }

    @Test
    public void emailPattern_valid_format_prints_valid_response5() {
        String validEmail = "t.holmquist@yahoo.com";
        CSCD437RegExMethods.emailPattern(validEmail, new PrintStream(testOut));
        assertFalse(testOut.toString().contains("NOT"));
    }






    @Test
    public void emailPattern_invalid_format_prints_invalid_response() {
        String validEmail = "tholmquis789w9";
        CSCD437RegExMethods.emailPattern(validEmail, new PrintStream(testOut));
        assertTrue(testOut.toString().contains("NOT"));
    }

    @Test
    public void emailPattern_invalid_format_prints_invalid_response2() {
        String validEmail = "t.jolmquist@.gkdjd";
        CSCD437RegExMethods.emailPattern(validEmail, new PrintStream(testOut));
        assertTrue(testOut.toString().contains("NOT"));
    }

    @Test
    public void emailPattern_invalid_format_prints_invalid_response3() {
        String validEmail = "tholmquist_gjd@yahoo.com";
        CSCD437RegExMethods.emailPattern(validEmail, new PrintStream(testOut));
        assertTrue(testOut.toString().contains("NOT"));
    }

    @Test
    public void emailPattern_invalid_format_prints_invalid_response4() {
        String validEmail = "tholmquist.@gmail.com";
        CSCD437RegExMethods.emailPattern(validEmail, new PrintStream(testOut));
        assertTrue(testOut.toString().contains("NOT"));
    }


}
