package org.example.dsa.myList.twoPointers;
/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/reverse-string/description/?envType=problem-list-v2&envId=two-pointers
 */
public class ReverseString_344 {
    public static void main(String[] args) {
        char[] input = {'h','e','l','l','o','i'};
        //reverseBrute(input);
        reverseOptimal(input); // MINE - Understood previous bottleneck and corrected
        //reverseMoreOptimal(input);
    }

    // AI
    public static char[] reverseBrute(char[] s) {
        String result = new StringBuilder(new String(s)).reverse().toString();
        for(int i=0; i<result.length();i++){
            s[i]=result.charAt(i);
        }
        return s;
        /*
Description: This approach first creates a new String from the char array, then uses StringBuilder's reverse() method to reverse the string. Finally, it copies the reversed characters back into the original char array.
Time Complexity:
new String(s): O(n) (creating a new String)
new StringBuilder(...): O(n) (creating a StringBuilder)
reverse(): O(n) (reversing the StringBuilder)
toString(): O(n) (creating a new String)
The loop: O(n) (copying back to the char array)
Overall: O(n).
Space Complexity: O(n). It creates new String and StringBuilder objects, each of which can hold up to n characters. This is not an in-place reversal.
         */
    }

    // MINE - 2 pointer
    public static char[] reverseOptimal(char[] s) {

        int left = 0, right = s.length - 1;

        /* PREVIOUS
        We are dividing right / 2 to find mid. So used <= operator to swap unneccarily for odd element, so corrected it below
        int mid = right / 2;
        // unneccearily swapping the middle element for odd number of array, so we can prefer (left<mid) or (left<right)
        //while (left <= mid) {
         */

        // CURRENT
        int mid = s.length / 2;
        while (left < mid) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
        return s;
        /*
Description: This approach uses two pointers, left and right, starting at the beginning and end of the array, respectively. It iterates until left crosses mid (the middle index). In each iteration, it swaps the characters at the left and right indices.
Time Complexity: O(n/2) which simplifies to O(n), where n is the length of the array. Although the loop condition is left <= mid, it still visits roughly half of the elements, making it linear time.
Space Complexity: O(1). It uses only a constant amount of extra space for the temp variable, regardless of the input size. This is an in-place reversal
         */
    }

    // Solution
    public static char[] reverseMoreOptimal(char[] s) {
        // Approach 1
        for (int left = 0, right = s.length - 1; left < s.length / 2; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
        // Approach 2

        return s;
    }
    /*
Description: This is a more concise version of the two-pointer approach using a for loop. It initializes left and right within the loop declaration and continues as long as left is less than half the array's length.
Time Complexity: O(n/2) which simplifies to O(n). It iterates through half the array, performing a constant-time swap in each step.
Space Complexity: O(1). It uses only a constant amount of extra space for the temp variable. This is also an in-place reversal
     */
}
