package pin.components;
/**
 * Factory class for creating password components based on specified types.
 */
public class PasswordComponentFactory {
    /**
     * Returns a password component based on the specified type.
     *
     * @param type The type of password component.
     * @return A {@code PasswordComponent} object or null if type is not recognized.
     */
    public PasswordComponent getComponent(String type) {
        switch (type) {
            case "digit":
                return new DigitComponent();
            case "uppercase":
                return new UpperCaseComponent();
            case "lowercase":
                return new LowerCaseComponent();
            case "specialchar":
                return new SpecialCharComponent();
            default:
                return null;
        }
    }
}