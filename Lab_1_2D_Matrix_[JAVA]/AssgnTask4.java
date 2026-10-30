//Assignment Task 04: Rotate Secret
class AssgnTask4{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    //If needed you can create extra helper static methods
    //if extra helper methods are used then you must submit those as well
    public static void rotateSecret( Character[][] board ){

        //Print the message inside of this method
        //TO DO
        int n = board.length;
        String finalOutput = "";

    // Start from the innermost layer and move outward
    for (int layer = n / 2 - 1; layer >= 0; layer--){

        int top = layer;
        int left = layer;
        int bottom = n - 1 - layer;
        int right = n - 1 - layer;

        // Calculate how many times this layer must rotate
        int rotationsNeeded = n / 2 - layer;

        // Rotate this layer clockwise
        for (int r = 0; r < rotationsNeeded; r++) {

            // Save the last character in the clockwise path
            Character temp = board[top][left];

            // Shift the left edge upward
            for (int i = top; i < bottom; i++) {
                board[i][left] = board[i + 1][left];
            }

            // Shift the bottom edge leftward
            for (int j = left; j < right; j++) {
                board[bottom][j] = board[bottom][j + 1];
            }

            // Shift the right edge downward
            for (int i = bottom; i > top; i--) {
                board[i][right] = board[i - 1][right];
            }

            // Shift the top edge rightward
            for (int j = right; j > left + 1; j--) {
                board[top][j] = board[top][j - 1];
            }

            // Place the saved character in the top-left corner
            board[top][left + 1] = temp;
        }
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            finalOutput += board[i][j];
        }
    }
    
    System.out.println(finalOutput);
}

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        System.out.print("===========Test#1===========\n");
        Character[][] board = {
          {'T','A','U','S'},
          {'A','R','I','.'},
          {'D','T','T','N'},
          {'S','C','F','U'}
        };
        System.out.println("Given Board: ");
        Arr.print2D(board);

        System.out.println("\nExpected Output:");
        Character[][] outputBoard = {
            {'D','A','T','A'},
            {'S','T','R','U'},
            {'C','T','I','S'},
            {'F','U','N','.'}
        };
        System.out.print("DATASTRUCTISFUN.\n");
        Arr.print2D(outputBoard);
        
        System.out.print("\nYour Output:\n");
        rotateSecret( board );
        Arr.print2D(board);
        
        if( Arr.compare2D(outputBoard, board) ) System.out.print("Test 1 Success");
        else System.out.println("Test 1 FAILED");
        
        System.out.print("\n===========Test#2===========\n");

        board = new Character[][]{
          {'O','R','I','R','N','P'},
          {'G','S','A','A','L','R'},
          {'L','M','N','O','N','Y'},
          {'A','H','U','O','O','P'},
          {'T','F','C','T','H','S'},
          {'E','D','Y','O','C','K'}
        };
        System.out.println("Given Board: ");
        Arr.print2D(board);

        System.out.println("\nExpected Output:");
        outputBoard = new Character[][]{
            {'A','L','G','O','R','I'},
            {'T','H','M','S','A','R'},
            {'E','F','U','N','A','N'},
            {'D','C','O','O','L','P'},
            {'Y','T','H','O','N','R'},
            {'O','C','K','S','P','Y'}
        };
        System.out.print("ALGORITHMSAREFUNANDCOOLPYTHONROCKSPY\n");
        Arr.print2D(outputBoard);
        
        System.out.print("\nYour Output:\n");
        rotateSecret( board );
        Arr.print2D(board);
        
        if( Arr.compare2D(outputBoard, board) ) System.out.print("Test 2 Success");
        else System.out.println("Test 2 FAILED");
    }
}
