package Java.Stack;
import java.util.Stack;
public class StackCollection {
    public static void pushAtBottom(Stack <Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void printStack(Stack <Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1; i<stocks.length; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i -prevHigh;
            }
            s.push(i); 
        }
    }
    public static void nextGratest(int arr[], int nxtGrate[], Stack<Integer> s){
        for(int i = arr.length-1; i>= 0; i--){
            //1 while
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }

            //2 if - else
            if(s.isEmpty()){
                nxtGrate[i] = -1;
            }
            else{
                nxtGrate[i] = arr[s.peek()];
            }
            //3 push in s
            s.push(i);
        }
    }

    public static void main(String args[]){
        Stack <Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 4);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        String str = "Keshav";
        String reuslt = reverseString(str);
        System.out.println(reuslt);
        reverseStack(s);
        printStack(s);
        
        
        int stock[] = {100,80,60,70,60,85,100};
        int span[] = new int[stock.length];
        
        stockSpan(stock, span);
        for(int i =0; i<span.length; i++){
            System.out.print(span[i]+ " ");
        }
        System.out.println();

        int arr[] = {6,8,0,1,3};
        Stack <Integer> obj = new Stack<>();
        int nextGrater[] = new int[arr.length];

        nextGratest(arr, nextGrater, obj);
        for(int i =0; i<nextGrater.length; i++){
            System.out.print(nextGrater[i]+ " ");
        }
        
    }
}
