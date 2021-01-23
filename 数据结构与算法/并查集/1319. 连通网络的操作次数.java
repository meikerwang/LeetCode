// https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n > connections.length + 1){
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        for(int[] conn : connections){
            uf.union(conn[0], conn[1]);
        }
        return uf.count - 1;
    }
}

class UnionFind {
    int[] parent;
    int[] size;
    int n;
    int count;

    public UnionFind(int n){
        this.n = n;
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        int rootX = x;
        while(rootX != parent[rootX]){
            rootX = parent[rootX];
        }
        // 路径压缩
        while(x != parent[x]){
            int tmp = x;
            x = parent[x];
            parent[tmp] = rootX;
        }
        return rootX;
    }

    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return false;
        }
        // 按秩合并
        if(size[rootX] < size[rootY]){
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }else{
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
        count -= 1;
        return true;
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}