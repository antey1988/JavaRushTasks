package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
E:\task2207.txt
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(br.readLine());
        br.close();
        br = new BufferedReader(fr);
        List<String> allWords = new ArrayList<>();

        String string;
        while ((string = br.readLine()) != null) {
            allWords.addAll(new ArrayList<>(Arrays.asList(string.split("\\s"))));
        }

        fr.close();
        br.close();

        while (allWords.size() > 0 ) {
            String firstString = allWords.get(0);
            Iterator<String> iter = allWords.iterator();
            iter.next();
            while (iter.hasNext()) {
                String curString = iter.next();
                StringBuilder secondSb = new StringBuilder(curString);
                if (firstString.equals(secondSb.reverse().toString())) {
                    Pair pair = new Pair(firstString, secondSb.reverse().toString());
                    if (!result.contains(pair)) result.add(pair);
                    iter.remove();
                }
                else if (firstString.equals(curString)) {
                    iter.remove();
                }
            }
            allWords.remove(firstString);
        }
        for(Pair pair : result) System.out.println(pair);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
