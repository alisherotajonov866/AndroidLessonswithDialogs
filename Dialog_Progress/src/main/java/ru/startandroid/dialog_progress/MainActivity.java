package ru.startandroid.dialog_progress;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting object from progressDialog
                progressDialog = new ProgressDialog(MainActivity.this);

                // turn on 'show' method
                progressDialog.show();

                // bu yerda progressDialog qaysi layout da ko'rsatilishi kerak bo'lsa shu layout object ga set qilinishi kerak.
                // biz bu holatda o'zimiz layout yaratib uni set qildik
                progressDialog.setContentView(R.layout.progress_dialog);

                //
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            }
        });
    }

    // Bu method progressDialog niki
    // vazifasi progressDialog ni ishlab turgan vaqti, to'xtatish
    @Override
    public void onBackPressed() {
        progressDialog.dismiss();
    }
}