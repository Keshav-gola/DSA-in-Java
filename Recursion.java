package Java;
import java.util.*;
public class Recursion {
    public static void removeDuplicate(boolean map[], StringBuilder newStr, int idx, String str ){
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }
        char currElement = str.charAt(idx);
        if(map[currElement - 'a'] == true){
            removeDuplicate(map, newStr, idx+1, str);
        }
        else{
            map[currElement - 'a'] = true;
            removeDuplicate(map, newStr.append(currElement), idx+1, str);
        }
    }
    public static int tiling(int n){
        //base case
        if(n == 0 || n == 1){
            return 1;
        }
        //kaam
        //vertical 
        int fnm1 = tiling(n-1);
        //horizontal
        int fnm2 = tiling(n-2);

        int total = fnm1 + fnm2;
        return total;
    }
    public static int optimzPower(int a, int n){
        if(n == 0){
            return -1;
        }
        int halfPow = optimzPower(a, n/2);
        int halfPowSq = halfPow * halfPow;

        // n = odd
        if(n % 2 != 0){
            halfPowSq = a * halfPowSq;
        }
        return halfPowSq;
    }
    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        int xtmn = power(x,n-1);
        int xn = x * xtmn;
        return xn; 
    }
    public static int lastOccurs(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }
        int lastFound = lastOccurs(arr, key, i+1);
        if(lastFound == -1 && arr[i] == key){
            return i;
        }
        return lastFound;
    }
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
        System.out.println(fabinachi(4));
        int arr[] = {8,9,10,15,16};
        System.out.println(isSorted(arr, 0));
        System.out.println(firstOccurs(arr, 15, 0));
        System.out.println(lastOccurs(arr, 5, 0));
        System.out.println(power(25, 0));
        System.out.println(optimzPower(5, 2));
        System.out.println(tiling(4));
        StringBuilder newStr = new StringBuilder("");
        boolean map[] = new boolean[26];
        String str = "kessshhavv";
        removeDuplicate(map, newStr, 0, str);

    }
}
