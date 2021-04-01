package com.javarush.task.task18.task1827;

/* 
Прайсы
/home/oleg/Документы/task1827_input.txt
Шорты пляжные 178.00 20
-c Шорты пляжные 178.00 20
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length != 0) {
            int dlinaParam = args.length;
            String quantity = args[dlinaParam - 1];
            String price = args[dlinaParam - 2];
            String productName = "";
            for (int i = 1; i < dlinaParam - 2; i++) {
                productName = productName + " " + args[i];
            }
            productName = productName.substring(1);

            if (args[0].equals("-c")) {
                String string, fileName;
                int id_cur, id_max = Integer.MIN_VALUE;
                BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
                fileName = br.readLine();
                br.close();
                br = new BufferedReader(new FileReader(fileName));
                while ((string = br.readLine()) != null) {
                    string = string.substring(0, 8);
                    //                string.
                    string = string.replaceAll("\\s", "");
                    id_cur = Integer.parseInt(string);
                    if (id_cur > id_max) id_max = id_cur;
                }
                id_max++;
                br.close();

                string = Integer.toString(id_max);
                string = DopolnrnieDoDlini(string, 8) + DopolnrnieDoDlini(productName, 30) +
                        DopolnrnieDoDlini(price, 8) + DopolnrnieDoDlini(quantity, 4);

                BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
                bw.write("\n" + string);
//                bw.write(string);
//                bw.write("\n");
                bw.close();
            }
        }
    }

    public static String DopolnrnieDoDlini(String string, int dlina) {
        String new_string = string;
        for (int i = 0; i < dlina - string.length(); i++) {
            new_string = new_string + " ";
        }
        return  new_string;
    }
}
