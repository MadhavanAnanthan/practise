package org.example.dsa.arrays.medium;

// Not able to solve this problem
public class BestTimeToBuyAndSellStock_3_2_6 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        bruteForce(prices); // O(N square) and O(1)
        optimal(prices); // O(N) and O(1)
        mine_notWorking(prices); // O(N) and O(1)
    }

    // O(N square) and O(1)
    static int bruteForce(int[] prices){
        int minPrice=0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length;j++){
                if(prices[j]>prices[i]){
                    minPrice=Math.max(minPrice, prices[j]-prices[i]);
                }
            }
        }
        return minPrice;
    }

    // O(N) and O(1)
    static int optimal(int[] prices){
        int min=Integer.MAX_VALUE;;
        int max=0;
        for(int i=0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]-min);
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
