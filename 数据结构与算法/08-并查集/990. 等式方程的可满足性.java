// https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for(String eq: equations){
            int s1 = eq.charAt(0) - 'a';
            int s2 = eq.charAt(3) - 'a';
            if(eq.charAt(1) == '='){
                uf.union(s1, s2);
            }
        }
        for(String eq: equations){
            int s1 = eq.charAt(0) - 'a';
            int s2 = eq.charAt(3) - 'a';
            if(eq.charAt(1) == '!' && uf.connected(s1, s2)){
                return false;
            }
        }
        return true;
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

    public int findRoot(int x){
        while(x != parent[x]){
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y){
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        if(rootX == rootY){
            return;
        }
        if(size[rootX] < size[rootY]){
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
        else{
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
        this.count--;
    }

    public boolean connected(int x, int y){
        return findRoot(x) == findRoot(y);
    }
}