package org.example.dsa.arrays.medium;
/*
 * @author Madhavan Ananthan
 * Ref : https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0?category&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=max-sum-in-sub-arrays
 */
/*
I Solved using better approach O(n square).

But in optimal, its adding only adjacent of 2 elements. The approach is about,\
 adding adjacent element should be higher, we comapre the possible sub-arrays minimum and second minimum value.
 So comparing adjacent value is more than enough to find the maximum value.
If we want to find the maximum number (using minimum and second minimum) of continous
 array- we can use this adjacent element approach.
 */
public class MaximumScoreFromSubarrayMinimums_GFG {
    public static void main(String[] args) {
        int[] arr={4, 3, 1, 5, 6};
        // MINE
        //pairWithMaxSumBrute(arr); // 0(n square) and 0(1)
        pairWithMaxSumOptimal(arr); // 0(n) and 0(1)
    }

    // adding only adjacent elements
    public  static int pairWithMaxSumOptimal(int arr[]) {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++){
            int smallest = arr[i];
            int secondSmallest=arr[i+1];
            maxi=((smallest+secondSmallest)>maxi)?(smallest+secondSmallest):maxi;
        }
        return maxi;
    }

    public static int pairWithMaxSumBrute(int arr[]) {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<=arr.length-2;i++){
            int smallest = arr[i];
            int secondSmallest=arr[i+1];
            for(int j=i+1;j<=arr.length-1;j++){
                if(arr[j]<smallest){
                    secondSmallest=smallest;
                    smallest=arr[j];
                }else if(arr[j]<secondSmallest){
                    secondSmallest=arr[j];
                }
                maxi=((smallest+secondSmallest)>maxi)?(smallest+secondSmallest):maxi;
            }
        }
        return maxi;
    }
}
