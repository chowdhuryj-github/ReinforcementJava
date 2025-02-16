
/*
 * class for movement of agent
 */
public class Movement {

    // the size of the grid
    public static final int GRID_SIZE = 3;

    // the state of the grid 
    public static String[][] GRID_STATE = {
        {"*", " ", "*", " ", "*"},
        {"*", " ", "*", " ", "*"},
        {"*", " ", "*", " ", "*"}
    };


    /**
     * method for movement of the agent
     * @param stateActionPair a 1x2 array
     * @return a updated 1x2 array
     */
    public static int[][] move(int[][] state, String action) {

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

        return new int[][]{{x, y}};


    }

    /**
     * method for visualizing state of agent
     */
    public static void statePrint(String[][] gridState) {

        for (String[] gridState1 : gridState) {
            for (String gridState11 : gridState1) {
                System.out.print(gridState11 + " ");
            }
            System.out.println();
        }
    }
    
    
}
