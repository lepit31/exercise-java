package atchik;

import java.util.ArrayList;
import java.util.Date;

public class LogsA {

    private ArrayList<String> content;


    public LogsA() {
        this.content = new ArrayList<>();
    }

    public String addRow(int id, Date date, Severity severity, String message) {
        String row = formatRow(id, date, severity, message);
        content.add(row);
        return row;
    }


    public String formatRow(int id, Date date, Severity severity, String message) {
        return String.format("%d - %ts - %d - %s", id, date, severity.getValue(), message);
    }

    public ArrayList<String> getContent() {
        return content;
    }
}
