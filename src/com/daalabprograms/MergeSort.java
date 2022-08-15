package com.daalabprograms;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {

    void mergeSort(int[] arr,int n){
        //n - array size
        int left[] = new int[n/2];
        int right[] = new int[(n/2)+1];

        int j=0;//index of left array
        int k=0;//index of right array

        if(n>1){
            for(int i=0;i<n/2;i++){
                left[j++]=arr[i];
            }

            for(int i=n/2;i<n;i++){
                right[k++]=arr[i];
            }

            mergeSort(left,j);
            mergeSort(right,k);


            merge(left,right,arr,j,k);

        }

    }

    private void merge(int[] first, int[] second, int[] arr, int fLen, int sLen) {

        int i=0;//first arr index
        int j=0;//second arr index
        int k=0;//final array index

        while(i<fLen && j<sLen){
            if(first[i]<=second[j]){
                arr[k++]=first[i++];
            }
            else{
                arr[k++]=second[j++];;
            }
        }

        //check are there any remaining elements in any of the above array
        //and add them to the end

        while(i< fLen){
            arr[k++]=first[i++];
        }

        while(j< sLen){
            arr[k++]=second[j++];
        }


    }


    public static void main(String[] args) {

        System.out.print("Enter the Array size : ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[]=new int[n];

        Random random = new Random();

        for (int i = 0; i <n ; i++) {
            a[i]=random.nextInt(100000);
        }

        System.out.println("Array before sorting");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }


        MergeSort ms = new MergeSort();
        System.out.println("Array after sorting");
        long startTime = System.currentTimeMillis();
        ms.mergeSort(a,n);
        long stopTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
        long elapseTime = stopTime - startTime;
        System.out.println("Time Consumed : " + elapseTime + " millseconds " + startTime + " " + stopTime);


    }
}
