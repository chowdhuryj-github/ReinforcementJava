public class QGrid {

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
        for (int[][] qTable1 : qTable) {
            for (int[] item : qTable1) {
                for (int k = 0; k < item.length; k++) {
                    System.out.print(item[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    
}
