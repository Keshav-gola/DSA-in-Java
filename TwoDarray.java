package Java;
import java.util.*;
public class TwoDarray {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int arr [][] = new int [3][3];
        int n = arr.length, m = arr [0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
