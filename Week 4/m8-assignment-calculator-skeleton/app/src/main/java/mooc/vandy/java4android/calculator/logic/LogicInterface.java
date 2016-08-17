package mooc.vandy.java4android.calculator.logic;

/**
 * Defines the interface for processing user calculations.
 */
public interface LogicInterface {
    /**
     * Perform the @a operation on @a argumentOne and @a argumentTwo.
     */
    public void process(int argumentOne,
                        int argumentTwo,
                        int operation);
}
