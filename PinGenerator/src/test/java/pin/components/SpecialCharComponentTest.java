package pin.components;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * Test class for the SpecialCharComponent.
 * Ensures that the component generates a valid special character.
 */
public class SpecialCharComponentTest {
    /**
     * Tests if the SpecialCharComponent generates a valid special character.
     * Validates that the generated component:
     * 1. Is not null or empty.
     * 2. Is one of the predefined SPECIALCHARS.
     */
    @Test
    public void testGenerateComponent() {
        SpecialCharComponent specialCharComponent = new SpecialCharComponent();
        String generatedComponent = specialCharComponent.generateComponent();

        // Check if the generated component is not null or empty
        assertTrue(generatedComponent != null && !generatedComponent.isEmpty());

        // Check if the generated component is one of the defined SPECIALCHARS
        assertTrue(SpecialCharComponent.SPECIALCHARS.contains(generatedComponent));
    }
}
