package edu.umn.d.cs1632;

public class StringValue extends Value{
    private String value;

    public StringValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return String.valueOf(value);
    }
}
