package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super.addCheck("isNumber", value -> value instanceof Integer);
    }

    public NumberSchema required() {
        super.addCheck("required", value -> value != null);
        return this;
    }

    public NumberSchema positive() {
        super.addCheck("positive", value -> ((int) value) > 0);
        return this;
    }

    public NumberSchema range(int from, int to) {
        super.addCheck("range", value -> ((Integer) value >= from && (Integer) value <= to));
        return this;
    }
}
