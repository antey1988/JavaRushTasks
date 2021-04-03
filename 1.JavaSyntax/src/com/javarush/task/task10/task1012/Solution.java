package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');
        //System.out.println(alphabet.indexOf('г'));
        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        //пустой массив, показывающий количество символов в введных строках
         int[] count = new int[alphabet.size()] ;
        /*for (int i = 0; i < alphabet.size(); i++) {
            listcount.add(0);
        }*/
        for (String s : list) {
            for (char c : s.toCharArray()) {
                try {
                    int i = alphabet.indexOf(c);
                    count[i] =count[i] + 1;
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }

        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i) + " " + count[i]);
        }

        // напишите тут ваш код
    }
}
