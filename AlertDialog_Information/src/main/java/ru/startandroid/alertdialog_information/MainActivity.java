package ru.startandroid.alertdialog_information;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnClick;
    EditText etInput ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);

        btnClick = findViewById(R.id.btnClick);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etInput.getText().toString();
                if(text.isEmpty()){
                    alert("Matn kiriting!");
                }
                else
                    alert("Siz " + text + " so'zini kiritdingiz!");

            }
        });
    }

    // creating alert method with its String value
    private void alert(String message){
        // getting object from AlertDialog
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Ogohlantirish!")
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dismiss method i ok tugmasi bosilganda dialog imizni yopilishini anglatadi
                        dialogInterface.dismiss();
                    }
                })
                .create();
        alertDialog.show();
    }
}