class Solution {
    public boolean canReach(int[] arr, int start) {

        if(arr[start] == 0)
            return true;

        boolean[] visited = new boolean[arr.length];

        Queue<Integer> q = new LinkedList();
        q.add(start);

        while(!q.isEmpty()){
            Integer val = q.poll();

            if(arr[val] == 0)
                return true;

            if(visited[val])
                continue;
            else
                visited[val] = true;

            if(val+arr[val] < arr.length)
                q.add(val+arr[val]);

            if(val- arr[val] >=0)
                q.add(val-arr[val]);

        }

       return false;
    }
}
