package pin.components;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * Test class for the UpperCaseComponent.
 * Ensures that the component generates a valid uppercase character.
 */
public class UpperCaseComponentTest {

    /**
     * Tests if the UpperCaseComponent generates a valid uppercase character.
     * Validates that the generated component:
     * 1. Is not null or empty.
     * 2. Is an uppercase letter.
     * 3. Belongs to the predefined UPPERCASE range.
     */
    @Test
    public void testGenerateComponent() {
        UpperCaseComponent upperCaseComponent = new UpperCaseComponent();
        String generatedComponent = upperCaseComponent.generateComponent();

        // Check if the generated component is not null or empty
        assertTrue(generatedComponent != null && !generatedComponent.isEmpty());

        // Check if the generated component is an uppercase letter
        assertTrue(Character.isUpperCase(generatedComponent.charAt(0)));

        // Check if the generated component is within the defined UPPERCASE range
        assertTrue(UpperCaseComponent.UPPERCASE.contains(generatedComponent));
    }
}
