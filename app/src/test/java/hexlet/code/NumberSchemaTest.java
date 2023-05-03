package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class NumberSchemaTest {
    private Validator v = new Validator();;
    private NumberSchema schema;

    @BeforeEach
    public void init() {
        schema = v.number();
    }

    @Test
    @DisplayName("Required")
    public void testRequired() {
        assertTrue(schema.isValid(null));
        assertFalse(schema.required().isValid(null));
    }

    @Test
    @DisplayName("String input")
    public void testIsValidStringInput() {
        assertFalse(schema.isValid("5"));
    }

    @Test
    @DisplayName("Positive")
    public void testPositive() {
        assertTrue(schema.positive().isValid(null));
        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(-5));
        assertFalse(schema.isValid(0));
    }

    @Test
    @DisplayName("Range")
    public void testRange() {
        assertTrue(schema.positive().range(5, 10).isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.positive().range(-15, 10).isValid(-5));
    }

}
