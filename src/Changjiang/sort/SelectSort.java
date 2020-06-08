package Changjiang.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }

        //System.out.println(Arrays.toString(arr));
        // test time that used
        long startTime = System.currentTimeMillis();

        selectSort(arr);

        long endTime = System.currentTimeMillis();
        System.out.println("Select Sort uses " + (endTime - startTime) + "ms to finish sort");
        //System.out.println(Arrays.toString(arr));
    }

    /*
        Theory:
        1. From arr[0] to arr[n-1], find min number,
        exchange this number with arr[0]
        2. From arr[1] to arr[n-1], repeat step [1]

        Time complexity : O(n^2)
     */
    public static void selectSort(int[] arr) {

        int index;
        int temp;

        for (int i = 0; i < arr.length; i++) {

            //set index to the first element in the range
            index = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    // find a smaller number
                    index = j;
                }
            }

            // after a round, exchange the smallest number in range with arr[i]
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

    }
}
