package Changjiang.search;

import java.util.Arrays;

public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 8, 12, 15, 65, 345, 2345};
        int resultIndex = fibonacciSearch(arr, 2345);
        System.out.println("Result of array: Index is " + resultIndex);

    }

    public static int[] fib() {

        int[] fibArr = new int[maxSize];

        fibArr[0] = 1;
        fibArr[1] = 1;

        for (int i = 2; i < maxSize - 1; i++) {
            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }

        return fibArr;
    }

    public static int fibonacciSearch(int[] arr, int findVal) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        int fibIndex = 0; //index of fibonacci array
        int fibArr[] = fib();

        while (high > fibArr[fibIndex] - 1) {
            fibIndex++;
        }

        // fibonacci array length may longer than arr length,
        // create a new array and make the new part equal to the biggest element in the array
        int[] temp = Arrays.copyOf(arr, fibArr[fibIndex]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + fibArr[fibIndex - 1] - 1;


            if (findVal < temp[mid]) {
                //search in the left side
                high = mid - 1;
                fibIndex--;

            } else if (findVal > temp[mid]) {
                //search in the right side
                low = mid + 1;
                fibIndex++;
                fibIndex -=2;
            } else{
                //found
                if(mid <= high){
                    return mid;
                }else{
                    return high;
                }

            }
        }

        //cannot find position
        return -1;
    }
}
