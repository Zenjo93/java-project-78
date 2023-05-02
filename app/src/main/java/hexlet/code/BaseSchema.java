package hexlet.code;

public abstract class BaseSchema {
    boolean isRequired;

    public boolean isValid(Object value) {
        if (value == null) {
            return !isRequired;
        }
        else return isRequired;

    }

}
