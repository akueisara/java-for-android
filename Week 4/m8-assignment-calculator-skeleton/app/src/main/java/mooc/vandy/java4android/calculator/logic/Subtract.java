package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Subtract operation.
 */
public class Subtract {
    private int mArgumentOne = 0;
    private int mArgumentTwo = 0;

    public Subtract(int argumentOne, int argumentTwo) {
        mArgumentOne = argumentOne;
        mArgumentTwo = argumentTwo;
    }

    public String toString() {
        return String.valueOf(mArgumentOne - mArgumentTwo);
    }
}
