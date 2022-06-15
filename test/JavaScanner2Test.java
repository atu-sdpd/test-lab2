import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import java.util.regex.Pattern;

public class JavaScanner2Test {

    @Test
    void testJavaScanner2() throws Exception {      
        String expectedOutput = "Enter first number\\W*"
            + "Enter second number\\W*"
            + "Enter third number\\W*" 
            + "First number entered was\\W*54\n"
            + "Second number entered was\\W*43\n"
            + "Third number entered was\\W*27\\W*";

        Pattern expectedPattern = Pattern.compile(expectedOutput, Pattern.CASE_INSENSITIVE);        

        String output = tapSystemOut(() -> {
            withTextFromSystemIn("54", "43", "27")
                .execute(() -> {
                    JavaScanner2.main(new String[0]);
                });           
        });
        assertThat(output, matchesPattern(expectedPattern));
    }
}