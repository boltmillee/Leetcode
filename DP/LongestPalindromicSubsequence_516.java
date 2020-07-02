class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            dp[i][i] = 1;
        }

        // Variable i is the length of the word under consideration
        // j is start index
        // k is the end index
        for(int i=1; i<n; i++){
            for(int j=0; j<n-i; j++){
                int k = j+i;

                if(s.charAt(j) == s.charAt(k))
                    dp[j][k] = 2 + dp[j+1][k-1];
                else
                    dp[j][k] =  Math.max(dp[j+1][k], dp[j][k-1]);
            }
        }

        return dp[0][n-1];
    }
}
