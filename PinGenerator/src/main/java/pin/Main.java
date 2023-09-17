package pin;

import pin.generator.PasswordConfiguration;
import pin.generator.PasswordGenerator;
import pin.observer.PasswordNotifier;
import pin.strengthchecker.PasswordStrengthChecker;
/**
 * Main entry point of the application.
 * This class demonstrates the process of password generation, notification, and strength checking.
 */
public class Main {
    /**
     * The main method which serves as the entry point for the application.
     * It configures password components, generates a password, notifies when the password is generated,
     * and finally checks and displays the strength of the generated password.
     *
     * @param args Command-line arguments (unused in this context).
     */
    public static void main(String[] args) {
        PasswordConfiguration config = new PasswordConfiguration();
        config.setComponentCount("digit", 2);
        config.setComponentCount("uppercase", 2);
        config.setComponentCount("lowercase", 2);
        config.setComponentCount("specialchar", 2);

        PasswordGenerator generator = new PasswordGenerator();
        generator.configure(config);
        generator.addObserver(new PasswordNotifier());
        String generatedPassword = generator.generatePassword(12);
        PasswordStrengthChecker checker = new PasswordStrengthChecker();
        System.out.println("Password Strength: " + checker.checkStrength(generatedPassword));
    }
}