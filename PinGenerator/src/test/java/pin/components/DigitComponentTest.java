package pin.components;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * Test class for the DigitComponent.
 * Ensures that the component generates a valid digit character.
 */
public class DigitComponentTest {

    /**
     * Tests the generateComponent method of the DigitComponent class.
     * Ensures that:
     * 1. The generated component is not null or empty.
     * 2. The generated component is indeed a digit.
     * 3. The generated component lies within the defined DIGITS range.
     */
    @Test
    public void testGenerateComponent() {
        DigitComponent digitComponent = new DigitComponent();
        String generatedComponent = digitComponent.generateComponent();

        // Check if the generated component is not null or empty
        assertTrue(generatedComponent != null && !generatedComponent.isEmpty());

        // Check if the generated component is a digit
        assertTrue(Character.isDigit(generatedComponent.charAt(0)));

        // Check if the generated component is within the defined DIGITS range
        assertTrue(DigitComponent.DIGITS.contains(generatedComponent));
    }
}

