package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super.addCheck("required", value -> (value != null && value.toString().length() != 0));
    }

    public StringSchema required() {
        super.required = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        super.addCheck("minLength", value -> value.toString().length() > minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        addCheck("contains", value -> ((String) value).contains(substring));
        return this;
    }
}
