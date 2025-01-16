package org.example.dsa.myList.twoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/number-of-distinct-averages/description/?envType=problem-list-v2&envId=two-pointers
 */
public class NumberOfDistinctAverages_2465 {
    // TC are best,average,worst
    public static void main(String[] args) {
        int[] nums = {4,1,4,0,3,5};
        //distinctAveragesUsingQuickSort(nums); // O(N log N) / O(N log N) / O(N^2) and O(log N) or O(N)
       // MINE
        distinctAveragesUsingInternalSort(nums); // O(N log N) , O(N) or O(log N)
        //distinctAveragesUsingLeetCodeOptimal(nums); // O(N) and O(n)
    }

    private static int distinctAveragesUsingLeetCodeOptimal(int[] nums) {
        int[] freq = new int[101]; // Assuming nums[i] is bounded by 0 <= nums[i] <= 100
        // Count the frequency of each number
        for (int num : nums) {
            freq[num]++;
        }
        int left = 0, right = 100;
        HashSet<Integer> set = new HashSet<>();
        while (left <= right) {
            // Find the smallest number available
            while (left <= right && freq[left] == 0) left++;
            // Find the largest number available
            while (left <= right && freq[right] == 0) right--;
            if (left > right) break;
            // Pair smallest and largest numbers
            int avg = left + right; // Integer average * 2 (avoid float division)
            set.add(avg);
            // Decrease their frequency
            freq[left]--;
            freq[right]--;
        }

        return set.size();
    }

    private static int distinctAveragesUsingInternalSort(int[] nums) {
        Arrays.sort(nums); //O(n)
        Set<Double> set = new HashSet<>(); // O(n)
        int left=0,right=nums.length-1;
        while(left<right){ // O(n)
            set.add((nums[left]+nums[right])/2.0);
            left++;right--;
        }
        return set.size();
    }

    public static int distinctAveragesUsingQuickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        Set<Double> set = new HashSet<>(); // O(n)
        int left=0,right=nums.length-1;
        while(left<right){ // O(n)
            set.add((nums[left]+nums[right])/2.0);
            left++;right--;
        }
        return set.size();
    }
    static void quickSort(int arr[], int low, int high) {
        if(low==high || low>high){
            return;
        }
        int start = low;
        int end = high;
        int pivot = arr[end];

        while(start<=end){
            while(arr[start]<pivot){
                start++;
            }
            while(arr[end]>pivot){
                end--;
            }
            if(start<=end){
                int temp = arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}
