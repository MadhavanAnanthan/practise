package org.example.dsa.arrays.medium;
/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/maximum-subarray/description/
 * Ref1: https://www.naukri.com/code360/problems/630526?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTabValue=PROBLEM
 */
// TODO - THEORY
/*
If we want to calculate the sum of continous sub array,
we can simply use kadane's algorithm, if we need to return the total length
 of continous array or index from start to end. we can't use kadane's algorithm.

If the calculated sum value is less than zero, then we can consider
the calculated sum value is 0. thats the trick of using kadane's algorithm.
 */
// I CAN'T ABLE TO SOLVE THIS PROBLEM
public class MaximumSubarray_53_DK {
    public static void main(String[] args) {
        int[] arr = {10,20,-30,40,-50,60};
        //maxSubarraySumBrute(arr,6); - O(n cube) , O(1)
        //maxSubarraySumBetter(arr,6); - O(n square) , O(1)
        int[] arr1 = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubarraySumOptimal(arr1); // - O(n) , O(1)
    }
    public static int maxSubarraySumBrute(int[] arr, int n) {
        if(n==0)
            return 0;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxi = Math.max(maxi, sum<0?0:sum);
            }
        }
        return maxi;
    }

    public static int maxSubarraySumBetter(int[] arr, int n) {
        if(n==0)
            return 0;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxi = Math.max(maxi, sum<0?0:sum);
            }
        }
        return maxi;
    }

    public static int maxSubarraySumOptimal(int[] nums) {
        int maxi=nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            maxi=(sum>maxi)?sum: maxi;
            if(sum<0){
                sum=0;
            }
        }
        return maxi;
    }
}
