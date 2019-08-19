package atchik;

public enum Severity {
    ERROR(0),
    WARNING(1),
    INFO(2),
    DEBUG(3);

    private int value;

    private Severity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Severity getSeverityByValue(int value) {
        for (Severity severity : Severity.values()) {
            if (severity.value == value) {
                return severity;
            }
        }
        return Severity.ERROR;
    }
}
