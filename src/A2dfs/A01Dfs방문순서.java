package A2dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class A01Dfs방문순서 {
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        // 방문할 수 있는 점이 여러 개인 경우 정점 번호가 작은 것을 먼저 방문
        // 출발은 0부터 dfs로 방문 시 방문순서: 0 -> 1 -> 3 -> 2 -> 4
        int[][] nodes = {{0, 2}, {0, 1}, {1, 3}, {2, 3}, {2, 4}};

        // 인접리스트를 활용해서 인접해있는 노드를 빠르게 접근.
        adjList = new ArrayList<>();
        visited = new boolean[5];

        for(int i = 0 ; i < 5 ; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] node : nodes) {
            // 양방향
            adjList.get(node[0]).add(node[1]);
            adjList.get(node[1]).add(node[0]);
        }
        for(int i = 0 ; i < adjList.size() ; i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        dfs(0);
    }
    static void dfs(int start) {
        if(!visited[start]) {
            visited[start] = true;
            System.out.println(start);
            // 인접 리스트를 순회할 때는 보통 향상된 for문 사용.
            for(int a : adjList.get(start)) {
                dfs(a);
            }
        }
    }
}
// DFSBFS(1260) : 백준
// 연결요소의개수(11724) : 백준