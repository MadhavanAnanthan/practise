package org.example.dsa.myList.twoPointers;
/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/reverse-words-in-a-string-iii/description/?envType=problem-list-v2&envId=two-pointers
 */
public class ReverseWordsInAStringIII_557 {
    public static void main(String[] args) {
        reverseOptimal("Let's take LeetCode contest"); // O(n) and O(1)
        //reverseBetter("Let's take LeetCode contest"); // O(n) and O(n)
        //reverseBrute("Let's take LeetCode contest"); // O(n^2) and O(n)
    }

    public static String reverseBrute(String s){
        String[] splittedString = s.split(" "); //O(n)
        for(int i=0;i<splittedString.length;i++){//O(n)
            char[] chars = splittedString[i].toCharArray();
            int left=0,right=chars.length-1;
            while(left<right){
                char temp=chars[left];
                chars[left]=chars[right];
                chars[right]=temp;
                left++;right--;
            }
            splittedString[i]=new String(chars);
        }
        return String.join(" ", splittedString);
/*
(In-place Reversal with Split) is less efficient due to the
 additional overhead of splitting and creating multiple character arrays.
 */
    }

    public static void reverse(char[] chars, int left, int right){
        while(left<right){
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;right--;
        }
    }

    public static String reverseBetter(String s){
        String[] splittedString = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<splittedString.length;i++){
            sb = new StringBuilder(splittedString[i]);
            splittedString[i]=sb.reverse().toString();
        }
        sb=null;
        return String.join(" ", splittedString);
/*
(Using StringBuilder) is a good balance between readability and efficiency.
 */
    }

    public static String reverseOptimal(String s){
        char[] chars = s.toCharArray();
        int start=0,i=0;
        while(i<chars.length){
            if(chars[i]==' '){
                reverse(chars, start, i-1);
                start=i+1;
            }
            i++;
        }
        reverse(chars, start, i-1);
        return new String(chars);
/*
(In-place Reversal) is generally the most
 efficient in terms of both time and space complexity.
 */
    }
}
