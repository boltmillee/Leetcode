class Solution {
    List<Integer> list = new ArrayList();
    public int shortestPathBinaryMatrix(int[][] grid) {
        int p = grid.length;
        int [][] visited = new int[p][p];
        //visited[0][0] = 1;
//         dfs(0, 0, grid, 0, visited);
//         Collections.sort(list);
//         System.out.print(list);

//         if(list.isEmpty())
//             return -1;
//         else
//             return list.get(0);
        Queue<Location> q = new LinkedList();
        int count=0;
        if(grid[0][0] == 0){
            count++;
            q.add(new Location(0,0));
        }

        while(!q.isEmpty()){

            int n = q.size();

            for(int k=0; k<n; k++){
                Location loc = q.poll();
                int i = loc.i;
                int j = loc.j;

                if(i<0 || i>=grid.length || j<0 || j>=grid.length)
                    continue;

                if(i == grid.length-1 && j == grid.length-1 && grid[i][j] == 0)
                    return count;

                if(grid[i][j] == 0 && visited[i][j] == 0){
                    visited[i][j] = 1;
                } else{
                    visited[i][j] = 1;
                    continue;
                }

                q.add(new Location(i-1, j));
                q.add(new Location(i+1, j));
                q.add(new Location(i, j-1));
                q.add(new Location(i, j+1));
                q.add(new Location(i-1, j-1));
                q.add(new Location(i-1, j+1));
                q.add(new Location(i+1, j-1));
                q.add(new Location(i+1, j+1));

            }

            count++;
        }

        return -1;

    }

//     public void dfs(int i, int j, int[][] grid, int sum, int [][] visited){

//         if(i < 0 || i >= grid.length || j < 0 || j >= grid.length)
//             return;

//         if(visited[i][j] == 1)
//             return;

//         if(i == grid.length-1 && j == grid.length-1 && grid[i][j] == 0){

//             list.add(sum);
//             return;
//         }

//         if(grid[i][j] == 0)
//             visited[i][j] = 1;
//         else
//             return;

//         dfs(i-1, j, grid, sum +1, visited);
//         dfs(i+1, j, grid, sum +1, visited);
//         dfs(i, j-1, grid, sum +1, visited);
//         dfs(i, j+1, grid, sum +1, visited);
//         dfs(i-1, j-1, grid, sum +1, visited);
//         dfs(i-1, j+1, grid, sum +1, visited);
//         dfs(i+1, j-1, grid, sum +1, visited);
//         dfs(i+1, j+1, grid, sum +1, visited);

//     }

    class Location{
        int i;
        int j;

        Location(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
