package com.ulane.sort;

import java.util.Arrays;

/**
 * 14:25
 *
 * @author zjw */
public class TestQuick {


    public static void quickSort(int[] array, int low, int high){

        if (low >= high){
            return ;
        }
        int i,j,p, temp;

        p = array[low];
        i = low;
        j = high;


        while(i < j){
            while (array[i] < p && i<j){
                i++;
            }

            while (array[j] > p && i<j){
                j--;
            }
            temp = array[i];
            array[i]= array[j];
            array[j]=temp;
        }
        temp = p;
        array[low] = array[i];
        array[i] = p;
        quickSort(array, low, j-1);
        quickSort(array, j+1, high);
    }

    int partition(int a[], int start, int end){
        int pivot = a[end];
        int i = start-1;
        for (int j = 0; j < end; j++) {// 什么jb玩意看不懂
            if(a[j] < pivot){
                i++;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        a[end] = a[i+1];
        a[i+1] = pivot;
        return i+1;
    }

    void quick(int a[],int start, int end){
        if(start < end){
            int p = partition(a,start,end);
            quick(a, start, p-1);
            quick(a, p+1, end);
        }
    }

    public static void main(String[] args) {
//        int a[] = {13,18,27,2,19,25};
        int a[] = {24,9,29,14,19,27};
        quickSort1(a,0,a.length-1);

//        TestQuick testQuick = new TestQuick();
//        testQuick.quick(a,0,a.length-1 );
        System.out.println(Arrays.toString(a));
    }



    public static void quickSort1(int[] arr, int low, int high){
        int p,i,j,temp;

        p = arr[low];// 已第一个元素为pivo
        i = low;
        j = high;
        if (i>=j)
            return;

        while (i<j){
            while (arr[j] >= p && i<j){
                j--;
            }
            while(arr[i] <= p && i<j){
                i++;
            }
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;


        }
        arr[low] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        arr[i] = p;// 讲中心位置从第一个元素换过来.
        quickSort(arr,low,i-1);
        quickSort(arr,i+1,high);
    }
}
