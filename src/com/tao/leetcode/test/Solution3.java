package com.tao.leetcode.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution3 {
    public static List<Integer> foo(Map<Integer, Integer> datas, int deleteFile) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(deleteFile);
        datas.remove(deleteFile);
        while (!queue.isEmpty()) {
            int file = queue.poll();
            for (Map.Entry<Integer, Integer> entry : datas.entrySet()) {
                if (entry.getValue() == file) {
                    queue.offer(entry.getKey());
                    datas.remove(entry.getKey());
                }
            }
        }
        List<Integer> ans = new ArrayList<>(datas.keySet());
        Integer[] result=new Integer[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i]=ans.get(i);
        }
        Arrays.sort(result);

        return Arrays.asList(result);
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
////        int m = sc.nextInt();
//////        Map<Integer,Integer> datas=new ConcurrentHashMap<>();
////        for (int i = 0; i < m; i++) {
////            datas.put(sc.nextInt(),sc.nextInt());
////        }
////        int deleteFile=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        Map<Integer,Integer> datas=new ConcurrentHashMap<>();
        datas.put(8,6);
        datas.put(10,8);
        datas.put(6,0);
        datas.put(20,8);
        datas.put(2,6);
        List<Integer> ans=foo(datas,2);
        for(int data:ans){
            sb.append(data).append(" ");
        }
        System.out.println(sb.toString().substring(0,sb.length()-1));

    }

}
