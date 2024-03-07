package com.khokan_gorain.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.khokan_gorain.covid19.R;

public class dasbode_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasbode_);
        setTitle("COVID-19");
    }
    public void home(View view) {
        Intent intent=new Intent(dasbode_Activity.this,MainActivity.class);
        startActivity(intent);

    }

    public void countries(View view) {
        Intent intent=new Intent(dasbode_Activity.this,affected_countries_activity.class);
        startActivity(intent);
    }

    public void covid19(View view) {
        Intent intent =new Intent(dasbode_Activity.this,corona_activity.class);
        startActivity(intent);
    }

    public void dev(View view) {
        Intent intent = new Intent(dasbode_Activity.this,khokan.class);
        startActivity(intent);
    }

    public void ban(View view) {
        Toast.makeText(this, "You Are Safe", Toast.LENGTH_SHORT).show();
    }
}
