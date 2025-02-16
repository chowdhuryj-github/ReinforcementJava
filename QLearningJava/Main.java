

/**
 * the main class
 */
public class Main {


    public static void main(String[] args) {

        // a initial state
        int[][] agentState = {{0, 0}};

        // a initial action
        String action = "right";

        // the new state variable
        int[][] newState = Movement.move(agentState, action);

        // testing out the updatePrint() method
        Movement.updatePrint(Movement.GRID_STATE, newState);

        

    }
}
    