package Java;
import java.util.*;
public class Strings {
    public static float shortestPath(String str){
        int x =0, y=0;
        for(int i = 0; i<=str.length()-1; i++){
            if(str.charAt(i)=='W'){
                x--;
            }
            else if(str.charAt(i) == 'E'){
                x++;
            }
            else if(str.charAt(i) == 'N'){
                y++;
            }
            else{
                y--;
            }
        }
        int X = x*x;
        int Y = y*y;
        return (float)Math.sqrt(X+Y);
    }
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
        //palimdrom(str);
        String path = "WNEENESENNN";
        float a = shortestPath(path);
        System.out.println(a);
    }
}
