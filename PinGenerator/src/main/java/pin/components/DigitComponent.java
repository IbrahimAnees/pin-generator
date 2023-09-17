package pin.components;

import java.util.Random;
/**
 * Represents a component that generates a random digit for password generation.
 * Implements the PasswordComponent interface.
 */
public class DigitComponent implements PasswordComponent {
    /** Contains all possible digit characters. */
    public static final String DIGITS = "0123456789";

    /**
     * Generates a random digit character from 0-9.
     *
     * @return A string representation of the generated digit.
     */
    @Override
    public String generateComponent() {
        Random rand = new Random();
        return Character.toString(DIGITS.charAt(rand.nextInt(DIGITS.length())));
    }
}
