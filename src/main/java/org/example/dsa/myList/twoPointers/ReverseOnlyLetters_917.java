package org.example.dsa.myList.twoPointers;

/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/reverse-only-letters/description/
 */
public class ReverseOnlyLetters_917 {
    public static String reverseOnlyLettersBrute(String s) {
        StringBuilder ss= new StringBuilder(s.replaceAll("[^a-zA-Z]","")).reverse();
        for(int i=0;i<=s.length()-1;i++)
            if(!Character.isLetter(s.charAt(i)))
                ss.insert(i,s.charAt(i));
        return String.valueOf(ss);
/*
Time Complexity	- O(n*m) (≈ O(n^2) worst case)
Space Complexity - O(m)
Bottlenecks	- StringBuilder insertions, regex
 */
    }
    public static String reverseOnlyLettersOptimal(String s) {
        int left=0, right=s.length()-1;
        char[] chars = s.toCharArray();
        while(left<right){
            if(!(Character.toLowerCase(chars[left])>96 && Character.toLowerCase(chars[left])<123)){
                left++;
                continue;
            }
            if(!(Character.toLowerCase(chars[right]) > 96 && Character.toLowerCase(chars[right])<123)){
                right--;
                continue;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;right--;
        }
        return new String(chars);
/*
Time Complexity	- O(n)
Space Complexity - O(n)
Bottlenecks	- Array creation/copying (minor)
 */
    }
    public static void main(String[] args) {
        //reverseOnlyLettersBrute("Test1ng-Leet=code-Q!");
        reverseOnlyLettersOptimal("Test1ng-Leet=code-Q!");
    }
}
