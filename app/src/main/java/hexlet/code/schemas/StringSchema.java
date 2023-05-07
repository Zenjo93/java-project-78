package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;

public final class StringSchema extends BaseSchema {
    private boolean isRequired;
//    private int minLength;
    private final List<String> containedStrings = new ArrayList<>();

    public StringSchema required() {
        super.addCheck("required", value -> (value != null && value.toString().length() != 0));
        return this;
    }

    public StringSchema minLength(int minLength) {
        super.addCheck("minLength", value -> value.toString().length() > minLength);
//        this.minLength = length;
        return this;
    }

    public StringSchema contains(String string) {
        this.containedStrings.add(string);
        super.addCheck("contains", value -> checkContains(value));
        return this;
    }

    private boolean checkContains(Object value) {
        String stringValue = (String) value;

        if (containedStrings.size() != 0) {
            for (String containedString: containedStrings) {
                if (!stringValue.contains(containedString)) {
                    return false;
                }
            }
        }
        return true;

    }



//    @Override
//    public boolean isValid(Object value) {
//        String stringValue = (String) value;
//
//        if (value == null || stringValue.length() == 0) {
//            return !isRequired;
//        }
//        if (minLength > 0 && stringValue.length() < minLength) {
//            return false;
//        }
//        if (containedStrings.size() != 0) {
//            for (String containedString: containedStrings) {
//                if (!stringValue.contains(containedString)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

}
