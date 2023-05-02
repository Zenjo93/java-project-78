package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSchemaTest {

    @Test
    @DisplayName("Required: empty or null string")
    public void testRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertEquals(schema.isValid(""), true);
        assertEquals(schema.isValid(null), true);

        assertEquals(schema.required().isValid(""), false);
        assertEquals(schema.required().isValid(null), false);
    }

    @Test
    @DisplayName("Min length")
    public void testMinLength() {
        Validator v = new Validator();
        StringSchema schema = v.string().minLength(8);
        assertEquals(schema.isValid("Some long string"), true);
        assertEquals(schema.isValid("Short"), false);

        schema.minLength(0);
        assertEquals(schema.isValid("Short"), true);
    }

    @Test
    @DisplayName("Contains")
    public void testContains() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertEquals(schema.isValid("Hexlet"), true);

        schema.contains("xl");
        assertEquals(schema.isValid("Hexlet"), true);

        schema.contains("wh");
        assertEquals(schema.isValid("Hexlet"), false);

        schema.contains("xl");
        assertEquals(schema.isValid("Hexlet"), false);

    }

}
