package ru.startandroid.dialog_progress2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (findViewById(R.id.btn_Open)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProgressDialog();
            }
        });
    }

    private void openProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Initializing");
        progressDialog.setMessage("It's loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setProgress(0);
        progressDialog.setMax(100);
        progressDialog.show();

        final Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                progressDialog.setProgress(progressDialog.getProgress()+1);
                return true;
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressDialog.getProgress()<progressDialog.getMax()){
                    try {
                        Thread.sleep(30);
                        handler.sendMessage(handler.obtainMessage());
                        if (progressDialog.getProgress()==progressDialog.getMax()){
                            progressDialog.dismiss();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}