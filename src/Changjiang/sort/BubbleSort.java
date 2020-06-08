package Changjiang.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*10000);
        }

        // test time used
        long startTime = System.currentTimeMillis();

        bubbleSort(arr);

        long endTime = System.currentTimeMillis();
        System.out.println("Bubble Sort uses " + (endTime - startTime) + "ms to finish sort");
        //System.out.println(Arrays.toString(arr));
    }

    /*
        Theory:
        1.For all number in the array, start from the first number and end of the last number - 1
        compare the number and next of this number, if meet exchange condition, exchange these numbers
        Finally get the last round time numbers in order
        For example: if run step [1] 5 times, I will get 5 numbers in the right position
        This is a round
        2. If last round change the position of numbers, start next round
        Until every number is in order:
            No more exchange or round arr.length - 1 times.

        Time complexity : O(n^2)
     */
    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false; //use to judge if the array needs another round of sort

        for(int i = 0; i < arr.length -1; i++){
            for(int j = 0; j < arr.length -1 -i; j++){
                if(arr[j] > arr[j+1]){

                    // if arr[j] > arr[j+1], exchange these two numbers and set flag to true
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }

            if(flag){
                // If exchange numbers, reset flag
                flag = false;
            }else{
                // If not exchange numbers, exit the for-loop
                break;
            }
        }
    }
}
