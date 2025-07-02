package A5dp;

public class A02동전관련 {
    public static void main(String[] args) {
        // 1, 4, 5 의 숫자가 있을 때, 조합하여 13을 만들 수 있는 조합 중 가장 짧은 조합의 길이
        Integer[] arr = {1, 4, 5};
        int target = 13;
        // greedy로 풀 경우 : 5*2 + 1*3 -> 5개 동전
        // dfs, bfs -> 시간초과 또는 메모리초과
        // dp로 문제를 풀 경우 : 4*2 + 5*1 -> 3개 동전
        // f(n) = min(f(n-i), f(n-i2)) + 1

        int[] minArr = new int[target+1];

        for(int i = 1 ;i < target+1 ; i++) {
//            int a = minArr[i-1];
//            int b = minArr[i-4];
//            int c = minArr[i-5];
//            minArr[i] = Math.min(a, b, c) + 1;
            int min = Integer.MAX_VALUE;
            for(int a : arr) {
                if(i-a >= 0 && min > minArr[i-a]) {
                    min = minArr[i-a];
                }
            }
            minArr[i] = min+1;
        }

        for(int a : minArr) {
            System.out.println(a);
        }

        // 동전 2 : 백준





    }
}
