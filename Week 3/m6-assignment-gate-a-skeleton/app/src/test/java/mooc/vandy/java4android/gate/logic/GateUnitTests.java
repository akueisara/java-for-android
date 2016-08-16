package mooc.vandy.java4android.gate.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Hashtable;

import io.magnum.autograder.junit.Rubric;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class GateUnitTests {

    // Used to make sure "System.out" and "System.err" are NOT used in your assignments EVER!!
    ByteArrayOutputStream myOut;
    ByteArrayOutputStream myErr;

    /**
     * This method runs before every test method and 'sets up' the testing environment.
     */
    @Before
    public void setup(){
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

    @Rubric(
            value = "testGateConstructor",
            goal = "The goal of this evaluation is to test GateConstructor",
            points = 4.0,
            reference = "This Test fails when: The Could not create Gate object"
    )
    @Test(timeout = 100)
    public void testGateConstructor() {
        Gate testGate = new Gate();
        assertEquals(testGate.getClass().getSimpleName().toString(), "Gate");
    }

    @Rubric(
            value = "testOpenIn",
            goal = "The goal of this evaluation is to test Open(Gate.IN)",
            points = 4.0,
            reference = "This Test fails when: The Gate could not be set to " +
                    "IN or the open method returns false"
    )
    @Test(timeout = 100)
    public void testOpenIn() {
        Gate testGate = new Gate();
        assertTrue(testGate.open(Gate.IN));
        assertEquals(Gate.IN, testGate.getSwingDirection());
    }

    @Rubric(
            value = "testOpenOut",
            goal = "The goal of this evaluation is to test Open(Gate.OUT)",
            points = 4.0,
            reference = "This Test fails when: The Gate could not be set to " +
                    "OUT or the open method returns false"
    )
    @Test(timeout = 100)
    public void testOpenOut() {
        Gate testGate = new Gate();
        assertTrue(testGate.open(Gate.OUT));
        assertEquals(Gate.OUT, testGate.getSwingDirection());
    }

    @Rubric(
            value = "testOpenClose",
            goal = "The goal of this evaluation is to test open(Gate.CLOSED)",
            points = 4.0,
            reference = "This Test fails when: Gate open does not return " +
                    "false when passed a value of CLOSED or if the swing " +
                    "state is changed by this call"
    )
    @Test(timeout = 100)
    public void testOpenClosed() {
        Gate testGate = new Gate();
        int direction = testGate.getSwingDirection();
        assertFalse(testGate.open(Gate.CLOSED));
        assertEquals(direction, testGate.getSwingDirection());
    }

    @Rubric(
            value = "testCloseGate",
            goal = "The goal of this evaluation is to test CloseGate",
            points = 4.0,
            reference = "This Test fails when: The Gate did not close properly"
    )
    @Test(timeout = 100)
    public void testCloseGate() {
        Gate testGate = new Gate();
        testGate.close();
        assertEquals(Gate.CLOSED, testGate.getSwingDirection());
    }

    @Rubric(
            value = "testSetSwingIn",
            goal = "The goal of this evaluation is to test SetSwingIn",
            points = 3.0,
            reference = "This Test fails when: The Gate could not be set to " +
                    "swing IN"
    )
    @Test(timeout = 100)
    public void testSetSwingIn() {
        Gate testGate = new Gate();
        assertTrue(testGate.setSwing(Gate.IN));
    }

    @Rubric(
            value = "testSetSwingOut",
            goal = "The goal of this evaluation is to test SetSwingOut",
            points = 3.0,
            reference = "This Test fails when: The Gate could not be set to " +
                    "swing OUT"
    )
    @Test(timeout = 100)
    public void testSetSwingOut() {
        Gate testGate = new Gate();
        assertTrue(testGate.setSwing(Gate.OUT));
    }

    @Rubric(
            value = "testInvalidSwingParameter",
            goal = "The goal of this evaluation is to test " +
                    "InvalidSwingParameter",
            points = 4.0,
            reference = "This Test fails when: The Gate was set to invalid " +
                    "number"
    )
    @Test(timeout = 100)
    public void testInvalidSwingParameter() {
        Gate testGate = new Gate();
        assertFalse(testGate.setSwing(43));
    }

    @Rubric(
            value = "testThruIn",
            goal = "The goal of this evaluation is to test ThruIn",
            points = 4.0,
            reference = "This Test fails when: The gate allows thru() with IN"
    )
    @Test(timeout = 100)
    public void testThruIn() {
        int cur = 10;
        Gate testGate = new Gate();
        testGate.open(Gate.OUT);
        cur += testGate.thru(3);
        assertEquals(7, cur);
    }

    @Rubric(
            value = "testThruOut",
            goal = "The goal of this evaluation is to test ThruOut",
            points = 4.0,
            reference = "This Test fails when: The gate allows thru() with OUT"
    )
    @Test(timeout = 100)
    public void testThruOut() {
        int cur = 10;
        Gate testGate = new Gate();
        testGate.open(Gate.IN);
        cur += testGate.thru(8);
        assertEquals(18, cur);
    }

    @Rubric(
            value = "testThruWhenClosed",
            goal = "The goal of this evaluation is to test ThruWhenClosed",
            points = 4.0,
            reference = "This Test fails when: The gate Allowed thru() when " +
                    "gate was closed"
    )
    @Test(timeout = 100)
    public void testThruWhenClosed() {
        Gate testGate = new Gate();
        testGate.close();
        int cur = 10;
        cur += testGate.thru(4);
        assertEquals(10, cur);
    }

    @Rubric(
            value = "testGateToStringWhenOpenedIn",
            goal = "The goal of this evaluation is to test GateToString",
            points = 3.0,
            reference = "This Test fails when: The method toString() is not " +
                    "created properly"
    )
    @Test(timeout = 100)
    public void testGateToStringWhenOpenedIn() {
        String expected = "This gate is open and swings to enter the pen only";
        Gate testGate = new Gate();
        testGate.open(Gate.IN);
        assertEquals(expected, testGate.toString());
    }

    @Rubric(
            value = "testGateToStringWhenOpenedOut",
            goal = "The goal of this evaluation is to test GateToString",
            points = 3.0,
            reference = "This Test fails when: The method toString() is not " +
                    "created properly"
    )
    @Test(timeout = 100)
    public void testGateToStringWhenOpenedOut() {
        String expected = "This gate is open and swings to exit the pen only";
        Gate testGate = new Gate();
        testGate.open(Gate.OUT);
        assertEquals(expected, testGate.toString());
    }

    @Rubric(
            value = "testGateToStringWhenClosed",
            goal = "The goal of this evaluation is to test GateToString",
            points = 3.0,
            reference = "This Test fails when: The method toString() is not " +
                    "created properly"
    )
    @Test(timeout = 100)
    public void testGateToStringWhenClosed() {
        String expected = "This gate is closed";
        Gate testGate = new Gate();
        testGate.close();
        assertEquals(expected, testGate.toString());
    }

    @Rubric(
            value = "testGateToString",
            goal = "The goal of this evaluation is to test GateToString",
            points = 3.0,
            reference = "This Test fails when: The method toString() is not " +
                    "created properly"
    )
    @Test(timeout = 100)
    public void testGateToStringWhenInvalid() {
        String expected = "This gate has an invalid swing direction";
        Gate testGate = new Gate();
        try {
            // Set the private member to an invalid swing value using
            // reflection.
            testGate.getClass().getDeclaredField("mSwing");
            Field field = testGate.getClass().getDeclaredField("mSwing");
            field.setAccessible(true);
            field.setInt(testGate, 43);
            assertEquals(expected, testGate.toString());
        } catch (NoSuchFieldException | IllegalAccessException e ) {
            // Don't bother reporting this as an error because
            // we are not really testing if the mSwing field is
            // named correctly.
        }
    }
}
