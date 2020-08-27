package com.tao.leetcode.solution;

import com.tao.leetcode.utils.GsonUtils;
import sun.security.util.Length;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Q31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int j=i;
                int num=nums[i-1];
                while(i<nums.length&&num<nums[i]){
                    i++;
                }
                nums[j] = nums[i-1];
                nums[i-1] = num;
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,8,4,7,6,5,3,1};
        new Q31().nextPermutation(nums);
        System.out.println(GsonUtils.toJson(nums));
    }
}
