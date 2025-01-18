package org.example.dsa.arrays.medium;
/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 */
public class RearrangeArrayElementsBySign_2149 {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        rearrangeArrayOptimal(nums); // O(n) and O(n)
        rearrangeArrayBrute(nums); // 0(n + n/2) and 0(n)
    }

    public static int[] rearrangeArrayBrute(int[] nums) {
        int[] postives = new int[nums.length/2];
        int[] negatives = new int[nums.length/2];
        int positivesLength = postives.length;
        int negativesLength = negatives.length;
        for(int num:nums){ // 0(n)
            if(num>0){
                postives[postives.length-positivesLength]=num;
                positivesLength--;
            }else{
                negatives[negatives.length-negativesLength]=num;
                negativesLength--;
            }
        }
        positivesLength = postives.length;
        negativesLength = negatives.length;
        for(int num=0;num<nums.length;num++){ // 0(n)
            nums[num]=postives[postives.length-positivesLength];positivesLength--;num++;
            nums[num]=negatives[negatives.length-negativesLength];negativesLength--;
        }
        return nums;

    }

    public static int[] rearrangeArrayOptimal(int[] nums) {
        //3ms
        int[] merged = new int[nums.length];
        int even = 0;
        int odd = 1;
        for (int num : nums) {
            if (num > 0) {
                merged[even] = num;
                even += 2;
            } else {
                merged[odd] = num;
                odd += 2;
            }
        }
        return merged;
    }
}
