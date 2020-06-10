package Changjiang.search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        //Test
        int arr[] = {1, 2, 4, 8, 12, 15, 65, 345, 2345};
        int resultIndex = binarySearch(arr, 0, arr.length - 1, 3);
        System.out.println("Result of array: Index is " + resultIndex);

        int arr2[] = {1, 1, 1, 1, 1};
        ArrayList<Integer> resultIndex2 = binarySearchMultiple(arr2, 0, arr2.length - 1, 1);
        System.out.println("Result of array2: Index is " + resultIndex2);

    }

    /*
        Theory: Can only used in order array, and can only find one result
        Improved function will be below at this function

        1. get the value of mid = (left +right)/2
        2. compare the findVal with mid
            2.1 if findVal == arr[mid], found and return this position
            2.2 if findVal < arr[mid], findVal should be in the left side of the mid,
                set new right = mid - 1 and recursion function.
            2.3 if findVal > arr[mid], findVal should be in the right side of the mid,
                set new left = mid +1 and recursion function.
         3. when left > right, cannot find this number, return -1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (findVal < arr[mid]) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else if (findVal > arr[mid]) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }

    public static ArrayList<Integer> binarySearchMultiple(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;

        if (findVal < arr[mid]) {
            return binarySearchMultiple(arr, left, mid - 1, findVal);
        } else if (findVal > arr[mid]) {
            return binarySearchMultiple(arr, mid + 1, right, findVal);
        } else {
            ArrayList<Integer> result = new ArrayList<Integer>();

            int index = mid - 1;
            while (true) {
                if (index < 0 || arr[index] != findVal) {
                    break;
                } else {
                    if (result.isEmpty()){
                        result.add(index);
                    }else{
                        result.add(0,index);
                    }

                    index--;
                }
            }

            result.add(mid);

            index = mid + 1;
            while (true) {
                if (index > arr.length - 1 || arr[index] != findVal) {
                    break;
                } else {
                    result.add(index);
                    index++;
                }
            }

            return result;
        }
    }
}
