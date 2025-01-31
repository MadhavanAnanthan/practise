package org.example.dsa.myList.string;

import java.util.HashMap;
import java.util.Map;
/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/?envType=problem-list-v2&envId=string
 */
public class CheckAllOccAreEqual_1941 {
    public static void main(String[] args) {
        String s = "abacbc";
        areOccurancesEqualBrute(s);     // 0(n square) and 0(n)
        areOccurancesEqualBetter(s);   // 0(n) and 0(n)
        areOccurancesEqualOptimal(s); // 0(n) and 0(n)
    }
    public static boolean areOccurancesEqualOptimal(String s){
        int[] hash = new int[123];
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length;i++){
            int no = chars[i];
            hash[no]=hash[no]+1;
        }
        int max=0;
        for(int n : hash){
            if(n>0){
                if(max==0){
                    max=Math.max(n, max);
                }else if(max!=n){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean areOccurancesEqualBetter(String s){
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:chars){
            map.put(c, map.get(c)==null ? 1 : map.get(c)+1);
        }
        int prevVal=0;boolean first=true;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(first){
                prevVal=entry.getValue();
                first=false;
            }else if(prevVal!=entry.getValue()){
                return false;
            }
        }
        return true;
    }
    public static boolean areOccurancesEqualBrute(String s){
        char[] chars = s.toCharArray();
        int maxOcc=0;int count=0;
        for(int i=0;i<chars.length;i++){
            for(int j=0;j<chars.length;j++){
                if(chars[i]==chars[j]){
                    count++;
                }
            }
            if(maxOcc==0)
                maxOcc=count;
            else if(maxOcc!=count)
                return false;

            count=0;
        }
        return true;
    }
}
