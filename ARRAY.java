package Java;
import java.util.*;
public class ARRAY {
    public static void reverse_arry(int arr[]){
        int start = 0, last = arr.length-1;

        while(start < last){
            int temp = arr[last];
            arr[last] = arr[start];
            arr[start] = temp;
            start++;
            last--;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr[] = {5,6,7,14,3};
        reverse_arry(arr);
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }

    }
}
