package Changjiang.search;

public class SeqSearch {

    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, 11);

        if(index == -1){
            System.out.println("Cannot find this number in the array.");
        }else {
            System.out.println("In array the number is the " + (index+1) + "number");
        }
    }

    public static int seqSearch(int[] arr, int findVal) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == findVal) {
                return i;
            }
        }

        return -1;
    }

}


