package Java;

public class DivideAdConqure {
    public static void printArr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void meargshor(int arr[], int si, int ei){
        //Base
        if(si >= ei){
            return;
        }
        int mid = si+(ei-si)/2;
        //left part
        meargshor(arr, si, mid);
        //right part
        meargshor(arr, mid+1, ei);
        mearg(arr, mid, si, ei);
    }
    public static void mearg(int arr[], int mid, int si, int ei){
        int temp[] = new int[(ei - si) +1];
        int i = si; // Starting idx for left part.
        int j = mid + 1; // Starting idx for right part.
        int k = 0; //iteration for temp arr.

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //left part
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        //right part
        while(j <= ei){
            temp[k++] = arr[j++];
        }
        //copy temp to original arr
        for(k = 0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }
    public static void main(String args[]){
        int arr[] = {8,5,7,6,9,4,2};
        meargshor(arr, 0, arr.length-1);
        printArr(arr);
    }
}
