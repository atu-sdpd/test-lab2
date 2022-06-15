import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import java.util.Scanner;

public class JavaIf9Test {

    @Test
    void testJavaIf9_Even() throws Exception {
        // Regular expression pattern for expected output
        // \\W* matches one or more non-word characters (i.e. not [a-zA-Z_0-9])
        // (useful for variations in spacing, use of colons etc)
        String expectedOutput = "Enter number\\W*"
            + "The number entered is even\\n*";

        // Compiling the pattern with the CASE_INSENSITIVE flag will make the 
        // resulting matches case insensitive
        Pattern expectedPattern = Pattern.compile(expectedOutput, Pattern.CASE_INSENSITIVE);
       
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("4")
                .execute(() -> {
                    JavaIf9.main(new String[0]);
                });           
        });
        assertThat(output, matchesPattern(expectedPattern));
    }

    @Test
    void testJavaIf9_Odd() throws Exception {
        // Regular expression pattern for expected output
        // \\W* matches one or more non-word characters (i.e. not [a-zA-Z_0-9])
        // (useful for variations in spacing, use of colons etc)
        String expectedOutput = "Enter number\\W*"
            + "The number entered is odd\\n*";

        // Compiling the pattern with the CASE_INSENSITIVE flag will make the 
        // resulting matches case insensitive
        Pattern expectedPattern = Pattern.compile(expectedOutput, Pattern.CASE_INSENSITIVE);
       
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("9")
                .execute(() -> {
                    JavaIf9.main(new String[0]);
                });           
        });
        assertThat(output, matchesPattern(expectedPattern));
    }    
}