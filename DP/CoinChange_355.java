class Solution {

 public int coinChange(int[] coins, int amount) {
    //return coinChange(0, coins, amount);
     return helper2(coins, amount);
  }


    //Recursive solution
  private int coinChange(int idxCoin, int[] coins, int amount) {
    if (amount == 0)
      return 0;
    if (idxCoin < coins.length && amount > 0) {
      int maxVal = amount/coins[idxCoin];
      int minCost = Integer.MAX_VALUE;
      for (int x = 0; x <= maxVal; x++) {
        if (amount >= x * coins[idxCoin]) {
          int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
          if (res != -1)
            minCost = Math.min(minCost, res + x);
        }
      }
      return (minCost == Integer.MAX_VALUE)? -1: minCost;
    }

    return -1;
  }

    //solution using dp array
    int helper2(int[] coins, int amount){
        int[] dp = new int[amount+1];

        //we can fill with int max but that would lead us to add extra conditions
        //as max can be compared to normal ints
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=0; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);
                }
            }
        }

        //check to see if the initial value ever got updated, if not return -1;
        return dp[amount] > amount ? -1: dp[amount];
    }
}
