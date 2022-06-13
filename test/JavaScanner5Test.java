import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class JavaScanner5Test {

    @Test
    void testJavaScanner5() throws Exception {
        String expected = "Enter integer number: "
            + "Enter decimal point number: " 
            + "First number entered was: 11\n" 
            + "Second number entered was: 6.4\n"
            + "Sum of numbers: 17.4\n"
            + "Average of numbers: 8.7\n";
       
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("11", "6.4")
                .execute(() -> {
                    JavaScanner5.main(new String[0]);
                });           
        });
        assertThat(expected, equalTo(output));
    }
}