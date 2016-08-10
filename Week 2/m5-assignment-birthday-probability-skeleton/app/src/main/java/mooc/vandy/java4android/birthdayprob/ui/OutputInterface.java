package mooc.vandy.java4android.birthdayprob.ui;

/**
 * Define the methods that the User Interface [MainActivity] will
 * implement. Ignore this interface for now - they will be covered
 * later in this course.
 */
public interface OutputInterface {
    /**
     * Get Size value from displayed UI.
     */
    int getSize();

    /**
     * Get Count value from displayed UI.
     */
    int getCount();

    /**
     * This prints to the output a string
     * @param text
     */
    void print(String text);

    /**
     * This prints to the output a char
     * @param _char
     */
    void print(char _char);

    /**
     * This prints to the screen a string then a new line
     * @param text
     */
    void println(String text);

    /**
     * This prints to the screen a char then a new line
     * @param _char
     */
    void println(char _char);

    /**
     * Reset the on-screen output (EditText box)
     */
    void resetText();

    /**
     * Make Log statements from Logic
     */
    void log(String logtext);

    /**
     * Make a Toast from Logic
     */
    void makeAlertToast(String alertText);
}
