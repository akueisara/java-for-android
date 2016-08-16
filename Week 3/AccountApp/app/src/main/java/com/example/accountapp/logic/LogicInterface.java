package com.example.accountapp.logic;

/**
 * This Interface exists to help simplify the interactions between the
 * UI (User Interface: [MainActivity.java] in this application) and
 * the Logic class [Logic.java].
 *
 * This Interface defines the 'void process()' method that
 * [Logic.java] will promise to implement.  This design allows
 * [MainActivity.java] to store an instance of [Logic.java] inside a
 * 'LogicInterface' variable (mLogic inside [MainActivity.java])
 */
public interface LogicInterface {
    /**
     * Perform the computation.
     */
    public void process(); 
}
