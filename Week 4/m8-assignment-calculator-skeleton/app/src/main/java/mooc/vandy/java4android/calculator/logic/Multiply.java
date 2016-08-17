package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply {
    private int mArgumentOne = 0;
    private int mArgumentTwo = 0;

    public Multiply(int argumentOne, int argumentTwo) {
        mArgumentOne = argumentOne;
        mArgumentTwo = argumentTwo;
    }

    public String toString() {
        return String.valueOf(mArgumentOne * mArgumentTwo);
    }
}
