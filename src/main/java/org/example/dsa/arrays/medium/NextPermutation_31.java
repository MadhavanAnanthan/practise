package org.example.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/next-permutation/
 */
// Added separate Markdown file on the same name for more understanding - NextPermutation_31.md
public class NextPermutation_31 {
    public static void main(String[] args) {
    int[] nums = {2,3,1,5,4};
    nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        int dipIndex = -1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                dipIndex=i;
                break;
            }
        }

        if(dipIndex==-1){
            int left=0;
            int right=nums.length-1;
            reverse(nums, left, right);
        }
        else{
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[dipIndex]){
                    swap(nums, dipIndex, i);
                    break;
                }
            }
            reverse(nums, dipIndex+1, nums.length-1);
        }
    }
    static void reverse(int[] nums, int left, int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;right--;
        }
    }
    static void swap(int[] nums, int left, int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
