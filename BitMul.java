package Java;
import java.util.*;
public class BitMul {
    public static int clearIthbit(int n, int i) {
        int bitmas = ~(1<<i);
        return n & bitmas;
    }
    public static int setIthbit(int n, int i) {
        int bitmas = 1<<i;
        return n|bitmas;
    }
    public static int getIthbit(int n, int i){
        int bitmas = 1<<i;
        if((n & bitmas) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public static void evenOrodd(int num){
        num = num & 1;
        if(num == 0){
            System.out.println("This number is Even");
        }
        else{
            System.out.println("This number is odd");
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        //Binary AND &
        System.out.println(a&b);

        //Binary OR |
        System.out.println(a|b);

        //Binary XOR ^
        System.out.println(a^b);

        //Binary one's Compliment
        System.out.println(~a);

        //Binary Left Shift <<
        System.out.println(a<<b);

        //Binary Right Shift >>
        System.out.println(a>>b);

        evenOrodd(a);

        System.out.println(getIthbit(a, b));

        System.out.println(setIthbit(a, b));

        System.out.println(clearIthbit(a, b));
    }
}
