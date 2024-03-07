package com.khokan_gorain.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.khokan_gorain.covid19.R;

public class corona_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona_activity);
        this.setTitle("Covid-19");
    }
}
