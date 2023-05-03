package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSchema {
    private boolean isRequired; // null как значение
    private int size;
    private boolean setSize;
    private final Map<String, BaseSchema> schemas = new HashMap<>();
    private boolean setSchemas;

    // TODO: Возврат BaseSchema?
    public MapSchema required() {
        this.isRequired = true;
        return this;
    }

    public MapSchema sizeof(int s) {
        this.setSize = true;
        this.size = s;
        return this;
    }

    public void shape(Map<String, BaseSchema> s) {
        this.schemas.putAll(s);
        this.setSchemas = true;
        /*
        key: schema (v.string.required())

        // Проверка схемы по ключу
        schema.isValid(key)
         */
    }

    public boolean isValid(Map<?, ?> map) {
        if (map == null) {
            return !isRequired;
        }
        if (setSize && map.size() != size) {
            return false;
        }
        if (setSchemas) {
            Set<String> schemasKey = this.schemas.keySet();
            for (String key: schemasKey) {
                Object value = map.get(key);
                BaseSchema schema = schemas.get(key);
                if (!schema.isValid(value)) {
                    return false;
                }
            }
        }

        return true;
    }


}
