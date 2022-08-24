package ru.startandroid.donotdismissdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Bu dialog user tomonidan qaysidir harakat bajarilgan vaqti, shu harakat aniq to'g'riligini aniqlash uchun qo'llaniladi
    // bizda harakatni tasdiqlash uchun 'ok' va orqaga qaytish va harakatni bekor qilish uchun 'cancel' tugmalari mavjud

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // android ning o'zini 'AlertDialog' classidan foydalandik
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Example Message")
                .setPositiveButton("Ok",null)
                .setNegativeButton("Cancel",null)
                .show();

        // 'Ok' tugmasi bosilganda misol uchun biror xabar o'chirishi tasdiqlanishi mumkun edi va xabar o'chirilib, dialog yupilar edi
        // bizdagi 'ok' tugmasi hali hech qanday operatsiya bajarmaydi, va dialog oynasini ham yopib bilmaydi
        // so, biz toast yordamida "Not closing" xabarini user ga uzatish bilan kifoyalanamiz
        Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Not Closing", Toast.LENGTH_SHORT).show();
            }
        });
    }
}