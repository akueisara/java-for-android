package com.example.accountapp.ui;

/**
 * Interface that defines the methods that the User Interface
 * [MainActivity] will implement.
 */
public interface OutputInterface {
    /**
     * This prints to the output a string.
     * @param text
     */
    void print(String text);

    /**
     * This prints to the output a char.
     * @param _char
     */
    void print(char _char);

    /**
     * This prints to the screen a string then a new line.
     * @param text
     */
    void println(String text);

    /**
     * This prints to the screen a char then a new line.
     * @param _char
     */
    void println(char _char);

    /**
     * Reset the on-screen output (EditText box).
     */
    void resetText();

    /**
     * Allow Logic to print Log statements without requiring
     * dependency.
     */
    void log(String logtext);
}