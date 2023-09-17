package pin.observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the PasswordNotifier.
 * Validates the behavior of the notifier when a password is generated.
 */
public class PasswordNotifierTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private PasswordNotifier notifier;

    /**
     * Sets up the environment before each test execution.
     * Redirects the System.out to capture the printed content and initializes the PasswordNotifier.
     *
     * @throws Exception if any initialization errors occur
     */
    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        notifier = new PasswordNotifier();
    }

    /**
     * Restores the original System.out after each test execution.
     */
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Tests if the PasswordNotifier outputs the correct message when a password is generated.
     * Ensures that the printed message matches the expected format and content.
     */
    @Test
    public void testOnPasswordGenerated() {
        String testPassword = "Test123!";
        notifier.onPasswordGenerated(testPassword);

        String expected = ("Password has been generated: " + testPassword).trim();
        String actual = outContent.toString().trim();

        assertEquals(expected, actual);
    }
}


