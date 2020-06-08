package Changjiang.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }

        //System.out.println(Arrays.toString(arr));
        // test time that used
        long startTime = System.currentTimeMillis();

        insertSort(arr);

        long endTime = System.currentTimeMillis();
        System.out.println("Select Sort uses " + (endTime - startTime) + "ms to finish sort");
        //System.out.println(Arrays.toString(arr));
    }

    /*
        Theory:
        1. divide array into two parts: the order array and the unordered array
        The order array start with only one element: array[0]
        the rest of the array is the unordered array
        2. Get the first element from the unordered array, and find it's position in the order array
           Put this element to the order array and get a new order array.
        3. Repeat step [2] until the unordered array is empty.

        Time complexity : O(n^2)
     */
    public static void insertSort(int[] arr){

        int insertVal;      // save the value of the first element in the unordered array
        int insertIndex;    // use to find the position to insert the number get from the unordered array

        for(int i = 1; i < arr.length; i++){

            insertVal = arr[i];
            insertIndex = i -1;

            // start from the last number arr[insertIndex] in the order array
            for(int j = insertIndex; j >= 0; j--){
                if(arr[j] > insertVal){
                    // if is not the right position, move arr[insertIndex] to arr[insertIndex + 1]
                    arr[j + 1] = arr[j];
                }else{
                    // if is the right position, exit for-loop
                    insertIndex = j + 1;
                    break;
                }
            }

            //after for-loop, check if need to insert number
            if(insertIndex!= i){

                arr[insertIndex] = insertVal;
            }

        }

    }
}
