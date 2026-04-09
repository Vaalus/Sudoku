package valus.Sudoku;

public class SudokuSolver {

    static boolean verifySolution(Sudoku sudoku){

        // 1. Verify that each entry is not repeated either on the same column / row.
        // 2. Verify that each block contains the numbers 1-9 once.

        int[][] board = sudoku.board; // make a copy

    // [1]. check for duplicate elements
        for(int row = 0; row < 9; row++){

            for(int column = 0; column < 9; column++){

                int entry = board[row][column]; // original entry, to be compared against board

                // check other columns
                for(int i = 0; i <9; i++){

                    if(column==i) continue; // skip original entry

                    int testEntry=board[row][i];

                    if(testEntry==entry){ // duplicate element
                        System.out.println("-----------------------------------------------");
                        System.out.print("Incorrect! ");
                        System.out.printf("(%d) is used in both [%d][%d] and [%d][%d]\n"
                        ,entry,row+1,column+1,row+1,i+1);
                        System.out.println("--------------------------------------------");
                        return false; 
                    }


                } // checked all columns

                // check other rows
                for(int j = 0; j <9; j++){
                    
                    if(row==j) continue; // skip original entry

                    int testEntry=board[j][column];

                    if(testEntry==entry){ // duplicate element
                        System.out.println("-----------------------------------------------");
                        System.out.print("Incorrect! ");
                        System.out.printf("(%d) is used in both [%d][%d] and [%d][%d]"
                        ,entry,row+1,column+1,j+1,column+1);
                        System.out.println("--------------------------------------------");
                        return false; 
                    }

                } // checked all rows

            }

        }

    // No duplicate elements

    // [2], check each block

    verifyBlock(sudoku);

    // I realize its kinda redundant, removing this would make it more efficient 
    // I'm doing it though to map all logical parts of this, for when I turn it into a game :)
    // I'll probably change the code a lot then.

    // passed through tests

        System.out.println("-------------------------------------------------");
        System.out.println("\\^-^/ Congrats!! Your entries are correct. \\^-^/");
        System.out.println("--------------------------------------------\n");
        return true;
    }

    static boolean verifyBlock(Sudoku sudoku){

        int[][] blocks = sudoku.block; // make a copy


        for(int block = 0; block < 9; block++){

            boolean[] filledNumbers = new boolean[9]; // numbers 1-9 (decremented afterwards so 0-8)

            for(int entry = 0; entry < 9; entry++){

                int currentNumber = blocks[block][entry] - 1; // -1 to address the index diff of the array.
                
                if(filledNumbers[currentNumber] == true) { // number already assigned in boolean array
                    System.out.printf("The number (%d) is used twice in block [%d].\n",currentNumber+1,block);
                    return false;
                }

                else filledNumbers[currentNumber] = true; // assign number

            }

        } // passed all blocks

        return true; // passed test
    }

}