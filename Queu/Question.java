package Java.Queu;
import java.util.*;
public class Question {
    public static void reverse(Queue<Integer> q){
        Stack <Integer> s = new Stack<>();

        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        } 
    }
    public static void printNonRepating(String str){
        int freq [] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()) {
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    } 
    public static void main(String args[]){
        String str = "aabccxb";
        printNonRepating(str);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reverse(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove()+ " ");
        }
        System.out.println();

    }
}
