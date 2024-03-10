class Solution {
    public int maxProfit(int[] prices) {
        int buy_price=prices[0];
        int max_profit=0;

        for(int i=1;i<prices.length;i++){
           if(buy_price>prices[i]){
               buy_price=prices[i];
           }
           else{
               int cur=prices[i]-buy_price;
               max_profit=Math.max(cur,max_profit);
           }
        }

        return max_profit;
 }
}
