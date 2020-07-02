class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet();
        for(int i=1; i<=n; i++)
            ds.makeSet(i);

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            int dataU = ds.findSet(u);
            int dataV = ds.findSet(v);

            if(dataU == dataV){
                int[] arr = new int[2];
                arr[0] = u;
                arr[1] = v;
                return arr;
            } else
                ds.union(dataU, dataV);
        }

        return null;
    }

    class DisjointSet {

    private Map<Integer, Node> map = new HashMap<>();

    class Node {
        int data;
        Node parent;
        int rank;
    }

    /**
     * Create a set with only one element.
     */
    public void makeSet(int data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    /**
     * Combines two sets together to one.
     * Does union by rank
     *
     * @return true if data1 and data2 are in different set before union else false.
     */
    public boolean union(int data1, int data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        //if they are part of same set do nothing
        if (parent1.data == parent2.data) {
            return false;
        }

        //else whoever's rank is higher becomes parent of other
        if (parent1.rank >= parent2.rank) {
            //increment rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }

    /**
     * Finds the representative of this set
     */
    public int findSet(int data) {
        return findSet(map.get(data)).data;
    }

    /**
     * Find the representative recursively and does path
     * compression as well.
     */
    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }
    }
}
