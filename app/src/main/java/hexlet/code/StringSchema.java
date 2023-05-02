package hexlet.code;

import java.util.ArrayList;
import java.util.List;

public class StringSchema {
    private boolean isRequired; // null или пустая строка
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

    public boolean isValid(String value) {
        if (value == null || value.length() == 0) {
            return !isRequired;
        }
        if (minLength > 0 && value.length() < minLength) {
            return false;
        }
        if (containedStrings.size() != 0) {
            for (String containedString: containedStrings) {
                if (!value.contains(containedString)) {
                    return false;
                }
            }
        }
        return true;
    }

}
