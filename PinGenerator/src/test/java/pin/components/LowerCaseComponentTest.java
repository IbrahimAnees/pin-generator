package pin.components;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * Test class for the LowerCaseComponent.
 * Ensures that the component generates a valid lowercase character.
 */
public class LowerCaseComponentTest {

    /**
     * Tests the generateComponent method of the LowerCaseComponent class.
     * Ensures that:
     * 1. The generated component is not null or empty.
     * 2. The generated component is indeed a lowercase letter.
     * 3. The generated component lies within the defined LOWERCASE range.
     */
    @Test
    public void testGenerateComponent() {
        LowerCaseComponent lowerCaseComponent = new LowerCaseComponent();
        String generatedComponent = lowerCaseComponent.generateComponent();

        // Check if the generated component is not null or empty
        assertTrue(generatedComponent != null && !generatedComponent.isEmpty());

        // Check if the generated component is a lowercase letter
        assertTrue(Character.isLowerCase(generatedComponent.charAt(0)));

        // Check if the generated component is within the defined LOWERCASE range
        assertTrue(LowerCaseComponent.LOWERCASE.contains(generatedComponent));
    }
}
