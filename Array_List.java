package Java;
import java.util.ArrayList;
import java.util.Collections;
public class Array_List {
    public static void sort_ArraList(ArrayList<Integer> list, boolean choice){
        if(choice){
            Collections.sort(list);
        }
        else{
            Collections.sort(list, Collections.reverseOrder());
        }
    }
    public static void swapingArray(ArrayList<Integer> list, int idx, int idx1){
        int temp = list.get(idx);
        list.set(idx, list.get(idx1));
        list.set(idx1, temp);
    }
    public static int maxElement(ArrayList<Integer> list){
        int m = Integer.MIN_VALUE;
        for(int i = 0; i<list.size(); i++){
            if(list.get(i) > m){
                m = list.get(i);
            }
        }
        return m;
    }
    public static void ReverseArrayList(ArrayList<Integer> list) {
        for(int i = list.size()-1; i>=0; i--){
            System.out.print(list.get(i)+ " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();

        //Adding Element 
        list.add(5);
        list.add(6);
        list.add(8);
        list.add(10);
        list.add(23);
        list.add(32);
        System.out.println(list);

        //Get  Element
        int element = list.get(2);
        System.out.println(element);

        //Removing Element
        list.remove(4);
        System.out.println(list);

        //Set Element
        list.set(4, 24);
        System.out.println(list);

        System.out.println(list.contains(24));
        System.out.println(list.contains(18));

        ReverseArrayList(list);
        System.out.println(maxElement(list));
        swapingArray(list, 2, 4);
        System.out.println(list);

        sort_ArraList(list, false);
        System.out.println(list);
    }
}
