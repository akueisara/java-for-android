package mooc.vandy.java4android.shapes.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import mooc.vandy.java4android.shapes.R;
import mooc.vandy.java4android.shapes.logic.Logic;
import mooc.vandy.java4android.shapes.logic.LogicInterface;
import mooc.vandy.java4android.shapes.logic.Shapes;


/**
 * MainActivity for this app.
 */
public class MainActivity 
       extends AppCompatActivity 
       implements OutputInterface {
    /**
     * String for LOGGING.
     */
    private final static String LOG_TAG =
        MainActivity.class.getCanonicalName();

    /**
     * Logic Instance.
     */
    private LogicInterface mLogic;

    /**
     * UI Components.
     */
    private EditText mOutput;

    /**
     * Button the user presses to perform the computation.
     */
    private Button mProcessButton;

    // Edit Texts.
    private EditText mLength;
    private EditText mWidth;
    private EditText mHeight;
    private EditText mRadius;

    /**
     * The Spinner (drop down selector) that you choose which shape to
     * use.
     */
    private Spinner mShapesSpinner;

    /**
     * This 'Adapts' the Array of CharSequence to make it useable by
     * the mMathSpinner.
     */
    private ArrayAdapter<CharSequence> mAdapter;

    /**
     * Called when the activity is starting.
     *
     * Similar to 'main' in C/C++/Standalone Java
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // required
        super.onCreate(savedInstanceState);

        // create a new 'Logic' instance.
        mLogic = new Logic(this);

        // setup the UI.
        initializeUI();
    }

    /**
     * This method sets up/gets reference to the UI components.
     */
    private void initializeUI(){
        // Set the layout.
        setContentView(R.layout.activity_main);

        // Store references to various views.
        mOutput = (EditText) findViewById(R.id.outputET);
        mProcessButton = (Button) findViewById(R.id.button);
        mLength = (EditText) findViewById(R.id.lengthET);
        mWidth = (EditText) findViewById(R.id.widthET);
        mHeight = (EditText) findViewById(R.id.heightET);
        mRadius = (EditText) findViewById(R.id.radiusET);

        // Store a reference to the mShapesSpinner.
        mShapesSpinner = (Spinner) findViewById(R.id.spinner);

        // Initialize the adapter.
        mAdapter =
            ArrayAdapter.createFromResource(this,
                                            R.array.shapes,
                                            android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Associate the ArrayAdapter with the Spinner.
        mShapesSpinner.setAdapter(mAdapter);
    }

    /**
     * Called when Button is Pressed.
     *
     * @param buttonPress
     */
    public void buttonPressed(View buttonPress)
    {
        resetText();
        mLogic.process();
    }

    /**
     * Add the @a string to the EditText.
     */
    private void addToEditText(String string){
        mOutput.setText("" + mOutput.getText() + string);
    }

    /**
     * Get the shape specified by the user.
     */
    @Override
    public Shapes getShape() {
        final String spinnerString =
            mShapesSpinner.getSelectedItem().toString();
        // .valueOf(String) is an anutomatically generated method of
        // all Enum(s).  It returns an instance of the enum if one
        // matches the string provided.
        return Shapes.valueOf(spinnerString);
    }

    /**
     * Get the length.
     */
    @Override
    public double getLength() {
        return Double.valueOf(mLength.getText().toString());
    }

    /**
     * Get the width.
     */
    @Override
    public double getWidth() {
        return Double.valueOf(mWidth.getText().toString());
    }

    /**
     * Get the height.
     */
    @Override
    public double getHeight() {
        return Double.valueOf(mHeight.getText().toString());
    }

    /**
     * Get the radius.
     */
    @Override
    public double getRadius() {
        return Double.valueOf(mRadius.getText().toString());
    }

    /**
     * This prints to the output a string
     * @param text
     */
    @Override
    public void print(String text) {
        Log.d(LOG_TAG, "print(String)");
        addToEditText(text);
    }

    /**
     * This prints to the output a char
     * @param _char
     */
    @Override
    public void print(char _char) {
        print("" + _char);
    }

    /**
     * This prints to the screen a string then a new line
     * @param text
     */
    @Override
    public void println(String text) {
        Log.d(LOG_TAG,"println(String)");
        addToEditText(text + "\n");
    }

    /**
     * This prints to the screen a char then a new line
     * @param _char
     */
    @Override
    public void println(char _char) {
        println("" + _char);
    }

    /**
     * Reset the on-screen output (EditText box).
     */
    @Override
    public void resetText() {
        mOutput.setText("");
    }

    /**
     * Log the @a logtext to logcat.
     */
    @Override
    public void log(String logtext) {
        Log.d(LOG_TAG, logtext);
    }
}
