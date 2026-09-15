package edu.umn.d.cs1632;

public class DoubleValue extends Value {
    private double newVal;
    public DoubleValue(String value)
    {
        newVal = Double.parseDouble(value);
    }

    @Override
    public String toString()
    {

        return String.valueOf(newVal + "(D)");
    }

}
