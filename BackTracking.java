package Java;
import java.util.*;
public class BackTracking {
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
    }
    
}
