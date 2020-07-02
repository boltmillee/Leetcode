class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {

        ArrayList[] blue = new ArrayList[n];
        ArrayList[] red = new ArrayList[n];
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            blue[i] = new ArrayList();
        }

        for(int i=0; i<blue_edges.length; i++){
            int u = blue_edges[i][0];
            int v = blue_edges[i][1];
            // if(u == v)
            //     result[i] = 1;

            blue[u].add(v);
        }

        for(int i=0; i<n; i++){
            red[i] = new ArrayList();
        }

        for(int i=0; i<red_edges.length; i++){
            int u = red_edges[i][0];
            int v = red_edges[i][1];
            // if(u == v)
            //     result[i] = 1;

            red[u].add(v);
        }


        for(int i=1; i<n; i++){

            // if(result[i] == 1)
            //     continue;

            int bpath = bfs(i, true, red, blue);
            int rpath = bfs(i, false, red, blue);

            if(bpath > 0 && rpath > 0){
                result[i] = Math.min(bpath, rpath);
            } else if(bpath < 0)
                result[i] = rpath;
            else if(rpath < 0)
                result[i] = bpath;
            else
                result[i] = -1;

        }

        return result;
    }

    int bfs(int end, boolean flag, ArrayList[] red, ArrayList[] blue){

        Queue<Integer> q = new LinkedList();
        Set<String> visited = new HashSet();
        int length = 1;
        q.add(0);
        boolean isBlue = flag;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                Integer element = q.poll();

                if(isBlue)
                    visited.add(element+"BLUE");
                else
                     visited.add(element+"RED");

                if(isBlue){
                    List<Integer> blueList = blue[element];

                    for(Integer bl : blueList){

                        if(bl == end)
                            return length;

                        if(!visited.contains(bl+"RED"))
                            q.add(bl);
                    }

                } else{
                    List<Integer> redList = red[element];

                    for(Integer rl : redList){
                        if(rl == end)
                            return length;

                        if(!visited.contains(rl+"BLUE"))
                            q.add(rl);
                    }
                }
            }

            length++;
            isBlue = !isBlue;
        }

        return -1;
    }
}
