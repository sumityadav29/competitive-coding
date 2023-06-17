package leetcode;

import java.util.Arrays;

public class LCode1011 {

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = new int[] {3,2,2,4,1,4};
        int[] arr3 = new int[] {1,2,3,1,1};

        System.out.println(shipWithinDays(arr1, 5));
        System.out.println(shipWithinDays(arr2, 3));
        System.out.println(shipWithinDays(arr3, 4));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int weightsSum = Arrays.stream(weights).sum();
        return binarySearch(0, weightsSum, weights, days);
    }

    private static int binarySearch(int left, int right, int[] arr, int k) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left)/2;

        boolean canDivide = canDivideIntoKSubArrayWithXMaxSubArraySum(arr, k, mid);

        if (canDivide) {
            int leftAns = binarySearch(left, mid - 1, arr, k);
            return leftAns == - 1 ? mid : leftAns;
        } else {
            return binarySearch(mid + 1, right, arr, k);
        }
    }

    private static boolean canDivideIntoKSubArrayWithXMaxSubArraySum(int[] arr, int k, int maxSum) {
        int currSubArraySum = 0;
        int totalPartitionsTillNow = 1;
        int maxPartitionSum = Integer.MIN_VALUE;
        for (int i = 0 ; i < arr.length ; i++) {
            int curr = arr[i];
            if (curr + currSubArraySum <= maxSum && arr.length - i - 1 >= k - totalPartitionsTillNow) {
                currSubArraySum += curr;
            } else {
                currSubArraySum = curr;
                totalPartitionsTillNow += 1;
            }
            maxPartitionSum = Math.max(maxPartitionSum, currSubArraySum);
        }
        return totalPartitionsTillNow == k && maxPartitionSum <= maxSum;
    }
}
