class Solution {
    public String longestPalindrome(String s) {

        if(s.length() == 0 || s== null)
            return "";

        int start = 0;
        int end = 0;

        for(int i=0; i<s.length(); i++){
            int l1 = helper(s, i, i);
            int l2 = helper(s, i, i+1);

            int len = Math.max(l1, l2);

            if(len > end - start){
               start = i - ((len-1)/2);
                end = i + ((len)/2);
            }

        }

        return s.substring(start, end+1);
    }


    //Iterative
    int helper(String s, int l, int r){

        if(s== null || l>r)
            return 0;

        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        return r-l-1;
    }
}
