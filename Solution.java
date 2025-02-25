import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;



 // Definition for a binary tree node.
 // Definition for a binary tree node.
 class Solution {
    boolean helper(List<Integer>[] adjList, int bob, int[] bobVisit, int cost){
       
        if(bobVisit[bob] != -1  ) return false;
        bobVisit[bob] = cost;
        if(bob == 0) return true;
        for(int itr : adjList[bob]){
            if(bobVisit[itr] == -1 && helper(adjList, itr, bobVisit, cost+1)) return true;
        }
        bobVisit[bob] = -2;
        return false;
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] adjList = new List[n];
        for(int i=0; i<edges.length; i++){
            if(adjList[edges[i][0]] == null ) adjList[edges[i][0]] = new ArrayList<>();
            if(adjList[edges[i][1]] == null ) adjList[edges[i][1]] = new ArrayList<>();
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        int[] bobVisit = new int[n];
        Arrays.fill(bobVisit, -1);
        helper(adjList, bob, bobVisit , 0);
        Queue<Integer> q = new LinkedList<>();
        int result = Integer.MIN_VALUE;
        boolean[] aliceVisit = new boolean[n];
        int[] aliceVisitCost = new int[n];
        q.offer(0);
        Arrays.fill(aliceVisitCost, 0);
        int i = 0;
        while (!q.isEmpty() ) {
            int t = q.size();
            while(t-- > 0){
                int curr = q.poll();
                aliceVisit[curr] = true;
                if(i == bobVisit[curr]){
                    aliceVisitCost[curr] += amount[curr]/2;
                }
                else if(bobVisit[curr] <0 || i < bobVisit[curr]){
                    aliceVisitCost[curr] += amount[curr];
                }
                boolean leaf = true;
                for(int itr : adjList[curr]){
                    if(aliceVisit[itr] == false){
                        aliceVisitCost[itr] = aliceVisitCost[curr];
                        leaf = false;
                        q.offer(itr);
                    }
                }
                if(leaf){
                    result = Math.max(result, aliceVisitCost[curr]);
                }
            }
            i++;
        }
        return result;
    }
}