package com.example.gichulkim.haibaocalendar;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CalendarActivity extends AppCompatActivity {
    //calendar 관련
    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth=new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    //listview 관련
    ArrayList<Poster> data=new ArrayList<Poster>();
    ArrayList<String> name=new ArrayList<String>();
    PosterAdapter adapter;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Date today=new Date();

        final ActionBar actionBar =getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(dateFormatMonth.format(today));

        compactCalendar=(CompactCalendarView)findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);


        //set an poster
        //포스터 이름 설정
        name.add("사랑의 마라톤");
        name.add("슬기짜기 전시회");

        data.add(new Poster(name.get(0)));
        data.add(new Poster(name.get(1)));

        //adapter
        adapter=new PosterAdapter(this,data);

        listView=(ListView)findViewById(R.id.listview1);

       // Log.d("Error","dkdkddlasmd;asmdadmfl nldsfa어디냐 --");
        final Event ev1=new Event(Color.RED,1533963600000L,data.get(0).getTheme());
        Event ev2=new Event(Color.BLUE,1533963600000L,data.get(1).getTheme());


        compactCalendar.addEvent(ev1);
        compactCalendar.addEvent(ev2);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context=getApplicationContext();

                if(dateClicked.toString().compareTo("Sat Aug 11 00:00:00 GMT+09:00 2018")==0){
                    listView.setAdapter(adapter);

                }else {
                //    Toast.makeText(context,dateClicked.toString(),Toast.LENGTH_SHORT).show();
                    listView.setAdapter(null);
                }


            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });

    }
}
