package mooc.vandy.java4android.calculator.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Arrays;

import mooc.vandy.java4android.calculator.R;
import mooc.vandy.java4android.calculator.logic.Logic;
import mooc.vandy.java4android.calculator.logic.LogicInterface;

/**
 * This Activity prompts the user for two integer values and
 * and operation to perform on these values.
 */
public class MainActivity extends
             Activity implements ActivityInterface {
    /**
     * The Spinner (drop down selector) that you choose which
     * operation to use from.
     */
    private Spinner mMathSpinner;

    /**
     * Button the user presses to perform the computation.
     */
    private Button mCalculate;

    /**
     * EditText that holds the first value entered by the user.
     */
    private EditText mValueOne;

    /**
     * EditText that holds the second value entered by the user.
     */
    private EditText mValueTwo;

    /**
     * EditText that stores the results of the computation.
     */
    private EditText mResult;

    /**
     * Reference to the Logic object.
     */
    private LogicInterface mLogic;

    /**
     * This 'Adapts' the Array of CharSequence to make it useable by
     * the mMathSpinner.
     */
    private ArrayAdapter<CharSequence> mAdapter;

    /**
     * Hook method called back by the Activity Manager Service when
     * the Activity is created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call up to the super class.
        super.onCreate(savedInstanceState);

        // Initialize the UI.
        initializeUI();

        // Initialize the Logic instance.
        mLogic = (LogicInterface) new Logic(this);
    }

    /**
     * Initialize the UI.
     */
    private void initializeUI(){
        // Set the layout.
        setContentView(R.layout.activity_main);

        // Store a reference to the mCalculate button.
        mCalculate = (Button) findViewById(R.id.calculate_button);

        // Store references to the two values entered by the user.
        mValueOne = (EditText) findViewById(R.id.valueOneEditText);
        mValueTwo = (EditText) findViewById(R.id.valueTwoEditText);

        // Store a reference to the MathSpinner.
        mMathSpinner = (Spinner) findViewById(R.id.mathSpinner);

        // Store a reference to the EditText containing the result.
        mResult = (EditText) findViewById(R.id.results);

        // Initialize the adapter.
        mAdapter =
            ArrayAdapter.createFromResource(this,
                                            R.array.math_options,
                                            android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Associate the ArrayAdapter with the Spinner.
        mMathSpinner.setAdapter(mAdapter);

        // Set the default selection of the mMathSpinner to be "add".
        mMathSpinner.setSelection(mAdapter.getPosition("add"));
    }

    public void getAlert(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Warning");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void checkArguments(int argOne, int argTwo, int operation) {
        if(argOne == Integer.MIN_VALUE && argTwo == Integer.MIN_VALUE) {
            getAlert("Please enter Value One and Value Two.");
        }
        else if(argOne == Integer.MIN_VALUE) {
            getAlert("Please enter Value One.");
        }
        else if(argTwo == Integer.MIN_VALUE) {
            getAlert("Please enter Value Two.");
        }
        else if(operation == 4 && argTwo == 0) {
            getAlert("Value Two must not be 0");
        }
    }

    /**
     * Called back by the Android UI framework when the user presses
     * the "Calculate" button.
     */
    public void buttonPressed(View view){
        // Reset the result to an empty string
        print("");

        // Operation selected by the user.
        final int operation = getOperationNumber();

        // First argument specified by the user.
        final int argOne = getValueOne();
//        Log.i("buttonPressed", "argOne: " + argOne);

        // Second argument specified by the user.
        int argTwo = getValueTwo();

        // Check if both arguments are entered
        checkArguments(argOne, argTwo, operation);

        // Perform the operation on the two arguments.
        if(argOne!= Integer.MIN_VALUE && argTwo!= Integer.MIN_VALUE)
                if(operation == 4) {
                    if (argTwo != 0)
                        mLogic.process(argOne, argTwo, operation);
                }
                else
                        mLogic.process(argOne, argTwo, operation);
    }

    /**
     * Get the value of the first user input operand.
     */ 
    @Override
    public int getValueOne() {
        if("".equals(mValueOne.getText().toString().trim()))
            return Integer.MIN_VALUE;
        return Integer.valueOf(mValueOne.getText().toString());
    }

    /**
     * Get the value of the second user input operand.
     */ 
    @Override
    public int getValueTwo() {
        if("".equals(mValueTwo.getText().toString().trim()))
            return Integer.MIN_VALUE;
        return Integer.valueOf(mValueTwo.getText().toString());
    }

    /**
     * Get the value of the user input operation.
     */
    @Override
    public int getOperationNumber() {
        return Arrays.asList(getResources()
                     .getStringArray(R.array.math_options))
                     // Added 1 to start the selected operation from 1 rather than 0.
                     .indexOf(mMathSpinner.getSelectedItem().toString()) + 1;
    }

    /**
     * Print the result to the user's display.
     */
    @Override
    public void print(String resultString) {
        mResult.setText(resultString);
    }
}
