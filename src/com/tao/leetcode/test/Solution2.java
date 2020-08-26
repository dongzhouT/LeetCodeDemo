package com.tao.leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static List<Integer> foo(int m, List<List<Integer>> datas) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();
        int maxLen = 0;
        for (int i = 0; i < datas.size(); i++) {
            lengths.add(0);
            maxLen = Math.max(maxLen, datas.get(i).size());
        }
        for (int k = 0; k < Math.ceil(maxLen / (m * 1f)); k++) {
            for (int i = 0; i < datas.size(); i++) {
                int j = lengths.get(i);
                for (; j < Math.min(datas.get(i).size(), lengths.get(i) + m); j++) {
                    ans.add(datas.get(i).get(j));
                }
                lengths.set(i, j);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        List<List<Integer>> datas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] in = sc.next().split(",");
            List<Integer> item = new ArrayList<>();
            for (String s : in) {
                item.add(Integer.valueOf(s));
            }
            datas.add(item);
        }

        List<Integer> ans=foo(m,datas);
        StringBuilder sb=new StringBuilder();
        for(Integer data:ans){
            if("".equals(sb.toString())){
                sb.append(data);
            }else{
                sb.append(",").append(data);
            }
        }
        System.out.println(sb.toString());
    }

}
