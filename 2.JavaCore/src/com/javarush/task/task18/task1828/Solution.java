package com.javarush.task.task18.task1828;

/* 
Прайсы 2
/home/oleg/Документы/task1828_input.txt
198478
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 1) {
            List<String> fileLine = new ArrayList<>();
            String fileName;
            String string, new_string, id_;
            BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
            fileName = br.readLine();
            br.close();

            br = new BufferedReader(new FileReader(fileName));
            while ((string = br.readLine()) != null) {
                id_ = string.substring(0 ,8);
                if (args[1].equals(id_.replaceAll("\\s", ""))) {
//                    .if (args[0].equals("-d")) continue;
                    if (args[0].equals("-u")) {
                        int dlinaParam = args.length;
                        String quantity = args[dlinaParam - 1];
                        String price = args[dlinaParam - 2];
                        String productName = "";
                        for (int i = 2; i < dlinaParam - 2; i++) {
                            productName = productName + " " + args[i];
                        }
                        productName = productName.substring(1);
                        string = id_ + DopolnrnieDoDlini(productName, 30) +
                                DopolnrnieDoDlini(price, 8) + DopolnrnieDoDlini(quantity, 4);
                        fileLine.add(string);
                    }
                }
                else {
                    fileLine.add(string);
                }
            }
            br.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (String s : fileLine) {
                bw.write(s + "\n");
            }
            bw.close();
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
