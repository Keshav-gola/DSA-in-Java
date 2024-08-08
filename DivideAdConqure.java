package Java;

public class DivideAdConqure {
    public static int searchInRoated(int arr[], int tar, int si, int ei){

        int mid = (si + ei) / 2;
        if(arr[mid] == tar){
            return mid;
        }
        if(arr[si] <= arr[mid]){
            if(arr[si] <= tar && tar <= arr[mid]){
                return searchInRoated(arr, tar, si, mid-1);
            }
            else{
                return searchInRoated(arr, tar, mid+1, ei);
            }
        }
        else{
            if(arr[mid] <= tar && tar <= arr[ei]){
                return searchInRoated(arr, tar, mid+1, ei);
            }
            else{
                return searchInRoated(arr, tar, si, mid-1);
            }
        }
    }
    public static void printArr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        //last element
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }
    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si - 1;
        
        for(int j = si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
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
        int arr[] = {7,8,9,0,1,2};
        //meargshor(arr, 0, arr.length-1);
        //quickSort(arr, 0, arr.length-1);
        //printArr(arr);
        System.out.println(searchInRoated(arr, 0, 0, arr.length-1));
    }
}
