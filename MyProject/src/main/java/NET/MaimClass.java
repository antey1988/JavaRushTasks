package NET;

import org.omg.CosNaming.IstringHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MaimClass {
    static final int COUNTSHEET = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/oleg/Документы/Net.txt"));
        String string;
        String NetOld = "";
        String SheetOld = "";
        /*int countLines = 0;
        boolean firstPage = true;*/
        Map<String,List<String>> lists = new TreeMap<>();
        for (int i = 1; i <= COUNTSHEET - 1; i++) {
            for (int j = i + 1; j <= COUNTSHEET; j++) {
                List<String> nets = new ArrayList<>();
                lists.put("" + i + j, nets);
            }
        }


        while((string = br.readLine()) != null) {
//            System.out.println(string);
            string = string.replaceAll("\"", "");
            String[] words = string.split("@");
            if (words.length == 2) {
                if (NetOld.equals(words[0])) {
//                    System.out.println(words[0] + ": " + SheetOld + " -> " + words[1]);
                    String list = "" + SheetOld + words[1];
                    lists.get(list).add(words[0]);
                }
                NetOld = words[0];
                SheetOld = words[1];
            }
        }
        for(Map.Entry<String,List<String>> entry : lists.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (String s : entry.getValue()) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
//        System.out.println("End");
    }
}

