/*
 * 모바일 프로그래밍 002분반 소프트웨어 융합학과 20191937 정형준
 */

package com.example.mobileapp_junghyungjoon;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity
{
    Chronometer chrono;
    RadioButton radioCal;
    RadioButton radioTime;
    DatePicker datePicker;
    TimePicker timepicker;

    RadioGroup radioGroup;

    TextView textViewYear;
    TextView textViewMonth;
    TextView textViewDay;
    TextView textViewHour;
    TextView textViewMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setTheme(androidx.appcompat.R.style.Theme_AppCompat);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("시간 예약");

        chrono = (Chronometer) findViewById(R.id.chronometer1);

        radioCal = (RadioButton) findViewById(R.id.rdoCal);
        radioTime = (RadioButton) findViewById(R.id.rdoTime);

        datePicker = (DatePicker) findViewById(R.id.datePicker1);
        timepicker = (TimePicker) findViewById(R.id.timePicker1);

        radioGroup = (RadioGroup) findViewById(R.id.RadioList);

        textViewYear = (TextView) findViewById(R.id.tvYear);
        textViewMonth = (TextView) findViewById(R.id.tvMonth);
        textViewDay = (TextView) findViewById(R.id.tvDay);
        textViewHour = (TextView) findViewById(R.id.tvHour);
        textViewMinute = (TextView) findViewById(R.id.tvMinute);

        radioCal.setVisibility(View.INVISIBLE);
        radioTime.setVisibility(View.INVISIBLE);
        timepicker.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);

        radioCal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                timepicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.VISIBLE);
            }
        });

        radioTime.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                timepicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
            }
        });

        chrono.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
                radioCal.setVisibility(View.VISIBLE);
                radioTime.setVisibility(View.VISIBLE);
            }
        });

        textViewYear.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view)
            {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                textViewYear.setText(Integer.toString(datePicker.getYear()));
                textViewMonth.setText(Integer.toString((datePicker.getMonth() + 1)));
                textViewDay.setText(Integer.toString(datePicker.getDayOfMonth()));

                textViewHour.setText(Integer.toString(timepicker.getCurrentHour()));
                textViewMinute.setText(Integer.toString(timepicker.getCurrentMinute()));

                radioCal.setVisibility(View.INVISIBLE);
                radioTime.setVisibility(View.INVISIBLE);
                timepicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);

                // 라디오 버튼 초기화 기능
                radioGroup.clearCheck();

                return false;
            }
        });
    }
}