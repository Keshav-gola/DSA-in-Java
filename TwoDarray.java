package Java;
import java.util.*;
public class TwoDarray {
    public static boolean search(int arr[][], int key){
        int row = 0; int col = arr[0].length-1;

        while (row < arr.length && col >=0){
            if(arr[row][col] == key){
                System.out.println("found key at = ("+row+","+col+")");
                return true;
            }

            else if(key < arr[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("key not found");
        return false;
    }
    public static int diagonal (int arr[][]){
        int sum = 0; 

        //Brut_Force Method
        // for(int i = 0; i<=arr.length-1; i++){
        //     for(int j = 0; j<arr[0].length; j++){
        //         if(i == j) {
        //             sum += arr[i][j];
        //         }
        //         else if(i+j == arr.length-1){
        //             sum+= arr[i][j];
        //         }
        //     }
        // }

        //Advance Method
        for(int i = 0; i<= arr.length-1; i++){
            //Primary diagonal 
            sum += arr[i][i];
            //Secondary Diagonal
            if(i != arr.length-1-i){
                sum += arr[i][arr.length-1-i];
            }
        }

        return sum;
    }
    public static void sprial(int arr[][]){
        int startRow = 0 , startCol = 0;
        int endRow = arr.length-1, endCol = arr[0].length-1;

        while(startRow <= endRow && startCol <= endCol){

            //top
            for(int j = startCol; j<= endCol; j++){
                System.out.print(arr[startRow][j]+" ");
            }

            //right
            for(int i = startRow+1; i<= endRow; i++){
                System.out.print(arr[i][endCol]+" ");
            }

            //bottom
            for(int j= endCol-1; j>=startCol; j--){
                System.out.print(arr[endRow][j]+" ");
            }

            //left
            for(int i =endRow-1; i>startRow; i--){
                System.out.print(arr[i][startCol]+" ");
            }
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int arr [][] = new int [3][3];
        int n = arr.length, m = arr [0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        //sprial(arr);
        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<m; j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        boolean sum = search(arr, 25);
        System.out.println(sum);
        sc.close();
    }
}
