class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //i->j
        //int[][] arr = new int[n][n];

        ArrayList[] adj = new ArrayList[n];

        for(int i=0; i<adj.length; i++){
            adj[i] = new ArrayList();
        }
        int time = 0;
        for(int i=0; i<manager.length; i++){
            int emp = i;
            int mgr = manager[i];

             if(manager[i] == -1)
                continue;

            adj[mgr].add(emp);



            //arr[mgr][emp] = 1;


        }

        return dfs(headID, 0, informTime, adj);


//         //int time = informTime[headID];
//         Queue<Integer> q = new LinkedList();
//         q.add(headID);

//         while(!q.isEmpty()){
//             int size = q.size();
//             int maxCount=0;
//             for(int i=0; i<size; i++){

//                 int u = q.poll();

//                 if(informTime[u] > maxCount)
//                         maxCount = informTime[u];
//                 for(int k=0; k< n; k++){
//                     if(arr[u][k] == 1){
//                         q.add(k);
//                     }
//                 }

//             }
//             time += maxCount;
//         }

//         return time;
    }

    public int dfs(int manager, int sum, int[] informTime, ArrayList[] adj){

        List<Integer> list = adj[manager];
        //int[] child = arr[manager];


        int maxSum = 0;
        for(int i=0; i<list.size(); i++){

                int temp = dfs(list.get(i), sum + informTime[manager], informTime, adj);
                if(temp > maxSum)
                    maxSum = temp;


        }

        if(maxSum != 0)
            sum = maxSum;

        return sum;
    }
}
