import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class TestProcessTime {


    // a message have 2 dates : the reception date (startDate) and the archived date (endDate)
    // the process time is only calculated during the period of activity define by startActiveHour(0-23) , startActiveMinute (0-59) ,endActiveHour (1-24)  , endActiveMinute (0-59)
    // LIMITATION : less than 48h between the startDate and the endDate
    // return in seconds the process time

    public long calculateProcessTime (@NotNull Instant startDate , @NotNull Instant endDate , int startActiveHour , int startActiveMinute , int endActiveHour , int endActiveMinute ){

        long processTime = 0;

        return processTime;

    }


    @Test
    public void testSameDayNoInActive() {

        int startActiveHour  = 0;
        int startActiveMinute = 00;
        int endActiveHour = 24;
        int endActiveMinute = 0;


        Instant start = Instant.parse("2021-02-10T23:59:59Z");
        Instant end = Instant.parse("2021-02-11T00:00:01Z");


        long processTime = calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);
        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(2);
    }


    @Test
    public void testSameDayStartAndEndActive() {

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 20;
        int endActiveMinute = 30;


        Instant start = Instant.parse("2021-02-10T16:25:01Z");
        Instant end = Instant.parse("2021-02-10T17:25:01Z");


        long processTime = calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);
        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(3600);
    }

    @Test
    public void testSameDayStartAndEndActive2() {

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 24;
        int endActiveMinute = 00;


        Instant start = Instant.parse("2021-02-10T20:59:59Z");
        Instant end = Instant.parse("2021-02-10T23:59:59Z");


        long processTime = calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);
        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(10800);
    }


    @Test
    public void testSameDayStartInactive() {

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 20;
        int endActiveMinute = 30;


        Instant start = Instant.parse("2021-02-10T05:25:01Z");
        Instant end = Instant.parse("2021-02-10T17:25:01Z");


        long processTime = calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);
        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(35701);
    }

    @Test
    public void testSameDayEndInactive() {

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 20;
        int endActiveMinute = 30;


        Instant start = Instant.parse("2021-02-10T17:25:01Z");
        Instant end = Instant.parse("2021-02-10T23:25:01Z");


        long processTime =calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);
        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(11099);
    }

    @Test
    public void testSameDayStartAndEndInactive() {

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 20;
        int endActiveMinute = 30;


        Instant start = Instant.parse("2021-02-10T06:25:01Z");
        Instant end = Instant.parse("2021-02-10T23:25:01Z");


        long processTime =calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);

        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(46800);
    }


    @Test
    public void testOtherDayStartAndEndActive() {

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 20;
        int endActiveMinute = 30;


        Instant start = Instant.parse("2021-02-10T16:25:01Z");
        Instant end = Instant.parse("2021-02-11T17:25:01Z");


        long processTime =calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);
        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(50400);
    }

    @Test
    public void testOtherDayStartAndEndActive2() {

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 24;
        int endActiveMinute = 00;


        Instant start = Instant.parse("2021-02-10T20:59:59Z");
        Instant end = Instant.parse("2021-02-11T23:59:59Z");


        long processTime =calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);
        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(70200);
    }

    @Test
    public void testOtherDayStartAndEndActive3() {

        int startActiveHour  = 0;
        int startActiveMinute = 0;
        int endActiveHour = 24;
        int endActiveMinute = 00;


        Instant start = Instant.parse("2021-02-10T20:59:59Z");
        Instant end = Instant.parse("2021-02-11T23:59:59Z");


        long processTime =calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);
        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(97200);
    }


    @Test
    public void testOtherDayStartInactive() {

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 20;
        int endActiveMinute = 30;


        Instant start = Instant.parse("2021-02-10T05:25:01Z");
        Instant end = Instant.parse("2021-02-11T17:25:01Z");


        long processTime =calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);
        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(82501);
    }

    @Test
    public void testOtherDayEndInactive() {

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 20;
        int endActiveMinute = 30;


        Instant start = Instant.parse("2021-02-10T17:25:01Z");
        Instant end = Instant.parse("2021-02-11T23:25:01Z");


        long processTime =calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);
        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(57899);
    }

    @Test
    public void testOtherDayStartAndEndInactive() {

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 20;
        int endActiveMinute = 30;


        Instant start = Instant.parse("2021-02-10T06:25:01Z");
        Instant end = Instant.parse("2021-02-11T23:25:01Z");


        long processTime =calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);

        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(93600);
    }


    @Test
    public void testVeryLongPeriod() {

        long result =93600;

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 20;
        int endActiveMinute = 30;

// 1 day between date
        Instant start = Instant.parse("2021-02-10T06:25:01Z");
        Instant end = Instant.parse("2021-02-11T23:25:01Z");

        long processTime =calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);

        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(result);


        // 10 days between date
        start = Instant.parse("2021-02-01T06:25:01Z");
        end = Instant.parse("2021-02-11T23:25:01Z");

        processTime =calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);

        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(result);


    }

    @Test
    public void testBetween2Year() {

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 20;
        int endActiveMinute = 30;


        Instant start = Instant.parse("2020-12-31T06:25:01Z");
        Instant end = Instant.parse("2021-01-01T23:25:01Z");


        long processTime =calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);

        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(93600);
    }

    @Test
    public void testPublishDateLargerThanDecision() {

        int startActiveHour  = 7;
        int startActiveMinute = 30;
        int endActiveHour = 20;
        int endActiveMinute = 30;


        Instant start = Instant.parse("2021-01-04T10:25:01Z");
        Instant end =   Instant.parse("2021-01-04T09:25:01Z");


        long processTime =calculateProcessTime(start,end,startActiveHour,startActiveMinute,endActiveHour,endActiveMinute);

        System.out.println( "seconde :" + processTime +  " min :" + processTime/60 + " heure : "+ processTime/(60*60) );
        assertThat(processTime).isEqualTo(0);
    }


}
