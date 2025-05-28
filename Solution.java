import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length;
        int m = edges2.length;
        int[] count1 = getCounts(edges1, k);
        int[] count2 = getCounts(edges2, k-1);
        int max = 0;
        for(int cc: count2) max = Math.max(max, cc);

        int[] res = new int[n+1];
        for(int i=0;i<=n;i++){
            res[i] = count1[i]+max;
        }

        return res;
    }

    public int[] getCounts(int[][] edges, int k){
        int n = edges.length;
        int[] arr = new int[n+1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++) list.add(new ArrayList<>());
        for(int[] edge: edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<=n;i++){
            arr[i] += bfs(list, k, i);
        }
        // for(int count: arr) System.out.print(count + " ");
        // System.out.println();
        return arr;
    }


    public int bfs(ArrayList<ArrayList<Integer>> list, int k, int source){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[list.size()];
        q.add(source);
        visited[source] = true;
        while(!q.isEmpty() && k>=0){
            int width = q.size();
            k--;
            for(int i=0;i<width;i++){
                int src = q.poll();
                visited[src] = true;
                count++;
                for(int neigh: list.get(src)){
                    if(!visited[neigh])
                        q.add(neigh);
                }
            }
        }
        return count;
    }
}