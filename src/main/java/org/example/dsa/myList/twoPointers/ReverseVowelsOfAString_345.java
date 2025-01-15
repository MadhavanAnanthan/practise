package org.example.dsa.myList.twoPointers;
/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowelsOfAString_345 {
    static boolean appearedVowels(char val){
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        for(char c : vowels){
            if(c == val){
                return true;
            }
        }
        return false;
    }
    public static String reverseVowelsOptimal(String s) {
        int left=0,right=s.length()-1;
        // Previously used StringBuilder, but for defined size. we can use Array
        //StringBuilder sb = new StringBuilder(s);
        char[] chars = s.toCharArray();
        while(left<right){
            while(appearedVowels(chars[left])==false && left<right){
                left++;
            }
            while(appearedVowels(chars[right])==false && left<right){
                right--;
            }
            char temp = chars[left];
            chars[left]= chars[right];
            chars[right]= chars[temp];
                right--;
                left++;
        }
        return new String(chars);
/*
Time Complexity: O(n)
Space Complexity: O(n)
Uses a StringBuilder for in-place modification and two pointers to swap vowels, later changed to Array. But even though for each character its running fixed size to check whether its vowel or consonent.
 */
    }

    public static String reverseVowelsMoreOptimal(String s) {
        boolean[] isVowels = new boolean[128];
        for(char c : "aeiouAEIOU".toCharArray()){
            isVowels[c] = true;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!isVowels[chars[start]]) {
                start++;
                continue;
            }
            if (!isVowels[chars[end]]) {
                end--;
                continue;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
        /*
Time Complexity: O(n)
Space Complexity: O(1)
Uses a boolean array to efficiently check vowels and swaps them using two pointers.
         */
    }

    public static void main(String[] args) {
       // reverseVowelsOptimal("leetcode");
        reverseVowelsMoreOptimal("leetcode");
    }
}
