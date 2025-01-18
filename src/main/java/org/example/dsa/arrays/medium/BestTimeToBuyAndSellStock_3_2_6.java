package org.example.dsa.arrays.medium;
/*
 * @author Madhavan Ananthan
 * Ref : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
// Not able to solve this problem even on 2 times
/*
we need to understand the problem, we have to buy a stock on lowest
price day and sell the stocks in highest price day and book the
max profit.

which means whenever min value is occured, we needs to update the
 minimum value at the same time, we need to check the profit amount
  and store the max profit amount.
 */

// TODO -check optimal function for more understanding
public class BestTimeToBuyAndSellStock_3_2_6 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        bruteForce(prices); // O(N square) and O(1)
        optimal(prices); // O(N) and O(1)
        mine_notWorking(prices); // O(N) and O(1)
    }

    // O(N square) and O(1)
    static int bruteForce(int[] prices){
        int profit=0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length;j++){
                if(prices[j]>prices[i]){
                    profit=Math.max(profit, prices[j]-prices[i]);
                }
            }
        }
        return profit;
    }

    // O(N) and O(1)
    static int optimal(int[] prices){
        int min=Integer.MAX_VALUE;;
        int max=0;
        for(int i=0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        // or
        for(int i=0; i<prices.length; i++){
            // If the currentDayPrice is less than previous lowest price ?
            // update lowest price
            if(prices[i]<min){
                min=prices[i];
            }
            // if the current price is greater than minimum price ?
            // then check the profit
            else{
                max = Math.max(max, prices[i]-min);
            }
        }
        return max;
    }

    private static int mine_notWorking(int[] prices) {
        int lowestPriceDay = 0;
        int highestPriceDay=0;
        for(int i=1; i<prices.length; i++){
            if(!(lowestPriceDay<highestPriceDay && i==prices.length-1) && prices[highestPriceDay] > prices[i]){
                if(prices[i] > prices[highestPriceDay]  ){
                    highestPriceDay = i;
                }else if(prices[i] < prices[lowestPriceDay]){
                    lowestPriceDay = i;highestPriceDay = i;
                }
            }
        }
        if(lowestPriceDay<highestPriceDay){
            return prices[highestPriceDay]-prices[lowestPriceDay];
        }else{
            return 0;
        }
    }
}
