package it.scalve.davidegiudici.myfirstapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class CalendarCalculator {

    private Integer INITIAL_DATE_DAY = 19;
    private Integer INITIAL_DATE_YEAR = 2017;
    private Integer INITIAL_DATE_MONTH = 06;

    private Date startDate;


    public CalendarCalculator()
    {
        startDate = new GregorianCalendar(INITIAL_DATE_YEAR, INITIAL_DATE_MONTH, INITIAL_DATE_DAY).getTime();
    }

    // Estrae la differenza in giorni tra due date
    private long differenceDay(Date from, Date to)
    {
        long different = to.getTime() - from.getTime();

        return TimeUnit.DAYS.convert(different, TimeUnit.MILLISECONDS);
    }

    // Estrae il numero della settimana del turno
    public Integer calcWeek(Date date)
    {
        // Prendo il lunedi della settimana di 'date'
        Date dateOfMonday = getMondayOf(date);

        // Prendo la differenza tra il lunedì trovato e la data di inizio calendario
        long elapsedDays = differenceDay(startDate, dateOfMonday);

        // Dal numero di giorni trascorsi, calcolo la settimna
        return (int)((elapsedDays/7) % 5) + 1;
    }

    public Integer getDayOfWeek(Date date)
    {
        return getDayOfWeek(buildCalendar(date));
    }

    private Calendar buildCalendar(Date date)
    {
        Calendar calendar = Calendar.getInstance(Locale.ITALY);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);

        return calendar;
    }

    // Restituisce il lunedi della settimana della data in ingresso
    private Date getMondayOf(Date dateInput)
    {
        Calendar calendar = buildCalendar(dateInput);

        Integer inputDateOfWeek = getDayOfWeek(calendar);

        calendar.add(Calendar.DAY_OF_WEEK, Calendar.MONDAY - inputDateOfWeek);
        return calendar.getTime();
    }

    // Restituisce il numero del giorno all'interno della settimana
    private Integer getDayOfWeek(Calendar calendar)
    {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0)
            dayOfWeek = 7;

        return dayOfWeek;
    }
}
