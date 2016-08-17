package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Add operation.
 */
public class Add {
    private int mArgumentOne = 0;
    private int mArgumentTwo = 0;

    public Add(int argumentOne, int argumentTwo) {
        mArgumentOne = argumentOne;
        mArgumentTwo = argumentTwo;
    }

    public String toString() {
        return String.valueOf(mArgumentOne + mArgumentTwo);
    }
}
