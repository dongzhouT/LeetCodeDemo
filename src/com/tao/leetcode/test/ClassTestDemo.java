package com.tao.leetcode.test;

public class ClassTestDemo {
    public static class A {
        void print() {
            System.out.println(getClass().getSimpleName());
        }
    }

    public static class B extends A {
        void print() {
            System.out.println(getClass().getSimpleName());
        }
    }

    public static class C extends B {
        void print() {
            System.out.println(getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        A a1 = new B();
        A a2 = new C();
        a1.print();//1 B
        a2.print();//2 C
        B b1 = (B) a1;
        b1.print();//3 B
        C b2 = (C) a2;
        b2.print();//4 C
    }
}
