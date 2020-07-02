class Solution {
    public boolean isBipartite(int[][] graph) {

        for(int z=0; z<graph.length; z++){

            Map<Integer, Character> map = new HashMap();
        Set<Integer> set = new HashSet();
        map.put(z, 'R');
        Queue<Integer> q = new LinkedList();
        q.add(z);
        while(!q.isEmpty()){

            Integer s = q.poll();

            if(set.contains(s))
                continue;
            else
                set.add(s);

            Character sColor = map.get(s);
            Character cColor = null;
            if(sColor == 'R')
                cColor = 'G';
            else
                cColor = 'R';

            for(int j=0; j<graph[s].length; j++){

                Integer c = graph[s][j];

                if(map.get(c) == null)
                    map.put(c, cColor);
                else{
                    Character mC = map.get(c);
                    if(mC == sColor)
                        return false;
                }

                if(set.contains(c))
                    continue;


                q.add(c);
            }
        }
        }


        return true;
    }

}
