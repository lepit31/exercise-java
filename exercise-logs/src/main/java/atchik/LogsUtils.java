package atchik;

public class LogsUtils {
    public LogsUtils() {
    }

    public RowC rowAToRowC(String rowA) {
        RowC response = null;
        //TODO implement method
        return response;
    }


    public RowC rowBToRowC(String rowB) {
        RowC response = null;
        //TODO implement method
        return response;
    }

    public LogsC logsAToLogsC(LogsA logsA) {

        LogsC result = new LogsC();
        //TODO implement method
        return result;
    }

    public LogsC logsBToLogsC(LogsB logsB) {

        LogsC result = new LogsC();
        //TODO implement method
        return result;
    }

    //Return nb common row ( same id)  in logs A and B
    public int getNbCommonRow(LogsA logsA, LogsB logsB) {
        int response = 0;
        //TODO implement method
        return response;
    }

    //Return the number of distinct (by id) rows in Logs A and B
    public int getNbDistinctRows(LogsA logsA, LogsB logsB) {
        int response = 0;
        //TODO implement method
        return response;
    }


    //Return the number of rows in Logs A and B by Severity
    public int getNbRowsBySeverity(LogsA logsA, LogsB logsB, Severity severity) {
        int response = 0;
        //TODO implement method
        return response;
    }

    //Return All logs from Logs A and B sorted in chronological order
    public LogsC getLogsByDate(LogsA logsA, LogsB logsB) {
        LogsC response = new LogsC();
        //TODO implement method
        return response;
    }

}
