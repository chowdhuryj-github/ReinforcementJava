import java.util.Arrays;


/**
 * the main class
 */
public class Main {


    public static void main(String[] args) {

        // printing out the q grid
        QGrid.printQGrid();

        // a initial state
        int[][] agentState = {{1, 2}};

        // a initial action
        String action = "left";

        int[][] newState = Movement.move(agentState, action);
        System.out.println("New State: " + Arrays.deepToString(newState));

        // testing out the visualization method
        Movement.statePrint(Movement.GRID_STATE);

        

    }
}
    