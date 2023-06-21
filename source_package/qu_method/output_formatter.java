package qu_method;

import java.util.ArrayList;
import java.util.List;

public class output_formatter {
    private List<String[]> contents;

    public output_formatter() {
        contents = new ArrayList<>();
    }

    public void add(String... fields) {
        contents.add(fields);
    }

    public void clear() {
        contents.clear();
    }

    public String format() {
        StringBuilder ret = new StringBuilder();
        List<Integer> lengths = new ArrayList<>();
        int maxContentLen = 0;
        for (String[] row : contents) {
            maxContentLen = Math.max(maxContentLen, row.length);
        }

        for (int i = 0; i < maxContentLen; i++) {
            int len = 1;
            for (String[] row : contents) {
                try {
                    len = Math.max(len, row[i].length());
                } catch (IndexOutOfBoundsException ignore) {}
            }
            lengths.add(len);
        }

        for (String[] row : contents) {
            for (int i = 0; i < row.length; i++) {
                ret.append(row[i] + " ".repeat(lengths.get(i) - row[i].length() + 1));
            }
            ret.append(System.lineSeparator());
        }

        return ret.toString();
    }
}