package org.example.dsa.arrays.medium;

import java.util.*;
/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        int[] nums={9,1,4,7,3,-1,0,5,8,-1,6};
       // int[] nums={100,4,200,1,3,2};
        int i =0;
        //i=longestConsecutiveBrute(nums);
        //i=longestConsecutiveBetter(nums);
        //i=longestConsecutiveOptimal(nums);
        System.out.println(i);
    }

    // TC:O(n log n)	SC:O(1) or O(log n)    Bottleneck:Sorting
    private static int longestConsecutiveBetter(int[] nums) {
        Arrays.sort(nums);
        int lastSmaller=Integer.MIN_VALUE;
        int count=0;
        int longest=1;
        if (nums.length==0)
            return count;

        for (int i=0; i<nums.length;i++){
            if(nums[i]-1==lastSmaller){
                lastSmaller=nums[i];
                count++;
            }else if (nums[i]!=lastSmaller){
                count=1;
                lastSmaller=nums[i];
            }
            longest=(count>longest)?count:longest;
        }
        return longest;
    }

    // TC:O(n log n)	SC:O(n)	    Bottleneck:Multiple data structures, ArrayList
    public static int longestConsecutiveBrute(int[] nums){
        if(nums.length==1)
            return 1;

        if(nums.length==0)
            return 0;
        // Below set is not required
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        // TreeSet maintains sorting order and eliminates duplicates
        Set<Integer> sorted = new TreeSet<>(set);
        if(sorted.size()==1)
            return 1;

        int count=1;
        List<Integer> list = new ArrayList<>();
        int maxConsecutive=1;
        if(sorted.size()>1){
            for(int n : sorted){
                list.add(n);
            }
            int nextExpectedNumber=0;
            nextExpectedNumber=list.get(0)+1;

            for(int i=1; i< list.size();i++){
                if(list.get(i).equals(nextExpectedNumber)){
                    nextExpectedNumber=list.get(i)+1;
                    count++;
                    maxConsecutive=Math.max(maxConsecutive,count);
                }else{
                    nextExpectedNumber=list.get(i)+1;
                    count=1;
                }
            }
        }
        return maxConsecutive;
    }

    // TC:O(n)	SC:O(n)	    Bottleneck:HashSet operations (minor)
    public static int longestConsecutiveOptimal(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        if(nums.length==0)
            return 0;

        int lastVal=0,count=0,longest=1;
        for(int n : set){
            if(!set.contains(n-1)){
                lastVal=n;count=1;
                while(set.contains(lastVal+1)){
                    count++;
                    lastVal=lastVal+1;
                }
            }
            longest=(count>longest)?count:longest;
        }
        return longest;
    }
}
