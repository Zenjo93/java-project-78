package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class MapSchema extends BaseSchema {
    private final Map<String, BaseSchema> schemas = new HashMap<>();

    public MapSchema required() {
        super.addCheck("required", value -> value != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        super.addCheck("sizeof", value -> checkSize((Map) value, size));
        return this;
    }

    private boolean checkSize(Map map, int size) {
        return map.size() == size;
    }

    public void shape(Map<String, BaseSchema> schema) {
        this.schemas.putAll(schema);

        super.addCheck("shape", value -> checkMap(value));

    }

    private boolean checkMap(Object valMap) {
        Map map = (Map) valMap;

        Set<String> schemasKey = this.schemas.keySet();
        for (String key: schemasKey) {
            Object value = map.get(key);
            BaseSchema schema = schemas.get(key);
            if (!schema.isValid(value)) {
                return false;
            }
        }
        return true;
    }
}
