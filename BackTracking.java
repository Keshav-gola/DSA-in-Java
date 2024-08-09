package Java;

public class BackTracking {
    public static void subSetString(String str, String ans, int i ){
        if(i == str.length()){
            System.out.println(ans);
            return;
        }
        //yes
        subSetString(str, ans + str.charAt(i), i+1);
        // No
        subSetString(str, ans, i+1);
    }
    public static void main(String args[]){
        String str = "abc";
        String ans = "";
        subSetString(str, ans, 0);
    }
    
}
