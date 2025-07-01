package A2dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//    1
//   2 3
//  4 5 6 7
//8 9 10

// 출력
// [[1, 2, 4, 8], [1, 2, 4, 9], [1, 2, 5, 10], [1, 3, 6], [1, 3, 7]]

public class A02Dfs모든경우의수 {
    static List<List<Integer>> adjList;
    static List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) {
        // 1~10까지의 노드가 존재
        int[][] nodes = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3,7}, {4,8}, {4,9}, {5,10}};
        adjList = new ArrayList<>();

        // 1부터 시작할 경우 인접리스트를 1개 더 생성
        for(int i = 0 ; i < 11 ; i++) {
            adjList.add(new ArrayList<>());
        }
        // 여기서는 1번이 루트노드라고 정해졌기 때문에, visited제외하고 단방향노드로 설계.
        for(int[] node : nodes) {
            adjList.get(node[0]).add(node[1]);
        }
        for(int i = 0 ; i < adjList.size() ; i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        dfs(1, new ArrayList<>());
        System.out.println(answer);
    }
    static void dfs(int start, List<Integer> path) {
        path.add(start);
        if(adjList.get(start).isEmpty()) {
            answer.add(new ArrayList<>(path));
        }
        for(int a : adjList.get(start)) {
            dfs(a, path);
            path.remove(path.size()-1);
        }
    }
}

