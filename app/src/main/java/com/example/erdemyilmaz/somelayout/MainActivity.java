package com.example.erdemyilmaz.somelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.StringTokenizer;

import static com.example.erdemyilmaz.somelayout.R.id.textView1;

public class MainActivity extends AppCompatActivity {

    public enum Day
    {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = (displayMetrics.heightPixels  >= displayMetrics.widthPixels) ? displayMetrics.heightPixels : displayMetrics.widthPixels; //always greater
        int height = (displayMetrics.heightPixels <  displayMetrics.widthPixels) ? displayMetrics.heightPixels : displayMetrics.widthPixels;

        if (1260<width && 1400>width && 730<height && 900>height ) {
            setContentView(R.layout.activity_main_800_1280);
            Log.e("SSS-width","Loading 800-1280");
        } else  if (1004<width && width<1044 && 530<height && height<601) {
            setContentView(R.layout.activity_main_600_1024);
            Log.e("SSS-width","Loading 600-1024");
        } else  if (1400<width  && 900<height) {
            setContentView(R.layout.activity_main_1440_2960);
            Log.e("SSS-width","Loading 600-1024");
        } else {
            setContentView(R.layout.activity_main);
            Log.e("SSS-width","Loading 800-1280 because else if failed");
        }

        Log.e("SSS-height",String.valueOf(height));
        Log.e("SSS-width",String.valueOf(width));

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        //findSetTextSizes();


        //TextView textView1 =  (TextView)findViewById(R.id.textView1);
        //TextView textView2 =  (TextView)findViewById(R.id.textView2);
        //TextView textView3 =  (TextView)findViewById(R.id.textView3);

        //int textSizeInSp = (int) getResources().getDimension(R.dimen.result_font);
        // textView1.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.result_font));
        // textView2.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.result_font));
        // textView3.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.result_font));

        getScreenValues();

        Thread t = new Thread() {

            @Override
            public void run() {
                String[] s1 = new String[3];
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(900);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                getScreenValues();

                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();

    }

    public void findSetTextSizes(){
        setTextSizes(50, 50, 50);
    }

    public void setTextSizes(Integer s1, Integer s2, Integer s3)
    {
        TextView textView1 =  (TextView)findViewById(R.id.textView1);
        TextView textView2 =  (TextView)findViewById(R.id.textView2);
        TextView textView3 =  (TextView)findViewById(R.id.textView3);
        int textSizeInSp = (int) getResources().getDimension(R.dimen.result_font);
        //textView1.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.result_font));
        //textView2.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.result_font));
        //textView3.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.result_font));
        textView1.setTextSize(TypedValue.COMPLEX_UNIT_PX, s1);
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_PX, s2);
        textView3.setTextSize(TypedValue.COMPLEX_UNIT_PX, s3);
    }

    public void getScreenValues() {
        Calendar calendar = Calendar.getInstance();

        int year       = calendar.get(Calendar.YEAR);
        int month      = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);

        int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
        int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
        int minute     = calendar.get(Calendar.MINUTE);
        int second     = calendar.get(Calendar.SECOND);
        int millisecond= calendar.get(Calendar.MILLISECOND);

        String[] DAY_MAP = new String[] {
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY",
                "THURSDAY",
                "FRIDAY",
                "SATURDAY",
                "SUNDAY"
        };



        String[] MONTH_MAP = new String[] {
                "JANUARY",
                "FEBRUARY",
                "MARCH",
                "APRIL",
                "MAY",
                "JUNE",
                "JULY",
                "AUGUST",
                "SEPTEMBER",
                "OCTOBER",
                "NOVEMBER",
                "DECEMBER"
        };


        String[] HOUR_MAP = new String[] {
                "NIGHT", // 00
                "NIGHT", // 1
                "NIGHT", // 2
                "NIGHT", // 3
                "NIGHT", // 4
                "EARLY MORNING", // 5
                "EARLY MORNING", // 6
                "EARLY MORNING", // 7
                "MORNING", // 8
                "MORNING", // 9
                "LATE MORNING", // 10
                "LATE MORNING   ", // 11
                "EARLY AFTERNOON", // 12
                "EARLY AFTERNOON", // 13
                "AFTERNOON", // 14
                "AFTERNOON", // 15
                "LATE AFTERNOON", // 16
                "LATE AFTERNOON", // 17
                "EARLY EVENING", // 18
                "EARLY EVENING", // 19
                "EVENING", // 19
                "EVENING", // 20
                "NIGHT", //21
                "NIGHT", //22
                "NIGHT" //23
        };




        String[] s = new String[3];
        s[0] = String.valueOf(year);
        s[1] = String.valueOf(second);
        s[2] = String.valueOf(month);

        TextView textView1 =  (TextView)findViewById(R.id.textView1);
        TextView textView2 =  (TextView)findViewById(R.id.textView2);
        TextView textView3 =  (TextView)findViewById(R.id.textView3);

        String showDayAndTimeFrame = Day.values()[dayOfWeek-1] + ", " + HOUR_MAP[hourOfDay];

        textView1.setText(showDayAndTimeFrame);

        String showMonthYear = MONTH_MAP[month] + " " + String.valueOf(dayOfMonth) + " " + String.valueOf(year);
        String showTime = String.valueOf(hour) + " : " + addZeroToTime(minute);


        textView2.setText(showTime);
        textView3.setText(showMonthYear);

    }

    public String addZeroToTime(int t) {
        if (t<10) { return ("0"+String.valueOf(t));}
        return String.valueOf(t);
    }
}
