class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList();
        Map<Character, Integer> map = new HashMap();

        for(int i=0; i<p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int i=0, j=0, count=p.length();

        while(j<s.length()){
            Character c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.getOrDefault(c, 0) - 1);

                if(map.get(c) >=0)
                    count--;
            }
            j++;



            while(count == 0){
                Character ch = s.charAt(i);
                if(map.containsKey(ch)){
                    map.put(ch, map.getOrDefault(ch, 0) + 1);

                    if(map.get(ch) > 0)
                        count++;
                }

                if(j-i==p.length()) list.add(i);

                i++;
            }

        }

        return list;
    }
}
