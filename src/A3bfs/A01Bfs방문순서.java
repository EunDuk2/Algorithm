package A3bfs;

import java.util.*;

public class A01Bfs방문순서 {
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        // 방문할 수 있는 점이 여러 개인 경우 정점 번호가 작은 것을 먼저 방문
        // 출발은 0부터 bfs로 방문 시 방문순서: 0 -> 1 -> 2 -> 3 -> 4
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

        Queue<Integer> myQueue = new LinkedList<>();

        myQueue.add(0);
        visited[0] = true;

        while(!myQueue.isEmpty()) {
            int temp = myQueue.poll();
            System.out.println(temp);
            for(int a : adjList.get(temp)) {
                if(!visited[a]) {
                    myQueue.add(a);
                    visited[a] = true; // queue에 담는 시점에 true세팅해야, 중복해서 queue안담김
                }
            }
        }
    }
}
