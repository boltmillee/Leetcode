class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet();
        int count =0;
        for(int i=0; i<n; i++)
            ds.makeSet(i);

        for(int i=0; i<connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];

            int d1 = ds.findSet(u);
            int d2 = ds.findSet(v);

            if(d1 == d2){
                count++;
            } else{
                ds.union(d1, d2);
            }
        }

        Set<Integer> set = new HashSet();
        for(int i=0; i<n; i++)
            set.add(ds.findSet(i));

        if(count >= set.size()-1)
            return set.size()-1;
        else
            return -1;
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
