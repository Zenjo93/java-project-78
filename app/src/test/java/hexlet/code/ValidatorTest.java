package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    @Test
    @DisplayName("StringSchema instance creation")
    public void testString() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema).isInstanceOf(StringSchema.class);

    }

    @Test
    @DisplayName("NumberSchema instance creation")
    public void testNumber() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertThat(schema).isInstanceOf(NumberSchema.class);
    }

    @Test
    @DisplayName("MapSchema instance creation")
    public void testMap() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        assertThat(schema).isInstanceOf(MapSchema.class);
    }

}
