package mooc.vandy.java4android.birthdayprob.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.magnum.autograder.junit.Rubric;
import mooc.vandy.java4android.birthdayprob.logic.tools.TestingOutputInterface;

import static org.junit.Assert.*;

import java.util.*;


/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class LogicUnitTests {

    // The variables that are used in each test.
    Logic mLogic;
    TestingOutputInterface output;

    // Delta for boolean arithmetic accuracy.
    private static final double DELTA = 1e-15;
    
    
    // Used to make sure "System.out" and "System.err" are NOT used in your assignments EVER!!
    ByteArrayOutputStream myOut;
    ByteArrayOutputStream myErr;

    /**
     * This method runs before every test method and 'sets up' the testing environment.
     * </p>
     * This entire class is re-created for each test method below. Therefore, 'setup'
     * operations such as these that need to be ran 'before' each test are in this method.
    */
    @Before
    public void setup(){
        output = new TestingOutputInterface();
        mLogic = new Logic(output);
        
        System.err.flush();
        System.out.flush();
        myOut = new ByteArrayOutputStream();
        myErr = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));
    }

    /**
     * This method runs after every test method and 'tears down' the testing environment.
     */
    @After
    public void tearDown(){
        final String standardOutput = myOut.toString();
        final String standardError  = myErr.toString();
        assertEquals("You used 'System.out' in your assignment, This is not allowed.",true, standardOutput.length() == 0);
        assertEquals("You used 'System.err' in your assignment, This is not allowed.",true, standardError.length() == 0);
        System.err.flush();
        System.out.flush();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err)));
    }

	/**
	 * Note (Monte):
	 * If students calculate percent using the formula
	 *		(a / b) * 100
	 * there rounding error will not produce an exact match
	 * with the solution set which expects the formula to be
	 *		(a * 100) / b
	 * To work around this issue, Mike has added a tolerance
	 * threshold.
	 */
    @Rubric(
            value="testCalculateThreshold",
            goal="The goal of this evaluation is to test Calculate with return values within a threshold",
            points=40.0,
            reference="This Test fails when: calculate method failed to meet a 3% threshold."
    )
    @Test
    public void testCalculateThreshold() {

        double threshold = .03;
        assertEquals(2.71, mLogic.calculate(5, 10000), 2.71 * threshold);
        assertEquals(5.34, mLogic.calculate(7, 5000), 5.34 * threshold);
        assertEquals(0.27, mLogic.calculate(2, 10000), .27 * threshold);
        assertEquals(9.47, mLogic.calculate(9, 10000), 9.47 * threshold);
        assertEquals(70.675, mLogic.calculate(30, 20000), 70.675 * threshold);
        assertEquals(25.576, mLogic.calculate(15, 50000), 25.576 * threshold);
        assertEquals(81.434, mLogic.calculate(35, 50000), 81.434 * threshold);
        assertEquals(94.2, mLogic.calculate(45, 50000), 94.2 * threshold);

    }

    @Rubric(
            value="testResultRange",
            goal="The goal of this evaluation is to test ResultRange",
            points=40.0,
            reference="This Test fails when: calculate returns a value outside the range."
    )
    @Test
    public void testResultRange() {
        Random g = new Random();
        for (int i = 0; i < 1000; i++) {
            double result = mLogic.calculate(g.nextInt(400), g.nextInt(100000));
            assertTrue(result >= 0.0 && result <= 100.0);
        }

    }
    
}
