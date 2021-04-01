package Perechni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainClass {
    static final Map<String, String> COMPONENT = new HashMap<>();
    static {
        COMPONENT.put("C", "Конденсатор");
        COMPONENT.put("D", "Микросхема");
        COMPONENT.put("G", "Генератор");
        COMPONENT.put("HL", "Светодиод");
        COMPONENT.put("L", "Катушка индуктивности");
        COMPONENT.put("R", "Резистор");
        COMPONENT.put("T", "Трансформатор");
        COMPONENT.put("VD", "Диод");
        COMPONENT.put("WU", "Аттенюатор");
        COMPONENT.put("WS", "Циркулятор");
        COMPONENT.put("W", "Волновод");
        COMPONENT.put("X", "Соединитель");
        COMPONENT.put("Z", "Фильтр");
    }
    
    static final String RAZDEL = "@";
    static final String VIPOLNEN = "Выполнен";
    static final String TOPPLATI = "топологией платы";
    static final String POKUP = "Покуп. имп.";
    static final int LINESONFIRSTPAGE = 26;
    static final int LINESONNEXTPAGE = 32;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/oleg/Документы/Per.txt"));
        String string;
        String refDescOld = "C";
        int countLines = 0;
        boolean firstPage = true;

        while((string = br.readLine()) != null) {
//            System.out.println(string);
            string = string.replaceAll("\"","");
            String[] words = string.split("@");

            if (words.length > 2) {
                String refDesc = words[0].replaceAll("[\\d+\"]", "");

                String PartNumber = words[1];
                String Classes = COMPONENT.getOrDefault(refDesc, "");

                int Count = Integer.parseInt(words[2]);

                int curcountlines = 0;

                String newString;

                //Формирование строк с элементами, выполнеными в топологии печатных плат
                //(фильтры, микрополосковые линии, делители, ответвители
                if (PartNumber.contains(VIPOLNEN)) {
                    //оставляем только ИУЯД элемента
                    String IUYD = PartNumber.replaceAll(".*ИУЯД", "ИУЯД");
                    //строка для одного элемента
                    if (Count == 1) {
                        newString = words[0] + RAZDEL +  RAZDEL + Count + RAZDEL + Classes + ". " + VIPOLNEN + "\n"
                                + RAZDEL + RAZDEL + RAZDEL + TOPPLATI + "\n"
                                + RAZDEL + RAZDEL + RAZDEL + IUYD;
                    } else {
                        //количество повторяющихся подряд элементов
                        int OrderNumber = Integer.parseInt(words[0].replaceAll("\\D", ""));
                        //строка для двух элементов
                        if (Count == 2) {
                            newString = words[0] + "," + RAZDEL + RAZDEL + Count + RAZDEL + Classes + ". " + VIPOLNEN + "\n"
                                    + refDesc + (OrderNumber + 1) + RAZDEL + RAZDEL + RAZDEL + TOPPLATI + "\n"
                                    + RAZDEL + RAZDEL + RAZDEL + IUYD;;
                        }
                        //строка для трех и более элементов
                        else {
                            newString = words[0] + " - " + RAZDEL + RAZDEL + Count + RAZDEL + Classes + ". " + VIPOLNEN + "\n"
                                    + refDesc + (OrderNumber - 1 + Count) + RAZDEL + RAZDEL + RAZDEL + TOPPLATI + "\n"
                                    + RAZDEL + RAZDEL + RAZDEL + IUYD;;
                        }
                    }
                    curcountlines += 3;

                }

                //формирование строк для всех остальных элементов
                else {
                    String pokupnoe;
                    if (PartNumber.equals("LNA 5101") || (PartNumber.equals("LNA 2101")) ||
                            (PartNumber.equals("LNA 2102")) || (PartNumber.equals("BA 2102")) ||
                            (PartNumber.equals("BA 2101")) || (PartNumber.equals("LNA 5102"))) {
                        pokupnoe = "";
                    } else pokupnoe  = POKUP;
                        //оставляем только ИУЯД элемента
                        String IUYD = PartNumber.replaceAll(".*ИУЯД", "ИУЯД");
                    //строка для одного элемента
                    if (Count == 1) {
                        newString = words[0] + RAZDEL + Classes + " " + PartNumber + RAZDEL + Count + RAZDEL + pokupnoe;
                        curcountlines++;
                    } else {
                        //количество повторяющихся подряд элементов
                        int OrderNumber = Integer.parseInt(words[0].replaceAll("\\D", ""));
                        //строка для двух элементов
                        if (Count == 2) {
                            newString = words[0] + "," + RAZDEL + Classes + " " + PartNumber + RAZDEL + Count
                                    + RAZDEL + pokupnoe + "\n"
                                    + refDesc + (OrderNumber + 1) + RAZDEL + RAZDEL;
                        }
                        //строка для трех и более элементов
                        else {
                            newString = words[0] + " - " + RAZDEL + Classes + " " + PartNumber + RAZDEL + Count
                                    + RAZDEL + pokupnoe + "\n"
                                    + refDesc + (OrderNumber - 1 + Count) + RAZDEL + RAZDEL;
                        }
                        curcountlines += 2;
                    }
                }

                String otstup = "";
                if (!refDesc.equals(refDescOld)) {
                    otstup = "\n";
                    curcountlines++;
                }
                refDescOld = refDesc;


                int raznica = countLines + curcountlines - LINESONFIRSTPAGE;

                if ((raznica <= 0) || (countLines > LINESONFIRSTPAGE)){
                    System.out.print(otstup);
                } else {
                    switch (LINESONFIRSTPAGE - countLines) {
                        case 3:
                            System.out.println();
                        case 2:
                            System.out.println();
                        case 1:
                            System.out.println();
                    }
                    System.out.println(RAZDEL + "Page2" + RAZDEL);
                }
                countLines += curcountlines;
                System.out.println(newString);
            }
        }
    }
}
