package Java;
import java.util.*;
public class Strings {
    public static StringBuilder compress(String str){
        StringBuilder st = new StringBuilder("");
        for(int i = 0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            st.append(str.charAt(i));
            if(count > 1){
                st.append(count.toString());
            }
        }
        return st;
    }
    public static StringBuilder upperString(String str) {
        StringBuilder  sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i = 1; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb;
    }
    public static void subString(String str, int si, int ei){
        for(int i = si; i<=ei; i++){
            System.out.print(str.charAt(i));
        }
    }
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
        //String path = "WNEENESENNN";
        //float a = shortestPath(path);
        //System.out.println(a);
        //subString(str, sc.nextInt(), sc.nextInt());
        StringBuilder sb = compress(str);
        System.out.println(sb);
        sc.close();
    }
}
