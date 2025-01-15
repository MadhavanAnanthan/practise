package org.example.dsa.myList.twoPointers;

import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/merge-sorted-array/description/?envType=problem-list-v2&envId=two-pointers
 */
public class MergeTwoSortedArrays_88 {

    public static void main(String[] args) {
        int[] nums1 ={1,2,3,0,0,0};
        int[] nums2 ={2,5,6};
        //mergeBrute(nums1, 3, nums2, 3);
        //mergeBetter(nums1, 3, nums2, 3);
        mergeOptimal(nums1, 3, nums2, 3);
    }
    // Mine
    public static void mergeBrute(int[] nums1, int m, int[] nums2, int n) {
        SortedMap<Integer,Integer> map = new TreeMap<>();
        if(n==0)
            return;

        m=m-1;n=n-1;
        while(m>=0 || n>=0){
            if(m>=0 )
                map.put(nums1[m], map.get(nums1[m])==null ? 1 : map.get(nums1[m])+1);
            if(n>=0 )
                map.put(nums2[n], map.get(nums2[n])==null ? 1 : map.get(nums2[n])+1);
            m--;n--;
        }

        int counter=0;
        for(Map.Entry<Integer,Integer> itr : map.entrySet()){
            int val = itr.getValue();
            int key = itr.getKey();
            int count=0;
            while(count<val && counter<nums1.length){
                nums1[counter]=key;
                count++;
                counter++;
            }
            count=0;
        }
        /*
Approach 1: Using TreeMap

Putting elements into TreeMap: In the worst-case scenario, all elements from nums1 and nums2 are distinct. In this case, you'll be inserting m + n elements into the TreeMap. Inserting into a TreeMap has a time complexity of O(log k), where k is the number of elements in the tree. So, inserting m+n elements will take O((m+n)log(m+n)).

Iterating through TreeMap and filling nums1: Iterating through the TreeMap takes O(m+n) time. The inner while loop, in total across all iterations of the outer loop, will execute m+n times as it populates all elements of nums1.

Overall Time Complexity: O((m+n)log(m+n)) due to the TreeMap insertions
         */
    }

    // solution - collections approach
    public static void mergeBetter(int[] nums1, int m, int[] nums2, int n) {
        int max = nums1.length-1;
        int j=0;
        while(max>=0 && j<n){
            if(nums1[max]==0){
                nums1[max]= nums2[j];
                j++;
            }
            max--;
        }
        Arrays.sort(nums1);
        /*
Approach 2: Copying and Sorting

Copying elements: The while loop iterates a maximum of n times in the worst case, copying elements from nums2 to nums1. This takes O(n) time.

Sorting: Arrays.sort() uses a dual-pivot Quicksort algorithm for primitive types in Java, which has an average time complexity of O(N log N), where N is the number of elements to be sorted. In this case, N is m + n.

Overall Time Complexity: O((N)log(m+n)) due to the sorting operation
         */
    }

    // solution - 2 pointer
    public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int nums1Length = m-1;
        int nums2Length = n-1;
        int nums1MaxLength = nums1.length-1;
        while(nums2Length>=0){
            if(nums1Length>=0 && nums1[nums1Length]>nums2[nums2Length]){
                nums1[nums1MaxLength]=nums1[nums1Length];
                nums1MaxLength--;
                nums1Length--;
            }else{
                nums1[nums1MaxLength]=nums2[nums2Length];
                nums1MaxLength--;
                nums2Length--;
            }
        }
        /*
Approach 3: Two Pointers (Optimal Approach)

Single pass: The while loop iterates a maximum of m + n times. In each iteration, there are constant-time operations (comparisons and assignments).

Overall Time Complexity: O(m+n) because it performs a single pass through both arrays.
         */
    }

}
