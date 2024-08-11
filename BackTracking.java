package Java;
import java.util.*;
public class BackTracking {
    public static boolean isSafe(int sudoku[][], int row, int col, int digit){
        //column
        for(int i = 0; i <= 8; i++ ){
            if(sudoku[i][col] == digit){
                return false;
            }
        }

        //row
        for(int j = 0; j<= 8; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }

        //grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;

        for(int i = sr; i<sr+3; i++){
            for(int j = sc; j<sc+3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int sudoku[][], int row, int col){
        if(row == 9){
            return true;
        }

        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row +1;
            nextCol = 0;
        }
        if(sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit = 1; digit <= 9; digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }
    public static void printSudoku(int sudoku[][]){
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int gridWay(int i, int j, int n, int m){
        if(i == n-1 && j == m-1){
            return 1;
        }else if(i == n || j == m){
            return 0;
        }
        int nm1 = gridWay(i+1, j, n, m);
        int mm1 = gridWay(i, j+1, n, m);
        return nm1 + mm1;
    }
    public static void purmentation (String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i = 0; i< str.length(); i++){
            char curr = str.charAt(i);
            String Newstr = str.substring(0, i) + str.substring(i+1);
            purmentation(Newstr, ans+curr);
        }
    }
    public static boolean isSafe(char board[][], int row, int col){
        //vertical upside
        for(int i = row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //left diagonal upside
        for(int i= row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //right diagonal upside
        for(int i = row-1, j= col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueen(char board [][], int row){
        //base
        if(row == board.length){
            count++;
            printBoard(board);
            return;
        }
        //recursion
        for(int j = 0; j<board.length; j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueen(board, row+1);
                board[row][j] = 'x';
            }
        }
    }
    public static void printBoard(char board[][]){
        System.out.println("---------new Board---------");
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void subSetString(String str, String ans, int i ){
        if(i == str.length()){
            System.out.println(ans);
            return;
        }
        //yes
        subSetString(str, ans + str.charAt(i), i+1);
        // No
        subSetString(str, ans, i+1);
    }
    static int count = 0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = "abc";
        String ans = "";
        subSetString(str, ans, 0);
        purmentation(str, ans);
        int n = sc.nextInt();
        char board[][] = new char[n][n];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                board[i][j] = 'x';
            }
        }
        nQueen(board, 0);
        System.out.println("Total possible ways are :- "+count);
        int a = 3, m = 3;
        System.out.println(gridWay(0, 0, a, m));
        int sudoku[][]= {{0,5,0,0,4,0,0,0,0},
                         {2,7,0,0,9,0,0,0,3},
                         {0,0,1,0,0,5,0,9,0},
                         {1,0,8,7,0,0,6,0,0},
                         {7,0,0,0,0,0,0,0,1},
                         {0,0,5,0,0,4,8,0,7},
                         {0,1,0,4,0,0,5,0,0},
                         {8,0,0,0,3,0,0,6,2},
                         {0,0,0,0,6,0,0,8,0}};
        if(sudokuSolver(sudoku, 0, 0)){
            System.out.println("Solution exists");
            printSudoku(sudoku);
        }else{
            System.out.println("Solution does not exist");
        }
    }
    
}
