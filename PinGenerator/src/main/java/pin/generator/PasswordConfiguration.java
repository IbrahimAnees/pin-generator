package pin.generator;

import java.util.HashMap;
import java.util.Map;
/**
 * Represents the configuration for password generation.
 * Allows specification of the count for different types of password components.
 */
public class PasswordConfiguration {
    /** Map storing counts for each component type. */
    private Map<String, Integer> componentCountMap = new HashMap<>();

    /**
     * Sets the count for a specified component type.
     *
     * @param componentType The type of the password component (e.g., "digit", "uppercase").
     * @param count The count of the specified component to be used in password generation.
     */
    public void setComponentCount(String componentType, int count) {
        componentCountMap.put(componentType, count);
    }

    /**
     * Retrieves the map containing the counts for each component type.
     *
     * @return A map where the key is the component type and the value is its count.
     */
    public Map<String, Integer> getComponentCountMap() {
        return componentCountMap;
    }
}
