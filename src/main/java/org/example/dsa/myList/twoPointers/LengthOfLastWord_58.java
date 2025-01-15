package org.example.dsa.myList.twoPointers;

/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/length-of-last-word/description/
 */
public class LengthOfLastWord_58 {

    // Mine
    public static int lengthOfLastWordBrute(String s) {
        String[] splittedSourceString = s.split(""); // Splits into individual characters into String - this is the bottlenect (require more space)
        int endIndex = 0;
        for (int i = splittedSourceString.length - 1; i >= 0; i--) {
            if (!splittedSourceString[i].equals(" ")) {
                endIndex = i;
                break;
            }
        }
        if (endIndex == 0) {
            return 1;
        }
        int startIndex = 0;
        for (int i = endIndex; i >= 0; i--) {
            if (splittedSourceString[i].equals(" ")) {
                startIndex = i + 1;
                break;
            }
        }
        return (endIndex - startIndex) + 1;
        /*
        s.split(""): This is the most significant performance bottleneck. Splitting a string into an array of individual characters creates a new array of size n, and each element is a string of length 1. This operation, especially in Java, can be quite costly and is generally O(n).
        The two for loops iterate at most n times each
         */
    }

    // Optimal
    public static int lengthOfLastWordOptimal(String s) {
        int endIndex = s.length()-1;
        while(endIndex>=0 && s.charAt(endIndex)==' '){
            endIndex--;
        }
        int startIndex = endIndex; // Important: Initialize startIndex to endIndex
        while(startIndex>=0 && s.charAt(startIndex)!=' '){
            startIndex--;
        }
        return endIndex-startIndex;
        /*
        The first while loop iterates at most n times (where n is the length of the string) to find the end of the last word.
        The second while loop also iterates at most n times to find the beginning of the last word
         */
    }

    // better
    public static int lengthOfLastWordBetter(String s) {
        // splitting each word into a separate string
        String[] words4 = s.trim().split("\\s+");
        // it will be splitted like this - ["fly","me","to","the","moon"]
        // taking last word using its index
        return words4[words4.length - 1].length();
        /*
        s.trim(): Trimming leading/trailing whitespace takes O(n) in the worst case, where n is the length of the string.
        s.split("\\s+"): Splitting the string using a regular expression has a time complexity that can vary depending on the implementation. In the worst-case scenario where there are many delimiters, it can approach O(n), but in the average case and given the use of \s+ which handles multiple spaces, it's often more efficient. Let's consider it O(n) for simplicity in the worst case.
        words4[words4.length - 1].length(): Accessing the last element of the array and getting its length is O(1).
         */
    }

    public static void main(String[] args) {
        lengthOfLastWordBrute("   fly me   to   the moon  ");
        lengthOfLastWordBetter("   fly me   to   the moon  ");
        lengthOfLastWordOptimal("   fly me   to   the moon  ");
    }
}
