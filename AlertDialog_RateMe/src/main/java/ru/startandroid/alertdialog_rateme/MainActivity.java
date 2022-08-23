package ru.startandroid.alertdialog_rateme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {

    // WARNING! Gradle was done implement from github
    // these codes were gotten the github link > https://github.com/hotchemi/Android-Rate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppRate.with(this)
                .setInstallDays(5) // App is launched more than 5 days later than installation.
                .setLaunchTimes(5) // App is launched more than 5 times
                .setRemindInterval(2) // App is launched more than 2 days after neutral button clicked.
                //.setShowLaterButton(true) // App shows neutral dialog(Remind me later) by default
                .monitor(); // for showing

        // must write this code
        AppRate.showRateDialogIfMeetsConditions(this);

        // har safar kirgan vaqti baholash dialog i chiqib keladi
        // AppRate.with(this).showRateDialog(this);
    }
}