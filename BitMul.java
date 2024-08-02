package Java;
import java.util.*;
public class BitMul {
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

    }
}
