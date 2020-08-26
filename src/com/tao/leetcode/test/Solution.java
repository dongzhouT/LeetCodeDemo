package com.tao.leetcode.test;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public int foo(int m,int[] n){
        Arrays.sort(n);
        int len=n.length;
        if(m>=len){
            return n[len-1];
        }
        int ans=0;
        int mod=(len-1)%m;
        for (int i = 0; i < len; i++) {
            if(i%m==mod){
                ans+=n[i];
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] datas=new int[n];
        for (int i = 0; i < n; i++) {
            datas[i]=sc.nextInt();
        }
        System.out.println(new Solution().foo(m,datas));

    }

}
