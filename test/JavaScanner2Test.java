import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class JavaScanner2Test {

    @Test
    void testJavaScanner2() throws Exception {
        String expected = "Enter first number: Enter second number: Enter third number: " 
            + "First number entered was: 54\nSecond number entered was: 43\nThird number entered was: 27\n";

        String output = tapSystemOut(() -> {
            withTextFromSystemIn("54", "43", "27")
                .execute(() -> {
                    JavaScanner2.main(new String[0]);
                });           
        });
        assertEquals(expected, output);
    }
}