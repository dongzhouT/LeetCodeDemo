package com.tao.leetcode.test;

import com.tao.leetcode.utils.GsonUtils;

import java.util.*;

public class Test0621 {
    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= start + 2 * i;
        }
        return ans;

    }

    public String[] getFolderNames(String[] names) {
        String[] ans = new String[names.length];
        Map<String, Integer> nameMap = new HashMap<>();
        int i = 0;
        for (String fileName : names) {
            String newName = fileName;
            if (nameMap.containsKey(fileName)) {
                int index = nameMap.get(fileName);
                while (nameMap.containsKey(newName)) {
                    index++;
                    newName = fileName + "(" + index + ")";
                }
                nameMap.put(fileName, index);
                nameMap.put(newName, 0);
            } else {
                nameMap.put(fileName, 0);
            }
            ans[i] = newName;
            i++;
        }
        return ans;

    }

    /**
     * 5442. 避免洪水泛滥
     *
     * @param rains
     * @return
     */
    public int[] avoidFlood(int[] rains) {
        // TODO: 2020/6/21  
        int length = rains.length;
        int maxVal = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1, 1);
        for (int i = 0; i < length; i++) {
            maxVal = Math.max(maxVal, rains[i]);
        }
        int[] ints = new int[maxVal + 1];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = -1;
        }
        int ans[] = new int[length];
        for (int i = 0; i < length; i++) {
            if (rains[i] > 0) {
                ans[i] = -1;
                if (ints[rains[i]] == 1) {
                    return new int[]{};
                } else {
                    ints[rains[i]] = 1;
                }
            } else {
                ans[i] = -1;
                //向后找
                for (int j = i + 1; j < length; j++) {
                    if (ints[rains[j]] == 1) {
                        ans[i] = rains[j];
                        ints[rains[j]] = -1;
                        break;
                    }
                }
                if (ans[i] < 0) {
                    for (int j = 0; j < ints.length; j++) {
                        if (ints[j] == 1) {
                            ans[i] = j;
                            ints[j] = -1;
                            break;
                        }
                    }
                    ans[i] = Math.max(ans[i], 1);
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
//        int i = 4;
//        int j = 3;
//        System.out.println(new Test0621().xorOperation(i, j));

//        String[] file = new String[]{"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
//        System.out.println(GsonUtils.toJson(new Test0621().getFolderNames(file)));
        int[] rains = new int[]{1, 2, 0, 0, 2, 1};
        rains = new int[]{10, 20, 20};
        System.out.println(GsonUtils.toJson(new Test0621().avoidFlood(rains)));
    }

}
