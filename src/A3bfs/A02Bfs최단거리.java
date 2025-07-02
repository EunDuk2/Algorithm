package A3bfs;

import java.util.*;

public class A02Bfs최단거리 {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;
    static int target = 4;

    public static void main(String[] args) {
        // 방문할 수 있는 점이 여러 개인 경우 정점 번호가 작은 것을 먼저 방문
        // 출발은 0부터 bfs로 방문 시 방문순서: 0 -> 1 -> 2 -> 3 -> 4
        int[][] nodes = {{0, 2}, {0, 1}, {1, 3}, {2, 3}, {2, 4}};


        // 인접리스트를 활용해서 인접해있는 노드를 빠르게 접근.
        adjList = new ArrayList<>();
        visited = new boolean[5];
        distance = new int[5];

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
        bfs(0);
        System.out.println(distance[target]);
    }
    static void bfs(int start) {
        // Queue안에 Integer가 아니라 int[]을 담아서 0번째는 노드번호, 1번째는 distance 설계 가능.
        Queue<Integer> myQueue = new LinkedList<>();

        myQueue.add(0);
        visited[0] = true;
        distance[0] = 0;

        while(!myQueue.isEmpty()) {
            int temp = myQueue.poll();
            for(int a : adjList.get(temp)) {
                if(!visited[a]) {
                    myQueue.add(a);
                    visited[a] = true; // queue에 담는 시점에 true세팅해야, 중복해서 queue안담김
                    distance[a] = distance[temp]+1;
                    if(a == target) { // 만약에 찾고자 하는 target이 정해져 있으면 break;
                        break;
                    }
                }
            }
        }
    }
}
