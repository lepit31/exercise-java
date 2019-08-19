package atchik;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class LogsUtilsTest {

    LogsUtils lu = new LogsUtils();

    LogsA logsA = new LogsA();
    LogsB logsB = new LogsB();

    Date date = new Date();
    Long time = date.getTime();


    @Before
    public void init() {
        //initialize logsA and LogsB
        for (int i = 0; i < 100; i++) {
            date.setTime(time + i * 1000);
            logsA.addRow(100 + i, date, Severity.getSeverityByValue(i % 4), "Message id : " + (100 + i));
            date.setTime(time + 50000 + i * 1000);
            logsB.addRow(152 + i, date, Severity.getSeverityByValue(i % 4), "Message id : " + (152 + i));
        }

    }


    @Test
    public void rowAToRowCAndRowBToRowC() {
        RowC rowCfromLogsA = lu.rowAToRowC(logsA.getContent().get(52));
        RowC rowCfromLogsB = lu.rowBToRowC(logsB.getContent().get(0));
        Assert.assertEquals("Expected Row from Logs A and B to be equals ", rowCfromLogsA, rowCfromLogsB);
    }

    @Test
    public void getNbCommonRow() {
        Assert.assertEquals("Expected Nb common row ", 48, lu.getNbCommonRow(logsA, logsB));

    }

    @Test
    public void getNbDistinctRows() {
        Assert.assertEquals("Expected Nb common row ", 52, lu.getNbCommonRow(logsA, logsB));
    }

    @Test
    public void getNbRowsBySeverity() {
        Assert.assertEquals("Nb ERROR", lu.getNbRowsBySeverity(logsA, logsB, Severity.ERROR), 50);
        Assert.assertEquals("Nb WARNING", lu.getNbRowsBySeverity(logsA, logsB, Severity.WARNING), 50);
        Assert.assertEquals("Nb INFO", lu.getNbRowsBySeverity(logsA, logsB, Severity.INFO), 50);
        Assert.assertEquals("Nb DEBUG", lu.getNbRowsBySeverity(logsA, logsB, Severity.DEBUG), 50);
    }

    @Test
    public void getLogsByDate() {
        LogsC result = lu.getLogsByDate(logsA, logsB);
        Assert.assertTrue("The array list must be sorted by chronological date ", result.getContent().get(0).getDate().getTime() < result.getContent().get(101).getDate().getTime());
        Assert.assertTrue("The array list must be sorted by chronological date ", result.getContent().get(103).getDate().getTime() < result.getContent().get(108).getDate().getTime());
    }
}