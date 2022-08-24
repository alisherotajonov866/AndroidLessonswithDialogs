package ru.startandroid.datapickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

// DatePickerDialog was done implement to working with Date Dialog
public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView tvDate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDate = findViewById(R.id.tvDate);

        // Button bosgan vaqtimizda 'showDatePickerDialog' deb nomlagan method imiz ishga tushadi.
        (findViewById(R.id.btnDate)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

    }

    // Bu method da 'DatePickerDialog' class idan kerakli malumotlar olinadi va calanedar ko'rsatiladi
    // shu yerda calendar ko'rsatish uchun kodlar tugaydi
    private void showDatePickerDialog() {

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    // Bu method calendar da belgilangan sanani ko'rsatish textview da ko'rsatish uchun

    // WARNING! android studio da oy kunlari 0 dan index langan (0-11)
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        int selectedMonth = month + 1 ;
        String date = day + "." + selectedMonth + "." + year ;
        tvDate.setText(date);

    }
}