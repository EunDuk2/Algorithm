package A1sort;

import java.util.Arrays;

// 트리탐색 + 재귀적 호출
public class A01HeapSort구현 {
    static int limitIndex;

    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        limitIndex = arr.length-1;

        // 최초 힙 구성 : n*log(n)
        for(int i = arr.length/2-1 ; i >= 0 ; i--) {
            heapify(arr, i);
        }
        // 최초 힙 완성
        System.out.println(Arrays.toString(arr));

        // 루트 노드와 최와위 노드를 자리 change 해가면서 재 heapify
        for(int i = arr.length-1 ; i >= 0 ; i--) {
            // 0번째 index와 마지막 index의 자리 change
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            limitIndex--; // 넘긴 최소값은 무시하기 위해
            heapify(arr, 0);
        }

        // 최종 정렬 완성
        System.out.println(Arrays.toString(arr));
    }
    static void heapify(int[] arr, int parent) {
        // 자식 노드와의 비교 (index 조심)
        // 완전이진트리에서 자식 노드의 인덱스 -> (부모 인덱스 * 2 + 1), (부모 인덱스 * 2 + 2)
        int left = parent*2+1;
        int right = parent*2+2;

        int minIndex = parent;

        // 자식 노드가 limitIndex 범위 안에 있는지 확인
        if(left <= limitIndex && arr[left] < arr[minIndex]) {
            minIndex = left;
        }
        if(right <= limitIndex && arr[right] < arr[minIndex]) {
            minIndex = right;
        }
        // 자식 노드가 부모보다 더 작으면 체인지
        if(minIndex != parent) {
            int temp = arr[parent];
            arr[parent] = arr[minIndex];
            arr[minIndex] = temp;
            // 만약 자리 체인지가 발생하면 재귀적 호출
            heapify(arr, minIndex); // heapify(arr, 바뀐자리의 자식 노드의 index);
        }
    }
}
