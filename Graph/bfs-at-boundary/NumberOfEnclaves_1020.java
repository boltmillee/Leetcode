class Solution {
    public int numEnclaves(int[][] A) {
        int count = 0;
        int n = A.length;
        int m = A[0].length;


        //for 1st row
        for(int j=0; j< m; j++){
            if(A[0][j] == 1){
                bfs(A, 0, j);
            }
        }

        //for last row
        for(int j=0; j< m; j++){
            if(A[n-1][j] == 1){
                bfs(A, n-1, j);
            }
        }

        //for first column
        for(int i=0; i< n; i++){
            if(A[i][0] == 1){
                bfs(A, i, 0);
            }
        }

        //for last column
        for(int i=0; i< n; i++){
            if(A[i][m-1] == 1){
                bfs(A, i, m-1);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(A[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

    public void bfs(int[][] board, int i, int j){
        Queue<Position> q = new LinkedList();
        Position p = new Position(i, j);
        board[i][j]=0;
        q.add(p);

        while(!q.isEmpty()){
            Position po = q.poll();
            int x = po.i;
            int y = po.j;

            if(y-1 >= 0 && board[x][y-1]==1){
                board[x][y-1] = 0;
                q.add(new Position(x, y-1));
            }


            if(y+1 <board[0].length && board[x][y+1] == 1){
                board[x][y+1] = 0;
                q.add(new Position(x, y+1));
            }


            if(x-1>=0 && board[x-1][y] == 1){
                board[x-1][y]=0;
                q.add(new Position(x-1, y));
            }


            if(x+1<board.length && board[x+1][y] == 1){
                board[x+1][y]=0;
                q.add(new Position(x+1, y));
            }
        }
    }

    class Position{
        int i;
        int j;

        Position(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

}
