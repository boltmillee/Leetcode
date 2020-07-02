class Solution {
    //If we take the elements in the window in decreasing order of their frequency
    // final answer would be correct. Otheriwse there might be issue
    // For eg;
    // [A,A, B, B ......Z, Z]
    // if we take {A,B,C}->{A,B,C}.........{X,Y, }, {X,Y, }
    // whereas if we take {A,B,C} -> {D,E,F}........{X,Y,A},{X,Y,A}
    // we will save 1 unit of time
    public int leastInterval(char[] tasks, int n) {

        if(tasks.length == 0)
            return 0;

        if(n==0)
            return tasks.length;

        int window = 0;

        int totalTasks = tasks.length;

        //int temp[] = new int[26];
        HashMap<Character, Integer> map = new HashMap();

        for(int i=0; i<tasks.length; i++){
            //temp[tasks[i] - 'A'] += 1;
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        HashMap<Character, Integer> sMap = sortByValue(map);

        int result = 0;
        while(totalTasks>0){
            window = 0;
            sMap = sortByValue(sMap);
            for(Character c : sMap.keySet()){

                if(sMap.get(c) > 0){
                    //temp[i]--;
                    sMap.put(c, sMap.get(c) - 1);
                    totalTasks--;
                    window++;
                }

                if(window == n+1 || totalTasks == 0)
                    break;

            }

            if(totalTasks == 0){
                result += window;
                break;
            }

            result += n+1;
        }

        return result;
    }

    //To sort map by value
    public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer> > list =
               new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
