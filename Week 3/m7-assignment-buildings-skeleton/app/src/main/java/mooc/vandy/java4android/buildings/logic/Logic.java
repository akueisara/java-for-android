package mooc.vandy.java4android.buildings.logic;

import android.util.Log;

import mooc.vandy.java4android.buildings.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this
 * assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic 
       implements LogicInterface {
    /**
     * Used for logging.
     */
    public static final String TAG =
        Logic.class.getName();

    /**
     * Reference to the output object.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * Perform the computation to print the houses and offices and the
     * total neighborhood area.
     */
    @Override
    public void process() {
        // Get the list of all the buildings.
        final BuildingList list =
            new BuildingList();

        // Get the list of houses.
        final House[] house =
            list.getHouses();

        // Get the list of offices.
        final Office[] office =
            list.getOffices();

        Neighborhood.print(house, "Houses", mOut);
        mOut.println("");
        Neighborhood.print(office, "Offices", mOut);

        mOut.println("");
        mOut.println("Total neighborhood area: " +
                     (Neighborhood.calcArea(house) +
                      Neighborhood.calcArea(office)));
    }
}
