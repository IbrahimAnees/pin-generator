package pin.strengthchecker;
/**
 * Utility class for checking the strength of a password.
 * Provides methods to determine if a password is Weak, Moderate, Strong, or Very Strong based on certain criteria.
 */
public class PasswordStrengthChecker {
    /**
     * Checks and returns the strength of a given password.
     * The strength is determined based on the length of the password and its content (digits, uppercase and lowercase letters, special characters).
     *
     * @param password The password to be checked.
     * @return A string representation of the password's strength: "Weak", "Moderate", "Strong", or "Very Strong".
     */
    public String checkStrength(String password) {
        if (password.length() < 8) return "Weak";
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasLowerCase = !password.equals(password.toUpperCase());
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()-_=+\\[\\]{}|;:'\",.<>?].*");

        int strengthCount = (hasDigit ? 1 : 0) + (hasUpperCase ? 1 : 0) + (hasLowerCase ? 1 : 0) + (hasSpecialChar ? 1 : 0);

        switch (strengthCount) {
            case 4: return "Very Strong";
            case 3: return "Strong";
            case 2: return "Moderate";
            default: return "Weak";
        }
    }
}
