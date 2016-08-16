package mooc.vandy.java4android.gate.logic;

/**
 * This Interface exists to help simplify the interactions between the
 * UI (User Interface: [MainActivity.java] in this application) and
 * the Logic class [Logic.java].
 *
 * This Interface defines the 'void process()' method that
 * [Logic.java] will promise to implement. This allows
 * [MainActivity.java] to store an instance of [Logic.java] inside a
 * 'LogicInterface' variable (mLogic inside [MainActivity.java])
 */
public interface LogicInterface {
    /**
     * This method gets called (indirectly via [MainActivity.java])
     * when the button labeled 'Process...' is pressed.
     */
    void process();
}
