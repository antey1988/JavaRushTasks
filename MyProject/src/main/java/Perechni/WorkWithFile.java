package Perechni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkWithFile {
    public static List<Record> scanFile(String filename) throws IOException {
        List<Record> records = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String string;

        String type = null;
        List<String> refDesc = null;
        String partNumber = null;
        String count = null;
        List<String> commit = null;

        while((string = br.readLine()) != null) {
            string = string.replaceAll("\"", "");
            String[] words = string.split("@");

            if (words.length > 2) {
                refDesc = new ArrayList<>();
                partNumber = words[1];
                count = words[2];
                records.add(new Record(refDesc, partNumber, count));
            }
            refDesc.add(words[0]);
        }
        return records;
    }

    public static void main(String[] args) {
        try {
            List<Record> list1 = scanFile("/home/oleg/Документы/Per.txt");
            List<Record> list2 = list1.stream()
                    .map(WorkWithString::updateRecords)
                    .collect(Collectors.toList());
//            System.out.println(list1);
            list2.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
