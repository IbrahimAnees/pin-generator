package pin.components;

import java.util.Random;
/**
 * Represents a component that generates a random lowercase character for password generation.
 * Implements the PasswordComponent interface.
 */
public class LowerCaseComponent implements PasswordComponent {
    /** Contains all possible lowercase characters. */
    public static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Generates a random lowercase character.
     *
     * @return A string representation of the generated lowercase character.
     */
    @Override
    public String generateComponent() {
        Random rand = new Random();
        return Character.toString(LOWERCASE.charAt(rand.nextInt(LOWERCASE.length())));
    }
}