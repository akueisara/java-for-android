package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

import static mooc.vandy.java4android.gate.logic.ClassToTest.*;

/**
 * This is where the logic of this App is centralized for this
 * assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * Name of the class for the logger.
     */
    public static final String TAG =
        Logic.class.getName();

    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * Select a predictable seed for the RandomNumber generator.
     */
    public final static int sRANDOM_SEED = 1234;

    /**
     * The maximum number of Gate objects.
     */
    private final static int sMAX_GATES = 4;

    /**
     * Constructor initializes the field.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This method will run after the on screen button is pressed.
     */
    @Override
    public void process() {
        // Determine which class to test.
        final ClassToTest classToTest =
            mOut.getClassToTest();

        // Generate a random number.
        final Random randomNumber =
            new Random(sRANDOM_SEED);

        // This code here will only execute one 'case'(or section of
        // code) based on the chosen drop down selection: 'Corral' or
        // 'Herd'.
        switch (classToTest) {
        case Corral:
            // We're going to test the FillTheCorral class on this
            // run.
            final FillTheCorral mFillTheCorral =
                new FillTheCorral(mOut);

            final Gate[] corral =
                new Gate[sMAX_GATES];

            for (int i = 0; i < corral.length; i++)
                corral[i] = new Gate();

            do {
                // Randomly set the direction of each gate's swing in
                // the corral array.
                mFillTheCorral.setCorralGates(corral,
                                              randomNumber);
            } while (!mFillTheCorral.anyCorralAvailable(corral));

            // Corral all the snails.
            mFillTheCorral.corralSnails(corral, randomNumber);
            break;

        case Herd:
            // We're going to test the HerdManager class on this run.

            // Create two new Gate objects.
            final Gate westGate = new Gate();
            final Gate eastGate = new Gate();

            mOut.println("West Gate: " + westGate);
            mOut.println("East Gate: " + eastGate);

            // Create a HerdManager that stores the output reference
            // and the two Gate objects.
            final HerdManager mHerdManager = 
                new HerdManager(mOut,
                                westGate,
                                eastGate);

            // Simulate the herd given a random number seed.
            mHerdManager.simulateHerd(randomNumber);
            break;
        default:
            // This should never occur!
            throw new UnsupportedOperationException();
        }
    }
}
