import java.util.Arrays;


/**
 * the main class
 */
public class Main {


    public static void main(String[] args) {

        // printing out the q grid
        printQGrid();

        // a initial state
        int[][] agentState = {{1, 2}};

        // a initial action
        String action = "left";

        int[][] newState = Movement.move(agentState, action);
        System.out.println("New State: " + Arrays.deepToString(newState));

        // testing out the visualization method
        Movement.statePrint(Movement.GRID_STATE);

        

    }

    /**
     * method for initializing a q table with just 0's
     * @return a three dimensional array
     */
    public static int[][][] createQGrid() {

        // 3 means 3 sets
        // 3 means 3 rows
        // 4 means 4 columns
        return new int[3][3][4];

    }

    /**
     * method for printing out the q grid
     * @return a string
     */
    public static void printQGrid() {

        //retrieving the q-table and converting into a string
        int[][][] qTable = createQGrid();


        /// for looping through the array to print it layer by layer
        for(int i = 0;  i< qTable.length; i++) {
            for(int j = 0; j < qTable[i].length; j++) {
                for(int k = 0; k < qTable[i][j].length; k++) {
                    System.out.print(qTable[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
    