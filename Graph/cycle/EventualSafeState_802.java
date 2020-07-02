// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {

//         boolean[] visited = new boolean[graph.length];
//         List<Integer> list = new ArrayList();
//         for(int i=0; i<graph.length; i++){
//             if(dfs(i, graph, visited)){
//                 list.add(i);
//             }
//         }

//         return list;
//     }

//     public boolean dfs(int start, int[][] graph, boolean[] visited){

//        if(visited[start])
//            return false;
//         else
//             visited[start] = true;


//         for(int i=0; i<graph[start].length; i++){
//             if(!dfs(graph[start][i], graph, visited))
//                 return false;
//         }

//         visited[start] = false;

//         return true;
//     }
// }
//BELOW MENTIONED SOLUTION IS OPTIMIZED TO NOT LOOK FOR THE CHILDREN OF NODES WHICH ARE
//ALREADY OUT OF DANGER( WHICH ARE ALREADY TESTED TO BE NOT A PART OF CYCLE)
//
//WHITE - not yet visited
//GRAY - is not out of danger
//BLACK - out of danger


class Solution {

    enum Color{
        White, Grey, Black;
    }

    public List<Integer> eventualSafeNodes(int[][] a) {
        List<Integer> res = new ArrayList<>();
        if(a.length==0) return res;

        Color[] color = new Color[a.length];
        Arrays.fill(color, Color.White);

        for(int i=0;i<a.length;i++){
            if(!dfsHasCycle(i, a, color)) res.add(i);
        }

        return res;
    }

    boolean dfsHasCycle(int cur, int[][] a, Color[] color){
        color[cur]=Color.Grey;

        for(int child : a[cur]){
            if(color[child]==Color.Grey) return true;
            if(color[child]==Color.White && dfsHasCycle(child, a, color)) return true;
        }

        color[cur]=Color.Black;
        return false;
    }
}
