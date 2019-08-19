package atchik;

import java.util.ArrayList;
import java.util.Date;

public class LogsB {

    private ArrayList<String> content;


    public LogsB() {
        this.content = new ArrayList<>();
    }

    public String addRow(int id, Date date, Severity severity, String message) {
        String row = formatRow(id, date, severity, message);
        content.add(row);
        return row;
    }


    public String formatRow(int id, Date date, Severity severity, String message) {
        return String.format("%tD : %s : %s : %d", date, severity, message, id);
    }

    public ArrayList<String> getContent() {
        return content;
    }
}
