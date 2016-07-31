package mooc.vandy.java4android.shapes.logic.tools;

import mooc.vandy.java4android.shapes.logic.Shapes;
import mooc.vandy.java4android.shapes.ui.OutputInterface;

/**
 * IGNORE THIS CLASS.
 * <p>
 * This class exists to assist in the auto-grading framework that we have developed.
 * Knowledge of this class and how it works will not be required in this course at all.
 */
public class TestingOutputInterface  implements OutputInterface{

    String output = "";

    Shapes mShape;
    double mLength;
    double mWidth;
    double mHeight;
    double mRadius;

    public TestingOutputInterface() {
        this.mShape = Shapes.Rectangle;
        this.mLength = 3.0d;
        this.mWidth = 4.0d;
        this.mHeight = 5.0d;
        this.mRadius = 1.0d;
    }

    public TestingOutputInterface(Shapes mShape, double mLength, double mWidth, double mHeight, double mRadius) {
        this.mShape = mShape;
        this.mLength = mLength;
        this.mWidth = mWidth;
        this.mHeight = mHeight;
        this.mRadius = mRadius;
    }

    @Override
    public Shapes getShape() {
        return mShape;
    }

    @Override
    public double getLength() {
        return mLength;
    }

    @Override
    public double getWidth() {
        return mWidth;
    }

    @Override
    public double getHeight() {
        return mHeight;
    }

    @Override
    public double getRadius() {
        return mRadius;
    }

    @Override
    public void print(String text) {
        output += text;
    }

    @Override
    public void print(char _char) {
		print("" + _char);
    }

    @Override
    public void println(String text) {
        output += text + '\n';
    }

    @Override
    public void println(char _char) {
		println("" + _char);
    }

    @Override
    public void resetText() {
        output = "";
    }

    @Override
    public void log(String logtext) {
        // no op for now.
    }
}
