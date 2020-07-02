class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
       //return helper(coins, n, amount);
        return helper2(coins, 0, amount);
    }

    int helper(int[] coins, int n, int amount){

        int[] result = new int[amount+1];
        result[0] =1;


        for(int i=0; i<n; i++){
            for(int j=1; j<=amount; j++){
                if(j>=coins[i])
                    result[j] = result[j-coins[i]] + result[j];
            }
        }

        return result[amount];
    }

    //Recursive solution
    int helper2(int[] coins, int index, int amount){

        if(amount == 0)
            return 1;


        if(index >= coins.length || amount < 0)
            return 0;

        int result = helper2(coins, index, amount - coins[index]) + helper2(coins, index+1, amount);

        return result;
    }
}
