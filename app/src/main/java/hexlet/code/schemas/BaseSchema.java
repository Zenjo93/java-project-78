package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Map<String, Predicate> checks = new LinkedHashMap<>();
    protected boolean required;

    protected final void addCheck(String name, Predicate validate) {
        checks.put(name, validate);
    }

    public final boolean isValid(Object value) {
        if ((value == null || value.toString().isEmpty()) && !required) {
            return true;
        }

        for (Map.Entry<String, Predicate> entry : checks.entrySet()) {
            Predicate validate = entry.getValue();
            if (!validate.test(value)) {
                return false;
            }
        }
        return true;
    }

}
