package Java;
import java.util.*;
public class ARRAY {
    public static int tapping_rainwater(int arr[]){
        int n = arr.length;
        //Calculate left max boundary
        int leftmax[] = new int[n];
        leftmax[0] = arr[0];
        for(int i = 1; i<n; i++){
            leftmax[i] = Math.max(arr[i],leftmax[i-1]);
        }

        //Calculate right max boundary
        int rightmax[] = new int[n];
        rightmax[n-1] = arr[n-1];
        for(int i = n-2; i>=0; i--){
            rightmax[i] = Math.max(arr[i], rightmax[i+1]);
        }

        int trappedWater = 0;
        for(int i = 0; i<n; i++){
            int waterlevel = Math.min(rightmax[i],leftmax[i]);
            trappedWater += waterlevel - arr[i];
        }

        return trappedWater;
    }
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
        int arr[] = {4,2,0,6,3,2,5};
        // reverse_arry(arr);
        // for(int i =0; i<arr.length; i++){
        //     System.out.print(arr[i]+" ");
        // }

        int waterValue = tapping_rainwater(arr);
        System.out.println(waterValue);
    }
}
