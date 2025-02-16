
/*
 * class for movement of agent
 */
public class Movement {

    // the size of the grid
    public static final int GRID_SIZE = 3;

    // the state of the grid 
    public static String[][] GRID_STATE = {
        {".", " ", "*", " ", "*"},
        {"*", " ", "*", " ", "*"},
        {"*", " ", "*", " ", "*"}
    };

    // the dot character
    public static String dot = ".";


    /**
     * method for movement of the agent
     * @param stateActionPair a 1x2 array
     * @return a updated 1x2 array
     */
    public static int[][] move(int[][] state, String action) {

        // indicate the direction of movement
        System.out.println("Moving to the " + action + "!");

        // accessing the first and second element
        int x = state[0][0];
        int y = state[0][1];

        // update the state
        if(action.equals("up") && x > 0) {
            x = x - 1;
        }
        if(action.equals("down") && x < GRID_SIZE -1) {
            x = x + 1;
        }
        if(action.equals("right") && y < GRID_SIZE - 1) {
            y = y + 1;
        }
        if(action.equals("left") && y > 0) {
            y = y - 1;
        }

        // returning the new state
        return new int[][]{{x, y}};


    }

    /**
     * method for visualizing state of agent
     */
    public static void statePrint(String[][] gridState) {

        // for looping to print the grid
        for (int i = 0; i < gridState.length; i++) {
            for (int j = 0; j < gridState[i].length; j++) {
                System.out.print(gridState[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * method for updating the visualization state of agent
     */
    public static void updatePrint(String[][] gridState, int[][] state) {

        // printing out the original state
        System.out.println("Previous State: ");
        statePrint(GRID_STATE);

        // accessing the x and y values
        int x = state[0][0];
        int y = state[0][1];
        System.out.println("The New Updated State: " + "[" + x + "]" + " " + "[" + y + "]");

        // the new grid print statement
        System.out.println("The New Grid");

        

    }
    
    
}
