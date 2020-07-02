class Solution {
    //Map<Integer, Integer> dp = new HashMap();
    public int minimumTotal(List<List<Integer>> triangle) {
        //return helper(triangle, 0, 0, 0);
        return helper2(triangle);
    }

    //Recursive solution
    int helper(List<List<Integer>> triangle, int level, int left, int right){

        if(level >= triangle.size())
            return 0;

        int sum=Integer.MAX_VALUE;
        for(int i=left; i<=right; i++){
            int temp = helper(triangle, level+1, i, i+1);
            sum = Math.min(sum, triangle.get(level).get(i) + temp);

        }

        return sum;
    }

    //Matrix needs to be filled in bottom up manner
    int helper2(List<List<Integer>> triangle){
        int n = triangle.size();
        int[] dp = new int[n+1];

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<triangle.get(i).size(); j++){

                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}
