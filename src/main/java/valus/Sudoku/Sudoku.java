package valus.Sudoku;

public class Sudoku {

    // sequential board [row][column]
    int[][] board = new int[9][9];

    // linear sequential board [0-80]
    int[] sequential_board = new int[81];

    // block-based board [block0-8][entry 0-8]
    int[][] block = new int[9][9];

    boolean isSaved = false;

    Sudoku(){}

    Sudoku(String input) {

        fillBoard(input);

    }

    boolean fillBoard(String input){

        if(input.length() != 81){
        System.out.println("Wrong number of entries!\nFailed.");
        return false;
        }

        // save copy of sequential board

            for(int i = 0; i < 81; i++){
                sequential_board[i] = Character.getNumericValue(input.charAt(i));
            }

        // turn it into a row-based board

        int counter = 0;

        for(int i = 0; i < 9; i++){ // row

            for(int j = 0; j < 9; j++){ // column
                board[i][j] = Character.getNumericValue(input.charAt(counter));
                counter++;
            }

        }

        // turn it into a block-based board
        blockify();

        // saved all boards

        isSaved = true;

        System.out.println("\n");
        System.out.println("-----------------------------------------------");
        System.out.println("Your Sudoku table has been saved successfully!");
        System.out.println("--------------------------------------------");
        System.out.print("\n");

        return true;
    }

    void print(){

        // No Sudoku Table
        if(isSaved!=true){
            System.out.println("\n---------------------------");
            System.out.println("No Sudoku table to print!");
            System.out.println("-----------------------");
            return;
        }

        // Compatible Sudoku Table
        System.out.println("\n     1 2 3 | 4 5 6 | 7 8 9");

        for(int i = 0; i < 9; i++){

            // block separator
            if(i%3==0){System.out.println("    ------------------------");}

            System.out.printf("%d - ",i+1);


            for(int j = 0; j < 9; j++){

               // first character
                if(j==0) System.out.print("[");

               // block separators
                if(j==3 || j==6) System.out.print("| ");

                System.out.printf("%d ",board[i][j]);

               //last character
                if(j==8) System.out.print("]");

            }
            System.out.println();
        }


        // Finished Printing Sudoku Table
        System.out.println("    ------------------------\n\n");


    }

    void blockify(){

        // translates the linear board into Sudoku blocks
        // block[0-8][entry0-8]
        int start = 1; int counter = 1;

        for(int i = 0; i < 9; i++){ // extract the 9 blocks. after each subsequent 3 blocks, jump vertically (+21)
            block[i] = extractBlock(start);
            if(counter%3==0) start+=21;
            else start+=3;
            counter++;
        }

    }

    int[] extractBlock(int start){

        // start = index of the first element in a block, min == 1, max == 61

        // handle invalid index
        if(start>61 || start<1) {
            System.out.println("Invalid index."); return null;
        }

        int[] temp_block = new int[9];

        for(int i = 0; i < 9; i++){ // extract each element in block

            temp_block[i] = sequential_board[start-1]; // -1 to address the array indices
            if(start%3==0 && start!=0) start+=7;         // reached last element in row of block, jump to the next row
            else start++;                                // go to subsequent element

        }

        return temp_block;
    }

    int[] extractBlockVerbose(int start){

        // prints blocks
        // start = index of the first element in a block, min == 1, max == 61

        // handle invalid index
        if(start>61 || start<1) {
            System.out.println("Invalid index."); return null;
        }

        int[] temp_block = new int[9];

        for(int i = 0; i < 9; i++){ // extract each element in block

            temp_block[i] = sequential_board[start-1]; // -1 to address the array indices

            // System.out.print(start-1+" "); // print block indices
            System.out.print(sequential_board[start-1]+" "); // print block entries

            if(start%3==0 && start!=0){ start+=7; System.out.println(); } // reached last element in row of block, jump to the next row
            else { start++; } // go to subsequent element

        }

        System.out.println(); // space after each block

        return temp_block;
    }

    void verifySolution(){
        if(isSaved) SudokuSolver.verifySolution(this);
        else System.out.println("Fill up the board first!");
    }

}