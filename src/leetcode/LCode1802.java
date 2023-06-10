package leetcode;

import java.util.function.Function;

//https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/
public class LCode1802 {
    public static void main(String[] args) {
        System.out.println(maxValue(5, 3, 57));
        System.out.println(maxValue(4, 2, 6));
        System.out.println(maxValue(6, 1, 10));
    }

    public static int maxValue(int n, int index, int maxSum) {
        Function<Double, Double> arraySum = (maxValue) -> { // 20
            double leftSum = 0;
            if (maxValue <= index + 1) {
                leftSum += ((maxValue) * (maxValue + 1))/2;
                leftSum += index - maxValue + 1;
            } else {
                leftSum += ((index + 1) * (maxValue - index + maxValue))/2; // 55.5
            }

            int rIndex = n - index - 1; // 1
            double rightSum = 0;
            if (maxValue <= rIndex + 1) {
                rightSum += ((maxValue) * (maxValue + 1))/2;
                rightSum += rIndex - maxValue + 1;
            } else {
                rightSum += ((rIndex + 1) * (maxValue - rIndex + maxValue))/2; // 19.5
            }

            return leftSum + rightSum - maxValue;
        };

        return binarySearch(1, maxSum, maxSum, arraySum);
    }

    private static int binarySearch(int left, int right, int maxSum, Function<Double, Double> arraySum) {
        if (left > right) {
            return -1;
        }

        int mid = left + ((right - left)/2);

        double sum = arraySum.apply((double) mid);

        if (sum <= maxSum) {
            int ansRight = binarySearch(mid + 1, right, maxSum, arraySum);
            if (ansRight != -1) {
                return ansRight;
            } else {
                return mid;
            }
        } else {
            return binarySearch(left, mid - 1, maxSum, arraySum);
        }
    }
}
