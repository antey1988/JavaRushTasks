package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int nod = 1;


            int n1 = Integer.parseInt(br.readLine());
//            if (n1 < 0) throw new Exception();
            int n2 = Integer.parseInt(br.readLine());
            if ((n2 <= 0) || (n1 <= 0)) throw new Exception();

            if (n2 == 0) nod = n1;
            else if (n1 == 0) nod = n2;
            else {
                list1 = Mnojetel(n1);
                list2 = Mnojetel(n2);

//                System.out.println(list1);
//
//                System.out.println(list2);

                int j = 0;
                int k = 0;
                for(Integer i : list1) {
                    while (k < list2.size()) {
                        if (i == list2.get(k)) {
                            nod *= i;
                            j = k + 1;
                            break;
                        }
                        k++;
                    }
                    k = j ;
                }
            }
            System.out.println(nod);

    }
    public static List<Integer> Mnojetel(int n) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            int m = n;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    list.add(i);
                    n = n / i;
                    break;
                }
            }

            if (m == n) {
                list.add(n);
                break;
            }
        }
        return list;
    }
}
