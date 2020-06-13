package com.tao.leetcode.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test0613 {
    public static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    static class SubrectangleQueries {
        int[][] mRectangle;

        public SubrectangleQueries(int[][] rectangle) {
            mRectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    mRectangle[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            if (mRectangle == null || mRectangle.length == 0)
                return -1;
            if (row >= mRectangle.length || col >= mRectangle[0].length)
                return -1;
            return mRectangle[row][col];
        }
    }

    public static int minSumOfLengths(int[] arr, int target) {

        System.out.println(Arrays.toString(arr));
        int[][] result = new int[arr.length][arr.length];
        int sum = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = getSum(arr, i, j);
                if (sum < target) {
                    continue;
                } else if (sum > target) {
                    break;
                } else {
                    col = 0;
                    for (int a = i; a < j; a++) {
                        result[row][col] = arr[a];
                        col++;
                    }
                    row++;
                }
            }
        }
        System.out.println(Arrays.toString(result));
        return 0;
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int k = arr[i];
                    arr[i] = arr[j];
                    arr[j] = k;
                }
            }
        }
        return arr;
    }

    public static int getSum(int[] arr, int start, int end) {
        int result = 0;
        for (int i = start; i < end; i++) {
            result += arr[i];
        }
        return result;

    }

    /**
     * 给你一个房屋数组houses 和一个整数 k ，其中 houses[i] 是第 i 栋房子在一条街上的位置，现需要在这条街上安排 k 个邮筒。
     * <p>
     * 请你返回每栋房子与离它最近的邮筒之间的距离的 最小 总和。
     * <p>
     * 答案保证在 32 位有符号整数范围以内。
     *
     * @param houses
     * @param k
     * @return
     */
    public int minDistance(int[] houses, int k) {
        if (houses.length <= k) {
            return 0;
        }
        houses = sort(houses);
        for(int i=0;i<houses.length;i++){


        }
        return -1;

    }
    public static int getMin(int[] data){
        int middle=data[data.length/2];
        int sum=0;
        for(int i=0;i<data.length;i++){
            sum+=Math.abs(data[i]-middle);
        }
        return sum;

    }
    public static void getAllDis(int[] data){
        sort(data);
        Map<Integer,Integer> disMap=new HashMap<>();
        for(int i=0;i<data.length-1;i++){
            disMap.put(i,data[i+1]-data[i]);
        }
        for(int i=0;i<disMap.entrySet().size();i++){
            System.out.println(disMap.get(i));
        }
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{10, 1, 1, 6};
//        prices = finalPrices(prices);
//        System.out.println("hello world:" + Arrays.toString(prices));

//        int[][] data = new int[][]{{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}};
//        SubrectangleQueries queries = new SubrectangleQueries(data);
//        System.out.println(queries.getValue(0, 2));
//        queries.updateSubrectangle(0, 0, 3, 2, 5);
//        System.out.println(queries.getValue(0, 2));
        int[] data = {1,4,8,10,20};
//        minSumOfLengths(data, 3);
        getAllDis(data);
    }
}
