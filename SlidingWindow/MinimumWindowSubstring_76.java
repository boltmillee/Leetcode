class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap();
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) +1);
        }

        int i=0, j=0, count=t.length();
        int start=0, end = 0;
        int minL = s.length();
        boolean isFound = false;
        while(j<s.length()){
            Character c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) >=0)
                    count--;

                while(count == 0 && i<=j){

                    if(j-i+1<=minL){
                        minL = j-i+1;
                        start = i;
                        end =j;
                        isFound = true;
                    }

                    Character ch = s.charAt(i);
                    if(map.containsKey(ch)){
                        map.put(ch, map.getOrDefault(ch, 0) + 1);
                        if(map.get(ch)>=1)
                            count++;
                    }
                    i++;
                }
            }

            j++;
        }
        if(isFound)
            return s.substring(start, end+1);
        else
            return "";
    }
}
