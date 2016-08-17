package mooc.vandy.java4android.calculator.logic;

import android.util.Log;

import org.junit.Test;

import java.io.File;

/**
 * Run the AutoGrader.
 */
public class AutoGrader {

    @Test
    public void mainTest(){
        try {
            AndroidHandinUtil.generateHandinPackage("Asgn2",
                                                    new File("./"),
                                                    AllUnitTests.class);
        } catch(Exception e) {
            Log.d("AutoGrader :",
                  e.getMessage());
        }
    }
}
