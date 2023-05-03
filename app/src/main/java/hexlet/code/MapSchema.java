package hexlet.code;

import java.util.Map;

public class MapSchema {
    private boolean isRequired; // null как значение
    private int size;
    private boolean setSize;

    // TODO: Возврат BaseSchema?
    public MapSchema required() {
        this.isRequired = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        this.setSize = true;
        this.size = size;
        return this;
    }

    public boolean isValid(Map<?, ?> map) {
        if (map == null) {
            return !isRequired;
        }
        if (setSize && map.size() != size) {
            return false;
        }

        return true;
    }


}
