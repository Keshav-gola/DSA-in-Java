package Java;

public class BackTracking {
    public static void purmentation (String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i = 0; i< str.length(); i++){
            char curr = str.charAt(i);
            String Newstr = str.substring(0, i) + str.substring(i+1);
            purmentation(Newstr, ans+curr);
        }
    }
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
        purmentation(str, ans);
    }
    
}
