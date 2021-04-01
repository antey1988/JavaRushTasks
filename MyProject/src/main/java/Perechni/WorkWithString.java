package Perechni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WorkWithString {

    static final String IUYD = ".*ИУЯД.*";
    static final String NUMBER = "[^ИУЯД\\.\\d{6,6}\\.\\d{3,3]";
    static final String RNIIRS = "(LNA|BA)( |)(2|5)10(1|2)";
    static final String VIPOLNEN = ". Выполнен";
    static final String TOPOLOGIY = "топологией платы";
    static final String CONSTRUCTIVNO = "конструктивно";
    static final String POKUPNOE = "Покуп. имп.";

    static final Map<String, String[]> TYPES = new HashMap<>();
    static {
        TYPES.put("C", new String[] {"Конденсатор", "Конденсаторы"});
        TYPES.put("D", new String[] {"Микросхема", "Микросхемы"});
        TYPES.put("G", new String[] {"Генератор", "Генераторы"});
        TYPES.put("HL", new String[] {"Светодиод", "Светодиоды"});
        TYPES.put("L", new String[] {"Катушка индуктивности", "Катушки индуктивности"});
        TYPES.put("R", new String[] {"Резистор", "Трансформаторы"});
        TYPES.put("T", new String[] {"Трансформатор", "Трансформаторы"});
        TYPES.put("VD", new String[] {"Диод", "Диоды"});
        TYPES.put("WU", new String[] {"Аттенюатор", "Аттенюаторы"});
        TYPES.put("WS", new String[] {"Циркулятор", "Циркуляторы"});
        TYPES.put("W", new String[] {"Волновод", "Волноводы"});
        TYPES.put("X", new String[] {"Соединитель", "Соединители"});
        TYPES.put("Z", new String[] {"Фильтр", "Фильтры"});
    }

    static final Map<String, String> TYPE = new HashMap<>();
    static {
        TYPE.put("C", "Конденсатор");
        TYPE.put("D", "Микросхема");
        TYPE.put("G", "Генератор");
        TYPE.put("HL", "Светодиод");
        TYPE.put("L", "Катушка индуктивности");
        TYPE.put("R", "Резистор");
        TYPE.put("T", "Трансформатор");
        TYPE.put("VD", "Диод");
        TYPE.put("WU", "Аттенюатор");
        TYPE.put("WS", "Циркулятор");
        TYPE.put("W", "Волновод");
        TYPE.put("X", "Соединитель");
        TYPE.put("Z", "Фильтр");
    }


    public static List<String> compressRefDesc(List<String> list) {
        List<String> comList = new ArrayList<>();

        if (list.size() == 1) {
            comList.add(list.get(0));
            return comList;
        }

        if (list.size() == 2) {
            comList.add(list.get(0) + ",");
            comList.add(list.get(1));
            return comList;
        }

        String type = getType(list.get(0));
        List<Integer> number = list.stream().map(WorkWithString::number).sorted().collect(Collectors.toList());
        int last = number.get(list.size()-1);
        int first = number.get(0);

        if (last-first+1 == number.size()) {
            comList.add(type + first + "-");
            comList.add(type + last);
            return comList;
        }

        number.add(Integer.MAX_VALUE);
        int j = 1;
        int next, prev = number.get(0), curr = prev;
        for (int i = 1; i < number.size(); i++) {
            next = number.get(i);
            if (next - curr == 1) {
                j++;
            } else {
                if (j == 1) {
                    comList.add(type + prev + ",");
                } else {
                    comList.add(type + prev + ((j == 2) ? "," : " -"));
                    comList.add(type + curr + ",");
                }
                prev = next;
                j = 1;
            }
            curr = next;
        }
        comList.set(comList.size()-1, comList.get(comList.size()-1).replaceAll(",",""));
        return comList;
    }

    private static int number(String refDesc) {
        return Integer.parseInt(refDesc.replaceAll("\\D", ""));
    }

    public static String getType(String  refDesc) {
        return refDesc.replaceAll("\\d+", "");
    }

    public static Record updateRecords(Record record) {
        String type = getType(record.getRefDesc().get(0));
        List<String> refDesc = compressRefDesc(record.getRefDesc());
        String partNumber = (Pattern.matches(IUYD,  record.getPartNumber().toUpperCase())) ? "" : record.getPartNumber();
        String count = record.getCount();
        List<String> commit = getCommit(type, record.getPartNumber());
        return new Record(TYPE.getOrDefault(type, "Элемент"), refDesc, partNumber, count, commit);
    }

    private static List<String> getCommit(String type, String partNumber) {
        List<String> com = new ArrayList<>();
        if (Pattern.matches(IUYD, partNumber.toUpperCase())) {
            com.add(TYPE.getOrDefault(type, "Элемент") + VIPOLNEN);
            if (Pattern.matches(CONSTRUCTIVNO, partNumber.toUpperCase()))
                com.add(CONSTRUCTIVNO);
            else
                com.add(TOPOLOGIY);
            com.add(partNumber.toUpperCase().replaceAll(NUMBER, ""));
        } else if (Pattern.matches(RNIIRS, partNumber.toUpperCase())) {
            com.add("");
        } else {
            com.add(POKUPNOE);
        }
        return com;
    }
}
