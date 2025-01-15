package org.example.dsa.myList.twoPointers;

import java.util.stream.IntStream;

/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/?envType=problem-list-v2&envId=two-pointers
 */
public class IsPrefixOfWord_1455 {
    public static void main(String[] args) {
        isPrefixOfWordOptimal2("this problem is an easy problem", "pro");
    }

    public static int isPrefixOfWordOptimal(String sentence, String searchWord){
        String[] sentences = sentence.split(" ");
        for(int i=0;i<sentences.length;i++)
            if(sentences[i].startsWith(searchWord))
                return i+1;
        return -1;
/*
Time Complexity:

sentence.split(" "): O(n).
The for loop iterates at most m times.
startsWith(): O(k).
Overall time complexity: O(n + m*k), which simplifies to O(n*k).

Bottleneck:

This approach is more concise and generally more efficient than the previous two because startsWith() is usually optimized in the String class implementation.
 */
    }

    public static int isPrefixOfWordOptimal2(String sentence, String searchWord){
        String s[]=sentence.split(" ");
        for(int i=0;i<s.length;i++)
        {
            if(s[i].indexOf(searchWord)==0)
                return (i+1);
        }
        return -1;
/*
Time Complexity:

sentence.split(" "): O(n).
The for loop iterates at most m times.
indexOf(searchWord): In the worst case, indexOf has a time complexity of O(l*k), where l is the length of the string being searched (the current word) and k is the length of the search word. However, since we're only checking if the index is 0, we can consider the effective time complexity to be closer to O(k) in this specific usage.
Overall time complexity: O(n + m*k), which simplifies to O(n*k).

Bottleneck:

While usually efficient, indexOf can have a worst-case scenario where it behaves like a naive string search. However, when used to check for a prefix (index 0), its performance is generally comparable to startsWith().
 */
    }

    public static int isPrefixOfWordBetter(String sentence, String searchWord) {
        String[] str = sentence.trim().split("\\s+");
        for(int i = 0; i < str.length; i ++){
            if(searchWordInWords(str[i], searchWord))
                return i + 1;
        }
        return -1;
/*
Time Complexity:

sentence.trim().split("\\s+"): O(n), where n is the length of the sentence.
The for loop iterates at most m times (number of words).
searchWordInWords(): This function iterates at most k times (length of searchWord).
Overall time complexity: O(n + m*k). Similar to Approach 1, this can be simplified to O(n*k).

Bottleneck:

The searchWordInWords() function is slightly less efficient than using startsWith() directly because it involves manual character comparisons.
 */
    }

    public static int isPrefixOfWordBrute(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        return IntStream.range(0, words.length).filter(index -> words[index].startsWith(searchWord)).map(filteredIndex -> filteredIndex +1 ).findFirst().orElse(-1);
/*
Time Complexity:

sentence.split(" "): O(n), where n is the length of the sentence.
IntStream.range(...): Creates a stream of integers, O(m), where m is the number of words in the sentence.
filter(...): Iterates through the stream and performs startsWith() for each word. startsWith() is O(k) where k is the length of searchWord. In the worst case, this filter operation becomes O(m*k).
map(...): O(m)
findFirst(): O(m) in the worst case (if the prefix is at the end or not present).
Overall time complexity: O(n + m*k). If we consider that m (number of words) is generally proportional to n (sentence length), the time complexity can be simplified to O(n*k) in the worst case.

Bottleneck:

The use of streams adds some overhead. While streams can be efficient for certain operations, in this case, the combination of filter, map, and findFirst doesn't offer a significant performance advantage and might even be slightly slower than a simple loop.
 */
    }

    public static boolean searchWordInWords(String word, String searchWord){
        int i = 0;
        int j = 0;

        if(word.length() < searchWord.length()) return false;

        while(i < word.length() && j < searchWord.length()){
            if(searchWord.charAt(j) != word.charAt(i))
                return false;
            i ++;
            j ++;
        }
        return true;
    }
}
