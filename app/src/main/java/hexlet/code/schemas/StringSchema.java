package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;

public final class StringSchema extends BaseSchema {
    private boolean isRequired;
    private int minLength;
    private final List<String> containedStrings = new ArrayList<>();

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String string) {
        this.containedStrings.add(string);
        return this;
    }

    @Override
    public boolean isValid(Object value) {
        String stringValue = (String) value;

        if (value == null || stringValue.length() == 0) {
            return !isRequired;
        }
        if (minLength > 0 && stringValue.length() < minLength) {
            return false;
        }
        if (containedStrings.size() != 0) {
            for (String containedString: containedStrings) {
                if (!stringValue.contains(containedString)) {
                    return false;
                }
            }
        }
        return true;
    }

}
