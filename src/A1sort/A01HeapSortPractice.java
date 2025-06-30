package A1sort;

import java.util.Arrays;

public class A01HeapSortPractice {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        // 최초 힙 정렬
        for(int i = arr.length/2-1 ; i >= 0 ; i--) {
            heapify(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));

        for(int i = arr.length-1 ; i >= 0 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));
    }
    static void heapify(int[] arr, int parent, int length) {
        int a = parent*2+1;
        int b = parent*2+2;

        int minIndex = parent;

        if(a < length && arr[a] < arr[minIndex]) {
            minIndex = a;
        }
        if(b < length && arr[b] < arr[minIndex]) {
            minIndex = b;
        }
        if(minIndex != parent) {
            int temp = arr[parent];
            arr[parent] = arr[minIndex];
            arr[minIndex] = temp;
            heapify(arr, minIndex, length);
        }
    }
}
