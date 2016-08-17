package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide {
    private int mArgumentOne = 0;
    private int mArgumentTwo = 0;

    public Divide(int argumentOne, int argumentTwo) {
        mArgumentOne = argumentOne;
        mArgumentTwo = argumentTwo;
    }

    public String toString() {
        return String.valueOf(mArgumentOne / mArgumentTwo) + " R:" + String.valueOf(mArgumentOne % mArgumentTwo);
    }
}
