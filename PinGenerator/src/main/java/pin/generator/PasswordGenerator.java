package pin.generator;

import pin.components.PasswordComponent;
import pin.components.PasswordComponentFactory;
import pin.observer.PasswordObserver;

import java.util.*;
/**
 * This class provides functionality to generate passwords based on specific configurations.
 * It allows adding different password components, as well as notifying observers when a password is generated.
 */
public class PasswordGenerator {
    /** List of password components that form the base of the password. */
    private List<PasswordComponent> components = new ArrayList<>();
    /** Factory used to create specific password components. */
    private PasswordComponentFactory factory = new PasswordComponentFactory();
    /** List of observers to be notified when a password is generated. */
    private List<PasswordObserver> observers = new ArrayList<>();

    /**
     * Configures the password generator based on the provided configuration.
     * This sets the base components for the password generation.
     *
     * @param config The configuration specifying counts for different component types.
     */
    public void configure(PasswordConfiguration config) {
        components.clear();
        for (Map.Entry<String, Integer> entry : config.getComponentCountMap().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                components.add(factory.getComponent(entry.getKey()));
            }
        }
    }

    /**
     * Adds an observer to the list of observers to be notified when a password is generated.
     *
     * @param observer The observer to be added.
     */
    public void addObserver(PasswordObserver observer) {
        observers.add(observer);
    }

    /**
     * Generates a password of the specified length.
     * The generated password comprises of the set components and ensures no two identical characters are consecutive.
     * Characters in the password are also shuffled for added randomness.
     *
     * @param length The desired length of the generated password.
     * @return A generated password of the specified length.
     */
    public String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        for (PasswordComponent component : components) {
            String nextComponent;
            do {
                nextComponent = component.generateComponent();
            } while (password.length() > 0 && password.charAt(password.length() - 1) == nextComponent.charAt(0));
            password.append(nextComponent);
        }

        while (password.length() < length) {
            PasswordComponent randomComponent = components.get(rand.nextInt(components.size()));
            String nextComponent;
            do {
                nextComponent = randomComponent.generateComponent();
            } while (password.charAt(password.length() - 1) == nextComponent.charAt(0));
            password.append(nextComponent);
        }

        // Shuffle password characters for added randomness
        List<Character> chars = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            chars.add(c);
        }
        Collections.shuffle(chars);
        StringBuilder shuffledPassword = new StringBuilder();
        for (char c : chars) {
            shuffledPassword.append(c);
        }

        String finalPassword = shuffledPassword.toString();
        notifyObservers(finalPassword);
        return finalPassword;
    }


    /**
     * Notifies all registered observers with the newly generated password.
     *
     * @param password The generated password to notify observers with.
     */
    private void notifyObservers(String password) {
        for (PasswordObserver observer : observers) {
            observer.onPasswordGenerated(password);
        }
    }
}