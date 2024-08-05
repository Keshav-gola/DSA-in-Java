package Java;
import java.util.*;
public class Recursion {
    public static int firstOccurs(int arr[], int key, int i){
        if(i == arr.length-1){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOccurs(arr, key, i+1);
    }
    public static boolean isSorted (int arr[], int i){
        if(i == arr.length-1){
            return true;
        }

        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int fabinachi(int num){
        if(num == 0 || num == 1){
            return num;
        }
        int fnm1 = fact(num -1);
        int fnm2 = fact(num - 2);
        int fb = fnm1 + fnm2;
        return fb;
    }
    public static int sum(int n){
        if(n == 1){
            return 1;
        }
        int Snm1 = sum(n-1);
        int total = n + Snm1;
        return total;
    }
    public static int fact(int num){
        if(num == 0){
            return 1;
        }
        int fnm1 = fact(num-1);
        int fn = num * fnm1;
        return fn;
    }
    public static void cout(int num){
        if(num == 1){
            System.out.print("1");
            return;
        }
        cout(num-1);
        System.out.print(num);
    }
    public static void printing(int num){
        if(num == 1){
            System.out.print("1");
            return;
        }
        System.out.print(num + " ");
        printing(num - 1);
    }
    public static void main(String args[]) {
        //cout(10);
        System.out.println(fact(5));
        System.out.println(sum(10));
        System.out.println(fabinachi(10));
        int arr[] = {8,9,10,15,16};
        System.out.println(isSorted(arr, 0));
        System.out.println(firstOccurs(arr, 15, 0));
    }
}
