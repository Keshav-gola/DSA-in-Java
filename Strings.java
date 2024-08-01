package Java;
import java.util.*;
public class Strings {
    public static boolean palimdrom(String str){
        int n = str.length()-1;
        for(int i = 0; i<=n/2; i++){
            if(str.charAt(i) != str.charAt(n-i)){
                System.out.println("No it is not a palimdrom");
                return false;
            }
        }
        System.out.println("This string is palimdrom");
        return true;
    }
    public static void main(String args[]){
        //String str = "keshav gola";
        // System.out.println(str.charAt(0));
        // Scanner sc = new Scanner(System.in);
        // String str1 = sc.nextLine();
        // System.out.println(str+"\n"+str1);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        palimdrom(str);
    }
}
