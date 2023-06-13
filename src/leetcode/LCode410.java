package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/split-array-largest-sum/submissions/970602148/
public class LCode410 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        System.out.println(splitArray(arr, 2));
    }

    public static int splitArray(int[] nums, int k) {
        int arraySum = Arrays.stream(nums).sum();
        return binarySearch(0, arraySum, nums, k);
    }

    private static int binarySearch(int left, int right, int[] arr, int k) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left)/2;
        boolean isPossibleToDivide = isPossibleToDivide(arr, k, mid);

        if (isPossibleToDivide) {
            int leftAns = binarySearch(left, mid - 1, arr, k);
            return leftAns == -1 ? mid : leftAns;
        } else {
            return binarySearch(mid + 1, right, arr, k);
        }
    }

    private static boolean isPossibleToDivide(int[] arr, int k, int reqMaxSum) { //18
        int maxSubArraySum = Integer.MIN_VALUE;
        int totalPartitions = 1;

        int currPartitionSum = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            int curr = arr[i];
            if (currPartitionSum + curr <= reqMaxSum && arr.length - i - 1 >= k - totalPartitions) {
                currPartitionSum += curr;
            } else if (currPartitionSum + curr > reqMaxSum && totalPartitions == k) {
                return false;
            } else {
                currPartitionSum = curr;
                totalPartitions += 1;
            }
            maxSubArraySum = Math.max(currPartitionSum, maxSubArraySum);
        }

        return maxSubArraySum <= reqMaxSum && totalPartitions == k;
    }
}
