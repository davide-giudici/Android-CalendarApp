package it.scalve.davidegiudici.myfirstapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class CalendarCalculator {

    private String INITIAL_DATE = "06/19/2017";
    private Date startDate;
    private Date currentDate;
    private SimpleDateFormat monthDayYear = new SimpleDateFormat("MM/dd/yyyy", Locale.ITALIAN);

    public CalendarCalculator(int day, int month, int year) throws ParseException
    {
        startDate = monthDayYear.parse(INITIAL_DATE);
        currentDate = monthDayYear.parse(month + "/" + day + "/" + year);
    }


    private long differenceDay(Date from, Date to)
    {
        long different = to.getTime() - from.getTime();
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        return TimeUnit.DAYS.convert(different, TimeUnit.MILLISECONDS);

        //return (different / daysInMilli);
    }

    private int calcWeek(Date date)
    {
        Date dateOfMonday = getMondayOf(date);
        long elapsedDays = differenceDay(startDate, dateOfMonday);

        // Dal numero di giorni trascorsi, calcolo la settimna
        int week = (int)((elapsedDays/7) % 5) + 1;

        return week;
    }

    public int getDayOfWeek()
    {
        Calendar c = Calendar.getInstance(Locale.ITALY);
        c.setTime(currentDate);

        c.setFirstDayOfWeek(Calendar.MONDAY);

        int dayOfWeek = getDayOfWeek(c);

        return dayOfWeek;
    }

    public int calcWeek() throws ParseException
    {
        return (int) calcWeek(currentDate);
    }

    private int getDayOfWeek(Calendar c)
    {
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0)
            dayOfWeek = 7;

        return dayOfWeek;
    }

    private Date getMondayOf(Date date)
    {
        Calendar c = Calendar.getInstance();

        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);

        int today = getDayOfWeek(c);

        c.add(Calendar.DAY_OF_WEEK, -today+Calendar.MONDAY);
        return c.getTime();
    }

}
