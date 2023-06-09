package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringSchemaTest {
    private Validator v = new Validator();;
    private StringSchema schema;

    @Test
    @DisplayName("Required (empty or null string)")
    public void testRequired() {
        schema = v.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        assertFalse(schema.required().isValid(""));
        assertFalse(schema.required().isValid(null));
    }

    @Test
    @DisplayName("Min length")
    public void testMinLength() {
        schema = v.string().minLength(8);
        assertTrue(schema.isValid("Some long string"));
        assertFalse(schema.isValid("Short"));
        assertTrue(schema.minLength(0).isValid("Short"));
    }

    @Test
    @DisplayName("Contains")
    public void testContains() {
        schema = v.string();
        assertTrue(schema.isValid("Hexlet"));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(schema.isValid("what does the fox say"));
    }
}
