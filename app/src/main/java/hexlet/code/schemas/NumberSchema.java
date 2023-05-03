package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    private boolean isRequired; // null как значение
    private boolean positive;
    private boolean setRange;
    private final int[] range = new int[2];

    public NumberSchema required() {
        this.isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public NumberSchema range(int from, int to) {
        this.setRange = true;
        this.range[0] = from;
        this.range[1] = to;
        return this;
    }

    @Override
    public boolean isValid(Object value) {
        if (value instanceof String) {
            return false;
        }
        if (value == null) {
            return !isRequired;
        }
        if (positive && ((int) value <= 0)) {
            return false;
        }
        if (setRange && ((int) value < range[0] || (int) value > range[1])) {
            return false;
        }
        return true;
    }

}
