package Java;
import java.util.*;
public class ARRAY {
    public static void bubble_sort(int arr[]){
        for(int i = 0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++ ){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void selection_sort(int arr[]){
        for(int i = 0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static int sub_arry(int arr[]){
        int sum , maxSubArry = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            for(int j = i; j<arr.length; j++){
                sum = 0;
                for(int k = i; k<=j; k++ ){
                    System.out.print(+arr[k]);
                    sum += arr[k];
                }
                System.out.println();
                if(maxSubArry<sum){
                    maxSubArry = sum;
                }
            }
            System.out.println();
        }
        return maxSubArry;
    }
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

        // int waterValue = tapping_rainwater(arr);
        // System.out.println(waterValue);
        // int total = sub_arry(arr);
        // System.out.println(total);
        //bubble_sort(arr);
        selection_sort(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
