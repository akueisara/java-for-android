package mooc.vandy.java4android.gate.logic.tools;


import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * IGNORE THIS CLASS.
 * <p>
 * This class exists to assist in the auto-grading framework that we have developed.
 * Knowledge of this class and how it works will not be required in this course at all.
 */
public class TestingOutputInterface  implements OutputInterface {

    String output = "";

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
