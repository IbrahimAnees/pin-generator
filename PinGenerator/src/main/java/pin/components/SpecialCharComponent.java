package pin.components;

import java.util.Random;
/**
 * Represents a component that generates a random special character for password generation.
 * Implements the PasswordComponent interface.
 */
public class SpecialCharComponent implements PasswordComponent {
    /** Contains all possible special characters. */
    public static final String SPECIALCHARS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";

    /**
     * Generates a random special character.
     *
     * @return A string representation of the generated special character.
     */
    @Override
    public String generateComponent() {
        Random rand = new Random();
        return Character.toString(SPECIALCHARS.charAt(rand.nextInt(SPECIALCHARS.length())));
    }
}
