package pin.strengthchecker;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the PasswordStrengthChecker.
 * Validates the password strength categorization across various test cases.
 */
public class PasswordStrengthCheckerTest {

    private PasswordStrengthChecker checker;

    /**
     * Sets up the environment before each test execution.
     * Initializes the PasswordStrengthChecker.
     */
    @Before
    public void setUp() {
        checker = new PasswordStrengthChecker();
    }

    /**
     * Tests the strength categorization for a password with weak length.
     */
    @Test
    public void testWeakLengthPassword() {
        String password = "Ab1!";
        assertEquals("Weak", checker.checkStrength(password));
    }

    /**
     * Tests the strength categorization for a very strong password.
     */
    @Test
    public void testVeryStrongPassword() {
        String password = "Ab1!wxyz";
        assertEquals("Very Strong", checker.checkStrength(password));
    }

    /**
     * Tests the strength categorization for a strong password missing a lowercase character.
     */
    @Test
    public void testStrongPasswordMissingLowerCase() {
        String password = "AB1!WXYZ";
        assertEquals("Strong", checker.checkStrength(password));
    }

    /**
     * Tests the strength categorization for a strong password missing a digit.
     */
    @Test
    public void testStrongPasswordMissingDigit() {
        String password = "Abc!wxyz";
        assertEquals("Strong", checker.checkStrength(password));
    }

    /**
     * Tests the strength categorization for a moderate password missing an uppercase character and a digit.
     */
    @Test
    public void testModeratePasswordMissingUppercaseAndDigit() {
        String password = "ab!cdefgh";
        assertEquals("Moderate", checker.checkStrength(password));
    }

    /**
     * Tests the strength categorization for a weak password missing three criteria (digit, special char, and uppercase).
     */
    @Test
    public void testWeakPasswordMissingThreeCriteria() {
        String password = "abcdefgh";
        assertEquals("Weak", checker.checkStrength(password));
    }
}

