package pin.components;

import java.util.Random;
/**
 * Represents a component that generates a random uppercase character for password generation.
 * Implements the PasswordComponent interface.
 */
public class UpperCaseComponent implements PasswordComponent {
    /** Contains all possible uppercase characters. */
    public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Generates a random uppercase character.
     *
     * @return A string representation of the generated uppercase character.
     */
    @Override
    public String generateComponent() {
        Random rand = new Random();
        return Character.toString(UPPERCASE.charAt(rand.nextInt(UPPERCASE.length())));
    }
}