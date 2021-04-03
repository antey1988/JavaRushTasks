package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String s1;
        private String s2;
        private String s3;
        private int i1;
        private int i2;
        private int i3;

        public Human(String s1, String s2, String s3, int i1, int i2, int i3) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            this.i1 = i1;
            this.i2 = i2;
            this.i3 = i3;
        }
        public Human(String s1, String s2, String s3, int i1, int i2) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            this.i1 = i1;
            this.i2 = i2;
        }
        public Human(String s1, String s2, String s3, int i1) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            this.i1 = i1;
        }
        public Human(String s1, String s2, String s3) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }
        public Human(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
        public Human(String s1) {
            this.s1 = s1;
        }
        public Human(int i1, int i2, int i3) {
            this.i1 = i1;
            this.i2 = i2;
            this.i3 = i3;
        }
        public Human(int i1, int i2) {
            this.i1 = i1;
            this.i2 = i2;
        }
        public Human(int i1) {
            this.i1 = i1;
        }
        public Human() {
        }
    }
}
