package com.mail.netty.fifth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MyServer {
    public static void main(String[] args) {
//        int[] arr = {1, 4, 3, 2,};
      /*  int[] arr = {1, 1};
        System.out.println(arrayPairSum(arr));*/


        int[] arr = {1, 4, 7, 2, 3, 6, 9};
        Arrays.copyOf(arr, 3);
        int M = arr.length / 2;
        int[] result = new int[arr.length];
        int[] left = new int[M];
        int[] right = new int[arr.length - M];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[M + i];
        }

        int i = 0;
        int j = 0;
        int newArrIndex = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[newArrIndex++] = left[i++];
            } else if (left[i] > right[j]) {
                result[newArrIndex++] = right[j++];
            } else {
                result[newArrIndex++] = left[j++];
                result[newArrIndex++] = right[j++];
            }
        }
        if (i < left.length) {
            result[newArrIndex++] = left[i++];
        } else if (j < right.length) {
            result[newArrIndex++] = right[j++];
        }

        for (int s : result) {
            System.out.print(s);
        }
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        sort(data, 0 ,data.length-1);

    }

    public static void sort(int[] data, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            sort(data, low, mid);
            // 右边
            sort(data, mid + 1, high);
            // 左右归并
            merge(data, low, mid, high);
            System.out.println(Arrays.toString(data));
        }

        // 合并
        merge(data, low, mid, high);

    }

    public static int arrayPairSum(String[] words) {
//        int max=0;
//        int len=nums.length;
//        int middle=nums.length/2;
//        int temp=0;
//        if(len<=0){
//            return 0;
//        }
//        int maxNum=nums[0]+nums[middle];
//        max=nums[0]>nums[middle]?nums[0]:nums[middle];
//        for (int i=0;i<middle;i++){
//            temp=nums[i]+nums[2*middle-1-i];
//            if(temp>maxNum){
//                maxNum=temp;
//                max=nums[i]>nums[2*middle-1-i]?nums[i]:nums[2*middle-1-i];
//            }
//        }
//        return max;
       /* Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; ) {
            count += nums[i];
            i = i + 2;
        }
        return count*/
        ;
        String[] arr = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        HashMap<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < arr.length; i++) {
            map.put((char) (97 + i), arr[i]);
        }
        HashMap<String, String> map1 = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (char c : words[i].toCharArray()) {
                builder.append(map.get(c));
            }
            set.add(builder.toString());
        }

        return set.size();
    }

    public static void merge(int[] data, int left, int middle, int right) {
        int[] result = new int[data.length];

        int rightIndex = middle;

        int newArrIndex = 0;
        while (left < middle && rightIndex < data.length) {
            if(data[left]<=data[rightIndex]){
                result[newArrIndex++]=data[left++];
            }else{
                result[newArrIndex++]=data[right++];
            }
        }
        while (left < middle) {
            result[newArrIndex++]=data[left++];
        }
        while (rightIndex < right) {
            result[newArrIndex++]=data[rightIndex++];
        }
        newArrIndex=0;
        while (newArrIndex<data.length){
            data[newArrIndex]=result[newArrIndex];newArrIndex++;
        }
        return;
    }

}
