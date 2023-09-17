package pin.observer;
/**
 * Represents an observer that is notified when a password is generated.
 */
public interface PasswordObserver {
    /**
     * Called when a password is generated.
     *
     * @param password The generated password.
     */
    void onPasswordGenerated(String password);
}
