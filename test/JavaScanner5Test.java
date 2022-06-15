import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import java.util.Scanner;

public class JavaScanner5Test {

    @Test
    void testJavaScanner5() throws Exception {
        // Regular expression pattern for expected output
        // \\W* matches one or more non-word characters (i.e. not [a-zA-Z_0-9])
        // (useful for variations in spacing, use of colons etc)
        String expectedOutput = "Enter integer number\\W*" 
            + "Enter decimal point number\\W*"
            + "First number entered was\\W*11\\n"
            + "Second number entered was\\W*6.4"
            + "\\W*"
            + "Sum of numbers\\W*17.4\\n*" 
            + "Average of numbers\\W*8.7\\n*";

        // Compiling the pattern with the CASE_INSENSITIVE flag will make the 
        // resulting matches case insensitive
        Pattern expectedPattern = Pattern.compile(expectedOutput, Pattern.CASE_INSENSITIVE);
       
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("11", "6.4")
                .execute(() -> {
                    JavaScanner5.main(new String[0]);
                });           
        });
        assertThat(output, matchesPattern(expectedPattern));
    }
}