package Changjiang.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }

        //System.out.println(Arrays.toString(arr));
        // test time that used
        long startTime = System.currentTimeMillis();

        quickSort(arr,0, arr.length -1);

        long endTime = System.currentTimeMillis();
        System.out.println("Select Sort uses " + (endTime - startTime) + "ms to finish sort");
        //System.out.println(Arrays.toString(arr));
    }

    /*
        Theory:
        1. Find a pivot number (In this case, I set the middle number as the pivot number)
        2. Change numbers between the pivot number:
            if the number is larger than the pivot number, put it in the right side.
            if the number is smaller than the pivot number, put it in the left side.
        3. Using the recursion way to repeat step[1] and [2], until the whole array can not divide any more.
     */
    public static void quickSort(int[] arr, int left, int right){

    }
}
