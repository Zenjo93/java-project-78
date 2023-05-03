package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {
    Validator v = new Validator();;
    MapSchema schema;

    @BeforeEach
    public void init(){
        schema = v.map();
    }

    @Test
    @DisplayName("Required")
    public void testRequired() {
        assertTrue(schema.isValid(null));
        assertFalse(schema.required().isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
    }

    @Test
    @DisplayName("SizeOf")
    public void testSizeOf() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));

        schema.sizeof(2);
        assertFalse(schema.sizeof(2).isValid(data));

        data.put("key2", "value2");
        assertTrue(schema.isValid(data));

    }
}
