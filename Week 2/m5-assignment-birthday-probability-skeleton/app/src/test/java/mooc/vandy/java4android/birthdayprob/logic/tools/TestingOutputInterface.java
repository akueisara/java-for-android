package mooc.vandy.java4android.birthdayprob.logic.tools;

import mooc.vandy.java4android.birthdayprob.ui.OutputInterface;

/**
 * IGNORE THIS CLASS.
 * <p>
 * This class exists to assist in the auto-grading framework that we have developed.
 * Knowledge of this class and how it works will not be required in this course at all.
 */
public class TestingOutputInterface  implements OutputInterface{

    String output = "";

    String alertText = null;

    int size = 10;
    int count = 10;

    public TestingOutputInterface(int size, int count) {
        this.size = size;
        this.count = count;
    }

    public TestingOutputInterface() {
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getCount() {
        return 0;
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

    @Override
    public void makeAlertToast(String alertText) {
        this.alertText = alertText;
    }
}
