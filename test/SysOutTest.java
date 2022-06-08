import org.junit.contrib.java.lang.system.SystemOutRule;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.Rule;


public class SysOutTest {
	// @Rule
	// public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Test
	public void writesTextToSystemOut() {
        final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
		System.out.print(String.format("hello world%n"));
		assertEquals("hello world\n", systemOutRule.getLog());
        // assertEquals("hello world\n", "hi");

	}
}