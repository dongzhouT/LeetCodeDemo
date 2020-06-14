package com.tao.leetcode.test;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test200614 {
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;

    }

    /**
     * 给你一个整数数组 arr 和一个整数 k 。
     * 现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Integer[] counts = new Integer[map.size()];
        map.values().toArray(counts);

        int[] newArr = new int[counts.length];
        for (int i = 0; i < counts.length; i++) {
            newArr[i] = counts[i];
        }
        Arrays.sort(newArr);
        int index = 0;
        newArr = runningSum(newArr);
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] >= k) {
                if (newArr[i] > k) {
                    index = i;
                } else {
                    index = i + 1;
                }

                break;
            }
        }


        return newArr.length - index;

    }

    /**
     * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
     * <p>
     * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
     * <p>
     * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
     * <p>
     * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
     * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
     * 输出：3
     * 解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
     * 现在需要制作 3 束花，每束只需要 1 朵。
     * 1 天后：[x, _, _, _, _]   // 只能制作 1 束花
     * 2 天后：[x, _, _, _, x]   // 只能制作 2 束花
     * 3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3
     *
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public static int minDays(int[] bloomDay, int m, int k) {
        int length = bloomDay.length;
        int result = -1;
        if (m * k > length || length > 100000) {
            return -1;
        }
        int maxDay = 0;
        int minDay = bloomDay[0];
        for (int i : bloomDay) {
            maxDay = Math.max(maxDay, i);
            minDay = Math.min(minDay, i);
        }
        int[] newArr = new int[length];
        int[] newArr2 = new int[length];
        System.arraycopy(bloomDay, 0, newArr, 0, length);
        System.arraycopy(bloomDay, 0, newArr2, 0, length);
        Arrays.sort(newArr2);
//        System.out.println("maxDay=" + maxDay + ",minDay=" + minDay);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                newArr[j] = bloomDay[j] - newArr2[i];
            }
//            System.out.println("i=" + i + ",arr=" + Arrays.toString(newArr));
            if (valid(newArr, m, k)) {
                return newArr2[i];
            }

        }
        return result;
    }

    private static boolean valid(int[] data, int m, int k) {
        int len = data.length;
        int sum = 0;
        int[] tempAr = new int[k];
        int count = 0;
        for (int d : data) {
            if (d <= 0) {
                count++;
            }
        }
        if (count < m * k) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (data[i] <= 0) {
                tempAr = new int[k];
                if (i + k <= len) {
                    System.arraycopy(data, i, tempAr, 0, k);
                    boolean find = true;
                    for (int d : tempAr) {
                        if (d > 0) {
                            find = false;
                            break;
                        }
                    }
                    if (find) {
                        i += k - 1;
//                        System.out.println("i=" + i + ",arr=" + Arrays.toString(tempAr));
                        sum++;
                    }
                    if (sum == m) {
                        return true;
                    }
                }else{
                    break;
                }


            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] data = new int[]{5, 5, 4};
//        System.out.println(Arrays.toString(runningSum(data)));
//        System.out.println(findLeastNumOfUniqueInts(data, 1));

//        int[] data = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        int[] data = {1000000000, 1000000000
        };
        int m = 1, k = 1;
        System.out.println(minDays(data, m, k));
    }

}
