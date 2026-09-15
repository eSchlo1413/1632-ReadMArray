package edu.umn.d.cs1632;

public class IntValue extends Value {
    private int newVal;
    public IntValue(String value) {
        newVal = Integer.parseInt(value);
    }

    @Override
    public String toString() {

        return String.valueOf(newVal  + "(I)");
    }
}

