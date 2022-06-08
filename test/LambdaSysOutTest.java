import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class LambdaSysOutTest {
    @Test
    void application_writes_text_to_System_out() throws Exception {
    String text = tapSystemOut(() -> {
        System.out.print("some text");
    });
    assertEquals("some text", text);
    }

    @Test
    void application_writes_mutliple_lines_to_System_out() throws Exception {
    String text = tapSystemOutNormalized(() -> {
        System.out.println("first line");
        System.out.println("second line");
    });
    assertEquals("first line\nsecond line\n", text);
    }
}