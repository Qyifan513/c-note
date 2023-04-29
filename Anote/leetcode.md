**广度优先搜索模板**
```java
/**
 * Return the length of the shortest path between root and target node.
 */
int BFS(Node root, Node target) {
    Queue<Node> queue;  // store all nodes which are waiting to be processed
    int step = 0;       // number of steps neeeded from root to current node
    // initialize
    add root to queue;
    // BFS
    while (queue is not empty) {
        step = step + 1;
        // iterate the nodes which are already in the queue
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            Node cur = the first node in queue;
            return step if cur is target;
            for (Node next : the neighbors of cur) {
                add next to queue;
            }
            remove the first node from queue;
        }
    }
    return -1;          // there is no path from root to target
}
```
**广度优先遍历**用于求解==无权图==的最短路径

```
class Solution {
private:
    vector<int> f;
public:
    int countComponents(int n, vector<vector<int>>& edges) {
        //?
        f.resize(n);
        int m = edges.size(), cnt = 0;
        for(int i = 0; i < n; i++) f[i] = i;
        for(int i = 0; i < m; i++){
            int a, b;
            a = edges[i][0], b = edges[i][1];
            if(find(a) != find(b)){
                cnt++;//合并两个子集，非联通数减一
                f[find(a)] = find(b);
            }
        }
        return n - cnt;
    }
    //并查集
    int find(int x){
        if(x != f[x]) f[x] = find(f[x]);
        return f[x];
    }
};
```