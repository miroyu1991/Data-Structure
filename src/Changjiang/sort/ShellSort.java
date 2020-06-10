package Changjiang.sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }

        //System.out.println(Arrays.toString(arr));
        // test time that used
        long startTime = System.currentTimeMillis();

        shellSort(arr);

        long endTime = System.currentTimeMillis();
        System.out.println("Select Sort uses " + (endTime - startTime) + "ms to finish sort");
        //System.out.println(Arrays.toString(arr));
    }

    /*
        Theory:
        1. divide all number in the array as arr.length/gap group
        at the beginning: gap = arr.length/2
        2. use insertSort to make every group is in order.
        3. gap = gap/2 and repeat step[1] and [2], until gap = 1;

         Time complexity : O(nlogn), worst: O(n^s, 1 < s < 2)
     */

    public static void shellSort(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            //use insert sort
            for (int i = gap; i < arr.length; i++) {

                int insertVal = arr[i];
                int insertIndex = i;

                if (arr[insertIndex] < arr[insertIndex - gap]){
                    // check the position to insert
                    while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]) {
                        // move
                        arr[insertIndex] = arr[insertIndex - gap];
                        insertIndex -= gap;
                    }

                    // insert
                    arr[insertIndex] = insertVal;
                }
            }
        }

    }
}
