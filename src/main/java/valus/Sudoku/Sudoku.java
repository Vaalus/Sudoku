package valus.Sudoku;

public class Sudoku {
    
    // [row][column] sequential board
    int[][] board = new int[9][9];

    // linear sequential board [0-80]
    int[] sequential_board = new int[81];

    int[][] block_board = new int[9][9];  //* [block][entry 0-8] board

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



        // saved both boards
        
        isSaved = true;

        System.out.println("\n");
        System.out.println("------------------------------------------------");
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
        System.out.println("\n     A B C | D E F | G H I");

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


}