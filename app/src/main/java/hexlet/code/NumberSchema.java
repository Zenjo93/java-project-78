package hexlet.code;

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


    public boolean isValid(Integer value) {
        if (value == null) {
            return !isRequired;
        }
        if (positive && value <= 0) {
            return false;
        }
        if (setRange && (value < range[0] || value > range[1])) {
            return false;
        }
        return true;
    }

}
