package pin.components;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
/**
 * Test class for the PasswordComponentFactory.
 * Tests various scenarios including valid type inputs and invalid type inputs.
 */
public class PasswordComponentFactoryTest {

    private PasswordComponentFactory factory;

    @Before
    public void setUp() {
        factory = new PasswordComponentFactory();
    }

    /**
     * Tests if the correct PasswordComponent type (DigitComponent) is returned
     * when "digit" is provided as the type to the factory.
     */
    @Test
    public void testGetDigitComponent() {
        PasswordComponent component = factory.getComponent("digit");
        assertTrue(component instanceof DigitComponent);
    }

    /**
     * Tests if the correct PasswordComponent type (UpperCaseComponent) is returned
     * when "uppercase" is provided as the type to the factory.
     */
    @Test
    public void testGetUpperCaseComponent() {
        PasswordComponent component = factory.getComponent("uppercase");
        assertTrue(component instanceof UpperCaseComponent);
    }

    /**
     * Tests if the correct PasswordComponent type (LowerCaseComponent) is returned
     * when "lowercase" is provided as the type to the factory.
     */
    @Test
    public void testGetLowerCaseComponent() {
        PasswordComponent component = factory.getComponent("lowercase");
        assertTrue(component instanceof LowerCaseComponent);
    }

    /**
     * Tests if the correct PasswordComponent type (SpecialCharComponent) is returned
     * when "specialchar" is provided as the type to the factory.
     */
    @Test
    public void testGetSpecialCharComponent() {
        PasswordComponent component = factory.getComponent("specialchar");
        assertTrue(component instanceof SpecialCharComponent);
    }

    /**
     * Tests if a null value is returned when an invalid type is provided
     * to the factory.
     */
    @Test
    public void testGetInvalidComponent() {
        PasswordComponent component = factory.getComponent("invalidType");
        assertNull(component);
    }
}
