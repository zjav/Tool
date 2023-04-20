package com.ulane.exam;

import java.util.Arrays;

/**
 * 14:55
 *
 * @author zjw
 */
public class MergeSort {
    static void merge_sort_py(int[] arr){
        int[] aux = Arrays.copyOf(arr,arr.length);


    }
    static void rsort(int lo, int high, int[] arr, int[] aux){
        if (lo>= high) return;
        int mid = (high-lo)/2 + lo;


        rsort(lo,mid,arr,aux);
        rsort(mid+1,high,arr,aux);
        merge_py(lo,mid,high,arr,aux);
    }
    static  void merge_py(int lo, int mid, int high, int[] arr, int[] aux){
        int left = lo;
        int right = mid+1;

        for (int i = lo; i <= high; i++) {// don't understand 少了等于不行, 要从lo开始, 只能从lo开始, 因为这个合并不一定是多大, 从0在合并右组的时候会越界
            aux[i] = arr[i];
        }

        for (int i = lo; i <= high; i++) {
            if (left > right){
                arr[i] = aux[right];
                ++right;
            }else if(right > high){
                arr[i] = aux[left];
                ++left;
            } else if (aux[right] < aux[left]) {
                arr[i] =aux[right];
                ++right;
            }else{
                arr[i] = aux[left];
                ++left;
            }

        }
    }


    //-------------------------------------------------------------
    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2) // 这里完全看不懂 当两个数组, 从0开始比较排序?   两个分开的数组合并
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    // 递归 Top-down
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }
    /**
     * def merge_sort(A):
     * aux = [None] * len(A)
     * def rsort(lo, hi):
     * if hi <= lo: return
     * mid = (lo+hi) // 2
     * rsort(lo, mid)
     * rsort(mid+1, hi)
     * merge(lo, mid, hi)
     * def merge(lo, mid, hi):
     *
     * aux[lo:hi+1] = A[lo:hi+1]
     * left = lo
     * right = mid+1
     * for i in range(lo, hi+1):
     * if left > mid:
     * A[i] = aux[right]
     * right += 1
     * elif right > hi:
     * A[i] = aux[left]
     * left += 1
     * elif aux[right] < aux[left]:
     * A[i] = aux[right]
     * right += 1
     * else:
     * A[i] = aux[left]
     * left += 1
     * rsort(0, len(A)-1)
     * 可以重写试一下
     * */




    // 迭代 Bottm-up
    public static void merge_sort_DieDai(int[] arr) {
        int[] orderedArr = new int[arr.length];
        for (int i = 2; i < arr.length * 2; i *= 2) {
            for (int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = left + i / 2 >= arr.length ? (arr.length - 1) : (left + i / 2);
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                    orderedArr[start++] = arr[l++];
                while (m <= right)
                    orderedArr[start++] = arr[m++];
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a ={5,1,3,4};
        int[] b =new int[4];
//        merge_sort_DieDai(a);
        rsort(0,3,a, b);
        System.out.println(Arrays.toString(a));
    }
}
