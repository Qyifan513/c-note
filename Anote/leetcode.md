#####八大排序算法
**冒泡排序**
```java
do

  swapped = false

  for i = 1 to indexOfLastUnsortedElement-1

    if leftElement > rightElement

      swap(leftElement, rightElement)

      swapped = true; ++swapCounter

while swapped
```
**选择排序
88
```
repeat (numOfElements - 1) times

  set the first unsorted element as the minimum

  for each of the unsorted elements

    if element < currentMinimum

      set element as new minimum

  swap minimum with first unsorted position
```
**插入排序**
```
mark first element as sorted

for each unsorted element X

  'extract' the element X

  for j = lastSortedIndex down to 0

    if current element j > X

      move sorted element to the right by 1

    break loop and insert X here
```
**快速排序伪代码**
```
PARTITION(A,p,r)
    x = A[r]   //将最后一个元素作为主元素
    i = p-1
    for j=p to r-1     //从第一个元素开始到倒数第二个元素结束，比较确定主元的位置
        do if A[j] <= x
              i = i+1
              exchange A[i] <-> A[j]
    exchange A[i+1]<->A[r]   //最终确定主元的位置
    return i+1   //返回主元的位置
```
```
    QUICKSORT(A,p,r)
     if p<r
        q = PARTITION(A,p,r)    //确定划分位置
        QUICKSORT(A,p,q-1)     //子数组A[p...q-1]
        QUICKSORT(Q,q+1,r)     //子数组A[q+1...r]
```
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

**拓扑排序**
拓扑排序有两种实现：
- 深度优先遍历(比较冷门)；
- 广度优先遍历。
广度优先遍历还可以帮助我们检测有向图是否存在环。

DFS伪代码：
```java
/*
 * Return true if there is a path from cur to target.
 */
boolean DFS(Node cur, Node target, Set<Node> visited) {
    return true if cur is target;
    for (next : each neighbor of cur) {
        if (next is not in visited) {
            add next to visted;
            return true if DFS(next, target, visited) == true;
        }
    }
    return false;
}

/*
 * Return true if there is a path from cur to target.
 */
boolean DFS(int root, int target) {
    Set<Node> visited;
    Stack<Node> s;
    add root to s;
    while (s is not empty) {
        Node cur = the top element in s;
        return true if cur is target;
        for (Node next : the neighbors of cur) {
            if (next is not in visited) {
                add next to s;
                add next to visited;
            }
        }
        remove cur from s;
    }
    return false;
}
```
**单调队列**
单调队列可以解决一些维护一段区间内的最大值或最小值的问题，例如滑动窗口、区间最值等问题。
- 滑动窗口

具体做法如下：
```
例如：
有如下一串数字：1 5 3 4 2
首先第一个数字1先进队列，que = {1}；
之后第二个数字5大于1，则1出队列5进队列，que = {5}；
下一步第三个数字3小于5，进队列，que = {5，3}；
下一步第四个数字4大于3，则3出队列4进队列，que = {5，4}；
下一步第五个数字2小于4，进队列，que = {5，4，2}；
这样最后队列里的数字为单调递减排列。

```
- 区间最值

**树的深度优先遍历**
- 性质 1：二叉树的 前序遍历 序列，根结点一定是 最先 访问到的结点；
- 性质 2：二叉树的 后序遍历 序列，根结点一定是 最后 访问到的结点；
- 性质 3：根结点把二叉树的 中序遍历 序列划分成两个部分，第一部分的所有结点构成了根结点的左子树，第二部分的所有结点构成了根结点的右子树。
**C++ sort()排序详解**
使用sort()方法就可以只需要一条语句就可以实现排序，这样就极大的节省了我们在刷题中所花费的时间。STL中的sort()并非只是普通的快速排序，除了对普通的快速排序进行优化，它还结合了插入排序和堆排序。根据不同的数量级别以及不同情况，能自动选用合适的排序方法。
sort()基本使用方法
sort()函数可以对给定区间所有元素进行排序。
它有三个参数sort(begin, end, cmp)。
begin为指向待sort()的数组的第一个元素的指针。
end为指向待sort()的数组的最后一个元素的下一个位置的指针。
cmp参数为排序准则。不写该参数则默认从小到大进行排序。如果我们需要按照其他的排序准则，那么就需要我们自己定义一个bool类型的函数来传入。
eg.对一个整型数组进行从大到小排序
```c++
#include<iostream>
#include<algorithm>
using namespace std;

int main(){
	int num[10] = {6,5,9,1,2,8,7,3,4,0};
	sort(num,num+10,greater<int>());
	for(int i=0;i<10;i++){
		cout<<num[i]<<" ";
	}//输出结果:9 8 7 6 5 4 3 2 1 0
	
	return 0;
	
} 

```
eg.按照每个数的个位进行从大到小排序
```c++
bool cmp(int x,int y){
	return x % 10 > y % 10;
}
#include<iostream>
#include<algorithm>
using namespace std;

bool cmp(int x,int y){
	return x % 10 > y % 10;
}

int main(){
	int num[10] = {65,59,96,13,21,80,72,33,44,99};
	sort(num,num+10,cmp);
	for(int i=0;i<10;i++){
		cout<<num[i]<<" ";
	}//输出结果：59 99 96 65 44 13 33 72 21 80
	
	return 0;
	
} 

```
```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            
            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}

```
**堆**
- 定义：
完全二叉树：若一棵二叉树==至多只有最下面两层的结点的度数可以小于2==，并且==最下层的结点都集中在该层最左边的若干位置上==，则此二叉树为完全二叉树。
- 堆序性
- 堆的存储：完全二叉树！！ -> 节点下标为i ，左子节点下标为2i + 1，右子节点下标为2i + 2
- 下滤：根破坏堆序，根节点向下移
- 上滤：最后一个叶子节点破坏堆序，叶子节点上移（插入新元素到堆）
- **应用**：小根堆实现优先队列（插入队列，弹出最小元素），弹出：弹出根节点，将最后一个叶子节点放在根的位置，进行下滤；插入：将插入节点插入最后一个叶子节点的位置，上滤。
- 堆排序:将优先队列的元素依次弹出
- 大根堆--正序
- 小根堆--逆序
- 伪代码：

```java
public static void heapSort(int[] arr){
    //初建初始大顶堆
    buildMaxHeap(arr);
    for (int i = arr.length - 1; i > 0; i--) {
        // 将最大值交换到数组最后
        swap(arr, 0, i);
        // 调整剩余数组，使其满足大顶堆
        maxHeapify(arr, 0, i);
    }
}
private static void buildMaxHeap(int[] arr){
    //从最后一个非叶子结点开始调整大顶堆，下标：arr.length/2 - 1
    for(int i = arr.length/2 - 1; i >= 0; i--){
        //调整大顶堆
        maxHeapify(arr, i, arr.length);
    }
    //调整大顶堆，第三个参数表示剩余未排序的数字数量，也就是剩余堆的大小
    private static void maxHeapify(int[] arr, int i, int heapSize){
        int l = 2*i + 1;
        int r = l + 1;
        //记录根结点、左子树结点、右子树结点三者中最大值下标
        int largest = i;
        // 与左子树结点比较
    if (l < heapSize && arr[l] > arr[largest]) {
        largest = l;
    }
    // 与右子树结点比较
    if (r < heapSize && arr[r] > arr[largest]) {
        largest = r;
    }
    if(largest != i){
        //将最大值交换为根结点
        swap(arr, i, largest);
        //
        maxHeapify(arr, largest, heapSize);
    }
    }
    private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
}
```

