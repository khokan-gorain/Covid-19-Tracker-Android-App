package com.khokan_gorain.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.khokan_gorain.covid19.R;

public class Main2Activity extends AppCompatActivity {
    private  int positionCountry;
    TextView tvCases,tvtodayCases,tvdeaths,tvtodayDeaths,tvrecovered,tvactive,tvcritical,tvcountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        positionCountry = intent.getIntExtra("position",0);
        this.setTitle("Details of "+affected_countries_activity.countryModelList.get(positionCountry).getCountry());


        tvtodayCases =(TextView)findViewById(R.id.tvtodaycases);
        tvdeaths = findViewById(R.id.tvdeaths);
        tvtodayDeaths = findViewById(R.id.tvtodaydeaths);
        tvrecovered = findViewById(R.id.tvrecovered);
        tvactive = findViewById(R.id.tvactive);
        tvcritical = findViewById(R.id.tvcritical);
        tvcountry = findViewById(R.id.tvcountry);
        tvCases = findViewById(R.id.tvcases);


        tvtodayCases.setText(affected_countries_activity.countryModelList.get(positionCountry).getTodaycases());
        tvdeaths.setText(affected_countries_activity.countryModelList.get(positionCountry).getDeaths());
        tvtodayDeaths.setText(affected_countries_activity.countryModelList.get(positionCountry).getTodaydeaths());
        tvrecovered.setText(affected_countries_activity.countryModelList.get(positionCountry).getRecovered());
        tvactive.setText(affected_countries_activity.countryModelList.get(positionCountry).getActive());
        tvcritical.setText(affected_countries_activity.countryModelList.get(positionCountry).getCritical());
        tvcountry.setText(affected_countries_activity.countryModelList.get(positionCountry).getCountry());
        tvCases.setText(affected_countries_activity.countryModelList.get(positionCountry).getCases());



    }
}
