package mooc.vandy.java4android.diamonds.ui;

/**
 * Define the methods that the User Interface [MainActivity] will
 * implement. Ignore this interface for now - they will be covered
 * later in this course.
 */
public interface OutputInterface {
    /**
     * Return the string.
     */
    String getString();

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
     * Log @a logtext to the logcat.
     */
    void log(String logtext);
}
