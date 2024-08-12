package Java;
import java.util.ArrayList;
public class Array_List {
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
    }
}