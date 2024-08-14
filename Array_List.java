package Java;
import java.util.ArrayList;
import java.util.Collections;
public class Array_List {
    public static boolean pairedSum(ArrayList<Integer> check, int target){
        //----------->BrutForce<------------O(n^2)
        // for(int i = 0; i<list.size(); i++){
        //     for(int j = i+1; j<list.size(); j++){
        //         if((list.get(i)+list.get(j))== target){
        //             return true;
        //         }
        //     }
        // }
        //---------------->AdvaceMethod<-------------O(n)
        //but it work only when list is sorted
        int lp =0, rp = check.size()-1;
        while(lp != rp){
            if((check.get(lp)+check.get(rp)) == target){
                return true;
            }
            else if((check.get(lp)+check.get(rp)) < target){
                lp++;
            }
            else{
                rp--;
            }
        }
        return false;
    }
    public static int trapped_water(ArrayList<Integer> heigth){
        int maxWater = 0 ;
        //----->BrutForce<--------O(n^2)
        // for(int i = 0; i<heigth.size(); i++){
        //     for(int j = i+1; j<heigth.size(); j++){
        //         int waterLevel = Math.min(heigth.get(i),heigth.get(j));
        //         int width = j-i;
        //         int total = waterLevel * width;
        //         if(total > maxWater){
        //             maxWater = total;
        //         }
        //     }
        // }
        //---------------->Optimize<------------O(n)
        int lp = 0;
        int rp = heigth.size()-1;
        while(lp < rp){
            int waterLevel = Math.min(heigth.get(lp),heigth.get(rp));
            int width = rp-lp;
            int total = waterLevel * width;
            maxWater = Math.max(total, maxWater);
            if(heigth.get(lp)< heigth.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;

    }
    public static void mulitDList(ArrayList<ArrayList<Integer>> mainList){
        ArrayList<Integer> list  = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 1; i<6; i++){
            list.add(i);
            list1.add(i*2);
            list2.add(i*3);
        }
        mainList.add(list);
        mainList.add(list1);
        mainList.add(list2);
        System.out.println(mainList);
    }
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
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        mulitDList(mainList);
        ArrayList<Integer> heigth = new ArrayList<>();
        heigth.add(1);
        heigth.add(8);
        heigth.add(6);
        heigth.add(2);
        heigth.add(5);
        heigth.add(4);
        heigth.add(8);
        heigth.add(3);
        heigth.add(7);
        System.out.println(trapped_water(heigth));
        ArrayList<Integer> check = new ArrayList<>();
        check.add(2);
        check.add(5);
        check.add(8);
        check.add(10);
        check.add(12);
        System.out.println(pairedSum(check, 10));
    }
}
