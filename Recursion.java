package Java;
import java.util.*;
public class Recursion {
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
    }
}
