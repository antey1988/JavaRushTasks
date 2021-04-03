package Perechni;

import java.util.List;

public class Record {
    private final String razdel = "@";
    private String type;
    private List<String> refDesc;
    private String partNumber;
    private String count;
    private List<String> commit;

    public Record(String type, List<String> refDesc, String partNumber, String count, List<String> commit) {
        this.type = type;
        this.refDesc = refDesc;
        this.partNumber = partNumber;
        this.count = count;
        this.commit = commit;
    }

    public Record(List<String> refDesc, String partNumber, String count) {
        this.refDesc = refDesc;
        this.partNumber = partNumber;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public List<String> getRefDesc() {
        return refDesc;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getCount() {
        return count;
    }

    public List<String> getCommit() {
        return commit;
    }

    @Override
    public String toString() {
        /*String typ = type == null ? "" : type;
        if (commit == null)
            commit = new ArrayList<>(Arrays.asList(new String[]{""}));*/
        int max = Math.max(refDesc.size(), commit.size());
        StringBuilder allStrings =
                new StringBuilder(refDesc.get(0)).append(razdel).append(partNumber.equals("") ? "" : type + " " + partNumber)
                        .append(razdel).append(count).append(razdel).append(commit.get(0));
        for (int i = 1; i < max; i++) {
            String refdesc;
            try {
                refdesc = refDesc.get(i);
            } catch (IndexOutOfBoundsException e) {
                refdesc = "";
            }
            String com;
            try {
                com = commit.get(i);
            } catch (IndexOutOfBoundsException e) {
                com = "";
            }
            allStrings.append("\n" + refdesc).append(razdel)
                    .append(razdel).append(razdel).append(com);
        }
        return allStrings.toString();
    }

}
