class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();

        if(s.equals(""))
            return 0;

        int i=0, j=0, count=0;
        int start=0, end = 0;
        int maxL = 0;
        boolean isFound = false;

        while(j<s.length()){
            Character c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) +1);
            if(map.get(c)>1) count++;
            j++;

            while(count>0){
                isFound=true;
                Character ch = s.charAt(i);
                if(map.get(ch) > 1)
                    count--;

                map.put(ch, map.getOrDefault(ch, 0)-1);
                i++;
            }

            maxL = Math.max(maxL, j-i);


        }

        if(isFound)
            return maxL;
        else
            return s.length();
    }
}
