class Solution {
    public int closedIsland(int[][] grid) {
        int count =0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j< grid[0].length; j++){

                if(grid[i][j] == 0 && dfs(i, j, grid))
                    count++;
            }
        }

        return count;
    }

    public boolean dfs(int i, int j, int[][] grid){

        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
            return false;

        if((i==0 || i==grid.length || j==0 || j==grid[0].length) && grid[i][j] == 0)
            return false;

        if(grid[i][j] == 0)
            grid[i][j] = 1;
        else
            return true;

        boolean top = dfs(i-1, j, grid);
        boolean down = dfs(i+1, j, grid);
        boolean left = dfs(i, j-1, grid);
        boolean right = dfs(i, j+1, grid);

        return (top && down && left && right);
    }
}
