package atchik;

import java.util.Date;
import java.util.Objects;

public class RowC {

    private int id;
    private Date date;
    private Severity severity;
    private String message;

    public RowC(int id, Date date, Severity severity, String message) {
        this.id = id;
        this.date = date;
        this.severity = severity;
        this.message = message;
    }

    @Override
    public String toString() {
        return "RowC{" +
                "id=" + id +
                ", date=" + date +
                ", severity=" + severity +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowC rowC = (RowC) o;
        return id == rowC.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }
}
