package ru.startandroid.p0581_timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Turning clickable=true at the textview and
    // adding onClick function

    //
    int DIALOG_TIME = 1 ;
    int myHour = 14 ;
    int myMinute = 35 ;
    TextView tvTime ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = (TextView) findViewById(R.id.tvTime);
    }

    public void onClick(View view){
        showDialog(DIALOG_TIME);
    }

    
}