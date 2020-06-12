package Changjiang.search;

public class InterpolationSearch {
    public static void main(String[] args) {
        //Test
        int arr[] = {1, 2, 4, 8, 12, 15, 65, 345, 2345};
        int resultIndex = interpolationSearch(arr, 0, arr.length - 1, -1);
        System.out.println("Result of array: Index is " + resultIndex);

    }

    /*
        Theory: Can only used in order array

        1. get the value of mid = left + (findVal - arr[left])*(right - left)/(arr[left] + arr[right])
        2. compare the findVal with mid
            2.1 if findVal == arr[mid], found and return this position
            2.2 if findVal < arr[mid], findVal should be in the left side of the mid,
                set new right = mid - 1 and recursion function.
            2.3 if findVal > arr[mid], findVal should be in the right side of the mid,
                set new left = mid +1 and recursion function.
         3. when left > right, cannot find this number, return -1
     */

    public static int interpolationSearch(int[] arr, int left, int right, int findVal) {

        if (left > right || findVal < arr[left] || findVal > arr[right]) {
            return -1;
        }

        int mid = left + (findVal - arr[left]) * (right - left) / (arr[left] + arr[right]);

        if (findVal < arr[mid]) {
            return interpolationSearch(arr, left, mid - 1, findVal);
        } else if (findVal > arr[mid]) {
            return interpolationSearch(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }
}


