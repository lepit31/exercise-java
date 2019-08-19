package atchik;

import java.util.ArrayList;
import java.util.Date;

public class LogsC {

    private ArrayList<RowC> content;

    public LogsC() {
        this.content = new ArrayList<>();
    }

    public void addRow(int id, Date date, Severity severity, String message) {
        RowC row = new RowC(id, date, severity, message);
        content.add(row);
    }

    public void addRow(RowC rowC) {
        content.add(rowC);
    }

    public ArrayList<RowC> getContent() {
        return content;
    }
}
