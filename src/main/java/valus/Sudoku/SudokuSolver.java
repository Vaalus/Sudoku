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


    // passed through tests

        System.out.println("-------------------------------------------------");
        System.out.println("\\^-^/ Congrats!! Your entries are correct. \\^-^/");
        System.out.println("--------------------------------------------\n");
        return true;
    }



        static boolean verifySolutionSilently(Sudoku sudoku){

        // Doesn't print the result

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
                        return false; 
                    }


                } // checked all columns

                // check other rows
                for(int j = 0; j <9; j++){
                    
                    if(row==j) continue; // skip original entry

                    int testEntry=board[j][column];

                    if(testEntry==entry){ // duplicate element
                        return false; 
                    }

                } // checked all rows

            }

        }

    // No duplicate elements

        return true; // passed through tests.
    }


}
