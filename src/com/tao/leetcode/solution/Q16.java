package com.tao.leetcode.solution;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */

public class Q16 {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        int m = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                int n = Math.abs(sum - target);
                if (n < m) {
                    m = n;
                    result = sum;
                }
                if (sum < target) {
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;

                } else {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;

                }


            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        int target = -100;
        System.out.println(threeSumClosest(nums, target));
    }
}
