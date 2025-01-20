package org.example.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders_GFG {
    public static void main(String[] args) {
        int[] arr={16, 17, 4, 3, 5, 2};
        leadersBrute(arr); // O(n square) and O(n)
        leadersOptimal(arr); // O(n) and O(n)
    }
    public static ArrayList<Integer> leadersOptimal(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxi = Integer.MIN_VALUE, maxiBackup =Integer.MIN_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>=maxi){
                result.add(arr[i]);
                maxi=arr[i];
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static ArrayList<Integer> leadersBrute(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<=arr.length-2;i++){
            for(int j=i+1; j<=arr.length-1;j++){
                if(arr[i]<arr[j]){
                    break;
                }else if(j==arr.length-1){
                    result.add(arr[i]);
                }
            }
            if(i==arr.length-2){
                result.add(arr[arr.length-1]);
            }
        }
        return result;
    }
}
