package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        super.addCheck("required", value -> value != null);
    }

    public MapSchema required() {
        super.required = true;
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
        super.addCheck("shape", value -> checkMap(schema, value));
    }

    private boolean checkMap(Map<String, BaseSchema> schema, Object valMap) {
        Map map = (Map) valMap;
        Map<String, BaseSchema> schemas = new HashMap<>(schema);

        Set<String> schemasKey = schemas.keySet();
        for (String key: schemasKey) {
            Object value = map.get(key);
            BaseSchema baseSchema = schemas.get(key);
            if (!baseSchema.isValid(value)) {
                return false;
            }
        }
        return true;
    }
}
