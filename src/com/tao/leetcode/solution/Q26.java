package com.tao.leetcode.solution;

import com.google.gson.Gson;

/**
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Q26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preIndex = 0;
        int newNum = nums[0];
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != newNum) {
                newNum = nums[i];
                preIndex++;
                nums[preIndex] = nums[i];
                sum++;
            }

        }
        return sum;

    }

    public int removeDuplicatesPro(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int j = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j] = nums[i + 1];
                j++;
            }

        }
        return j;

    }

    public static void main(String[] args) {
        int[] data = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Q26().removeDuplicatesPro(data));
        System.out.println(new Gson().toJson(data));
    }
}
