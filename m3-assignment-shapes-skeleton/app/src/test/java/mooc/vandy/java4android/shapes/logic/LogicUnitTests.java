package mooc.vandy.java4android.shapes.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.magnum.autograder.junit.Rubric;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class LogicUnitTests {
 
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
            value="testRectangleArea",
            goal="The goal of this evaluation is to calculate the RectangleArea",
            points=10.0,
            reference="This Test fails when: The Rectangle area is miscalculated"
    )
    @Test
    public void testRectangleArea() {
        assertEquals(1, Logic.rectangleArea(1,1), 0.001);
        assertEquals(12, Logic.rectangleArea(4,3), 0.001);
        assertEquals(12, Logic.rectangleArea(3,4), 0.001);
        assertEquals(0, Logic.rectangleArea(0,10), 0.001);
        assertEquals(25, Logic.rectangleArea(10,2.5), 0.001);
    }

    @Rubric(
            value="testRectanglePerimeter",
            goal="The goal of this evaluation is to calculate the RectanglePerimeter",
            points=10.0,
            reference="This Test fails when: The Rectangle perimeter is miscalculated"
    )
    @Test
    public void testRectanglePerimeter() {
        assertEquals(4,Logic.rectanglePerimeter(1,1), 0.001);
        assertEquals(14,Logic.rectanglePerimeter(4,3), 0.001);
        assertEquals(14,Logic.rectanglePerimeter(3,4), 0.001);
        assertEquals(20,Logic.rectanglePerimeter(0,10), 0.001);
        assertEquals(25,Logic.rectanglePerimeter(10,2.5), 0.001);
    }

    @Rubric(
            value="testCircleArea",
            goal="The goal of this evaluation is to calculate the CircleArea",
            points=10.0,
            reference="This Test fails when: The Circle area is miscalculated"
    )
    @Test
    public void testCircleArea() {
        assertEquals(0,Logic.circleArea(0), 0.001);
        assertEquals(Math.PI,Logic.circleArea(1), 0.001);
        assertEquals(16*Math.PI,Logic.circleArea(4), 0.001);
        assertEquals(100*Math.PI,Logic.circleArea(10), 0.001);
    }

    @Rubric(
            value="testCircleCircumference",
            goal="The goal of this evaluation is to calculate the CircleCircumference",
            points=10.0,
            reference="This Test fails when: The Circle circumference is miscalculated"
    )
    @Test
    public void testCircleCircumference() {
        assertEquals(0,Logic.circleCircumference(0), 0.001);
        assertEquals(2*Math.PI,Logic.circleCircumference(1), 0.001);
        assertEquals(8*Math.PI,Logic.circleCircumference(4), 0.001);
        assertEquals(20*Math.PI,Logic.circleCircumference(10), 0.001);
    }

    @Rubric(
            value="testTriangleArea",
            goal="The goal of this evaluation is to calculate the TriangleArea",
            points=10.0,
            reference="This Test fails when: The Triange area is miscalculated"
    )
    @Test
    public void testRightTriangleArea() {
        assertEquals(0.5, Logic.rightTriangleArea(1, 1), 0.001);
        assertEquals(50, Logic.rightTriangleArea(10, 10), 0.001);
        assertEquals(6, Logic.rightTriangleArea(3, 4), 0.001);
        assertEquals(50, Logic.rightTriangleArea(20, 5), 0.001);
    }

    @Rubric(
            value="testTrianglePerimeter",
            goal="The goal of this evaluation is to calculate the TrianglePerimeter",
            points=10.0,
            reference="This Test fails when: The Triange perimeter is miscalculated"
    )
    @Test
    public void testRightTrianglePerimeter() {
        assertEquals(2 + Math.sqrt(2), Logic.rightTrianglePerimeter(1,1), 0.001);
        assertEquals(20 + Math.sqrt(200), Logic.rightTrianglePerimeter(10,10), 0.001);
        assertEquals(12, Logic.rightTrianglePerimeter(3,4), 0.001);
        assertEquals(30, Logic.rightTrianglePerimeter(5,12), 0.001);
        assertEquals(40, Logic.rightTrianglePerimeter(8,15), 0.001);
    }

    @Rubric(
            value="testBoxVolume",
            goal="The goal of this evaluation is to calculate the BoxVolume",
            points=10.0,
            reference="This Test fails when: The Box volume is miscalculated"
    )
    @Test
    public void testBoxVolume() {
        assertEquals(1, Logic.boxVolume(1,1,1), 0.001);
        assertEquals(1000, Logic.boxVolume(10,10,10), 0.001);
        assertEquals(60, Logic.boxVolume(3,4,5), 0.001);
        assertEquals(600, Logic.boxVolume(5,12,10), 0.001);
        assertEquals(480, Logic.boxVolume(8,15,4), 0.001);
        assertEquals(7.986, Logic.boxVolume(1.1,2.2,3.3), 0.001);
    }

    @Rubric(
            value="testBoxSurfaceArea",
            goal="The goal of this evaluation is to calculate the BoxSurfaceArea",
            points=10.0,
            reference="This Test fails when: The Box surface area is miscalculated"
    )
    @Test
    public void testBoxSurfaceArea() {
        assertEquals(6, Logic.boxSurfaceArea(1,1,1), 0.001);
        assertEquals(22, Logic.boxSurfaceArea(2,1,3), 0.001);
        assertEquals(216, Logic.boxSurfaceArea(6,6,6), 0.001);
    }

    @Rubric(
            value="testSphereVolume",
            goal="The goal of this evaluation is to calculate the SphereVolume",
            points=10.0,
            reference="This Test fails when: The Sphere volume is miscalculated"
    )
    @Test
    public void testSphereVolume() {
        assertEquals((4.0/3.0)*Math.PI, Logic.sphereVolume(1), 0.001);
        assertEquals((4.0/3.0)*Math.PI*8, Logic.sphereVolume(2), 0.001);
        assertEquals((4.0/3.0)*Math.PI*12.167, Logic.sphereVolume(2.3), 0.001);
        assertEquals((4.0/3.0)*Math.PI*125, Logic.sphereVolume(5), 0.001);
        assertEquals((4.0/3.0)*Math.PI*1000, Logic.sphereVolume(10), 0.001);
    }

    @Rubric(
            value="testSphereSurfaceArea",
            goal="The goal of this evaluation is to calculate the SphereSurfaceArea",
            points=10.0,
            reference="This Test fails when: The Sphere surface area is miscalculated"
    )
    @Test
    public void testSphereSurfaceArea() {
        assertEquals(4*Math.PI, Logic.sphereSurfaceArea(1), 0.001);
        assertEquals(0,  Logic.sphereSurfaceArea(0), 0.001);
        assertEquals(36*Math.PI, Logic.sphereSurfaceArea(3), 0.001);
        assertEquals(100*Math.PI, Logic.sphereSurfaceArea(5), 0.001);
        assertEquals(21.16*Math.PI, Logic.sphereSurfaceArea(2.3), 0.001);
    }
}
