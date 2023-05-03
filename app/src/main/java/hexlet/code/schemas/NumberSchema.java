package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
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
        Integer intValue = (Integer) value;

        if (value == null) {
            return !isRequired;
        }
        if (positive && intValue <= 0) {
            return false;
        }
        if (setRange && (intValue < range[0] || intValue > range[1])) {
            return false;
        }
        return true;
    }

}