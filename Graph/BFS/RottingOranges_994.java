class Solution {

    public int orangesRotting(int[][] grid) {
       Queue<Location> q = new LinkedList();
        int oneCount=0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2)
                    q.add(new Location(i, j));
                else if(grid[i][j] == 1)
                    oneCount++;
            }
        }

        q.add(null);
        int count = 0;
        while(q.size()>0){
            Location l = q.poll();

            if(l == null){
                if(q.size() == 0)
                    break;

                count++;
                q.add(null);
                continue;
            }

            grid[l.i][l.j] = 2;


            if(l.j-1>=0 && grid[l.i][l.j-1] == 1){
                q.add(new Location(l.i, l.j-1));
                grid[l.i][l.j-1]=2;
                oneCount--;
            }


            if(l.j+1<=grid[0].length-1 && grid[l.i][l.j+1] == 1){
                q.add(new Location(l.i, l.j+1));
                grid[l.i][l.j+1]=2;
                oneCount--;
            }


            if(l.i-1>=0 && grid[l.i-1][l.j] == 1){
                q.add(new Location(l.i-1, l.j));
                grid[l.i-1][l.j]=2;
                oneCount--;
            }


            if(l.i+1 <=grid.length-1 && grid[l.i+1][l.j] == 1){
                q.add(new Location(l.i+1, l.j));
                grid[l.i+1][l.j]=2;
                oneCount--;
            }

        }

        // for(int i=0; i<grid.length; i++){
        //     for(int j=0; j<grid[0].length; j++){
        //         if(grid[i][j] == 1)
        //             return -1;
        //     }
        // }

        if(oneCount == 0)
            return count;
        else
            return -1;
    }

    class Location{
        Integer i;
        Integer j;

        Location(Integer i, Integer j){
            this.i = i;
            this.j = j;
        }

        @Override
    public String toString() {
        return String.format("[" + i + "," + j+"]");
    }
    }
}
