package Striver;

// HOUSE ROBBER 2 -> Now the array is not linear, rather its connected in circle
// 0th house is neighbor of n-1th house
// https://leetcode.com/problems/house-robber-ii/
public class HouseRobber2_Tab {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int n = nums.length;

        int maxSumWithFirst = houseRobber2(nums, 0, n - 2);

        int maxSumWithoutFirst = houseRobber2(nums, 1, n - 1);

        System.out.println(Math.max(maxSumWithFirst, maxSumWithoutFirst));
    }

    // assume elements in the array are non-neg integers
    static int houseRobber2(int nums[], int minIndx, int maxIndx) {
        int n = nums.length;
        int dp[] = new int[n];

        dp[minIndx] = nums[minIndx];

        for (int i = minIndx + 1; i <= maxIndx; i++) {
            int pickSum = nums[i] + (i > 1 ? dp[i - 2] : 0);
            int notPickSum = dp[i - 1];

            dp[i] = Math.max(pickSum, notPickSum);
        }

        return dp[maxIndx];
    }
}
