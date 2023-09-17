package pin.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
/**
 * Test class for the PasswordConfiguration.
 * Ensures that the component count manipulation methods of PasswordConfiguration work as expected.
 */
public class PasswordConfigurationTest {

    private PasswordConfiguration passwordConfig;

    /**
     * Initializes test objects before each test.
     */
    @Before
    public void setUp() {
        passwordConfig = new PasswordConfiguration();
    }

    /**
     * Tests if the setComponentCount method correctly updates the component count map.
     */
    @Test
    public void testSetComponentCount() {
        passwordConfig.setComponentCount("digit", 2);

        Map<String, Integer> map = passwordConfig.getComponentCountMap();
        assertTrue(map.containsKey("digit"));
        assertEquals(Integer.valueOf(2), map.get("digit"));
    }

    /**
     * Tests if the getComponentCountMap method returns the correct map after multiple components have been set.
     */
    @Test
    public void testGetComponentCountMap() {
        passwordConfig.setComponentCount("digit", 3);
        passwordConfig.setComponentCount("uppercase", 4);

        Map<String, Integer> map = passwordConfig.getComponentCountMap();

        assertEquals(2, map.size());
        assertTrue(map.containsKey("digit"));
        assertEquals(Integer.valueOf(3), map.get("digit"));
        assertTrue(map.containsKey("uppercase"));
        assertEquals(Integer.valueOf(4), map.get("uppercase"));
    }

    /**
     * Tests if updating an existing component's count in the map works as expected.
     */
    @Test
    public void testUpdateComponentCount() {
        passwordConfig.setComponentCount("digit", 3);
        passwordConfig.setComponentCount("digit", 4);

        Map<String, Integer> map = passwordConfig.getComponentCountMap();

        assertTrue(map.containsKey("digit"));
        assertEquals(Integer.valueOf(4), map.get("digit"));
    }
}

