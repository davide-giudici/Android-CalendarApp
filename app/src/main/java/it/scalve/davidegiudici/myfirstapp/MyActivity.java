package it.scalve.davidegiudici.myfirstapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class MyActivity extends ActionBarActivity {

    public final static String EXTRA_WEEK = "com.mycompany.myfirstapp.WEEK";
    public final static String EXTRA_DATA = "com.mycompany.myfirstapp.DATA";

    private CalendarCalculator shiftCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        shiftCalculator = new CalendarCalculator();

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                
                showWorkshift(dayOfMonth, month, year);
            }
        });


        showTodayWorkshift();
    }

    private void showTodayWorkshift() {
        Calendar c = Calendar.getInstance(Locale.ITALY);
        Date d = new Date();
        c.setTime(d);
        showWorkshift(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
    }

    private void showWorkshift(Integer day, Integer month, Integer year) {

        Date selectedDate = new GregorianCalendar(year, month, day).getTime();

        Integer week = shiftCalculator.calcWeek(selectedDate);
        Integer dayOfWeek = shiftCalculator.getDayOfWeek(selectedDate);

        DataAdapter data = new DataAdapter();
        String result = data.getTurnoDescription(week, dayOfWeek);

        // Scrivo la data sulla label
        TextView textView = (TextView) findViewById(R.id.show_result);
        textView.setTextSize(40);
        textView.setText(result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
