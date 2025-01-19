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
    //nextPermutation(nums);
        nextPermutationMine(nums);
    }
    public static void nextPermutationMine(int[] nums) {
        List<Integer> permutation = new ArrayList<>();
        for(int num:nums){
            permutation.add(num);
        }

        int capturedIndex =-1;
        for (int i = permutation.size() - 2; i >= 0; i--) {
            if (permutation.get(i) < permutation.get(i + 1)) {
                // index i is the break point
                capturedIndex = i;
                break;
            }
        }
        // Step : Edge case
        if(capturedIndex==-1){
            Collections.reverse(permutation);
            for(int i=0;i<nums.length;i++){
                nums[i]=permutation.get(i);
            }
        }
        else
        {
            // Step 2:
            for(int i=permutation.size()-1; i>=0;i--){
                if(permutation.get(i)>permutation.get(capturedIndex)){
                    int temp = permutation.get(i);
                    permutation.set(i, permutation.get(capturedIndex));
                    permutation.set(capturedIndex, temp);
                    break;
                }
            }
            List<Integer> remainingVal = permutation.subList(capturedIndex+1, permutation.size());
            Collections.reverse(remainingVal);
            System.out.println(remainingVal);
            int count=0;
             for(int i=capturedIndex+1;i<nums.length;i++){
                 permutation.set(i,remainingVal.get(count));count++;
             }
            System.out.println(permutation);
             for(int i=0; i<nums.length;i++){
                 nums[i]=permutation.get(i);
             }
        }
        //return nums;
    }
    public static int[] nextPermutation(int[] nums) {
        int capturedIndex=-1;
        int nextHighest=-1;
        // step 1 find breaking point
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                capturedIndex=i;
                break;
            }
        }
        // if there is no breaking  point
        if(capturedIndex==-1){
            reverse(nums,0);
        }

        else{
            // step 2 find next greater element and swap with nextHighest
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[capturedIndex]){
                    nextHighest=i;
                    break;
                }
            }

            swap(nums,capturedIndex,nextHighest);
            // step 3 reverse the rest right half
            reverse(nums,capturedIndex+1);
        }
        return nums;
    }
    static void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    static void reverse(int[] nums, int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
