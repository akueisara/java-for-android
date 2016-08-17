package mooc.vandy.java4android.calculator.logic;

import android.util.Log;

import org.apache.commons.lang3.text.WordUtils;

import java.io.File;

import io.magnum.autograder.junit.ConsoleFormatter;
import io.magnum.autograder.junit.JUnitEvaluation;
import io.magnum.autograder.junit.JUnitEvaluator;

/**
 * Run the AndroidHandinUtil.
 */
public class AndroidHandinUtil {
    public static void generateHandinPackage(String prjid, File prjroot, Class<?> tests) throws Exception {

        JUnitEvaluator eval = new JUnitEvaluator(tests);
        JUnitEvaluation estimatedScore = eval.evaluate(new ConsoleFormatter());

        Log.d("MyMsg", WordUtils.wrap(
                                      "Your assignment HAS NOT BEEN SUBMITTED. This script only estimates your grade and builds the "
                                      + "subission package that you need to turn your assignment in. Please read the instructions at the "
                                      + "end for the steps to submit the package produced by this application to Coursera.\n\n"

                                      , 80));
        Log.d("MyMsg", WordUtils.wrap("Your estimated score is: " + estimatedScore.getScore() + "/" + estimatedScore.getTotalPoints(), 80));
        Log.d("MyMsg", WordUtils.wrap("(This is not your actual grade for the assignment, just an estimate. Why? The actual grade"
                                      + " is only calculated after submission to Coursera.\n\n", 80));
        System.out.println(estimatedScore.getFeedback());
    }
}
