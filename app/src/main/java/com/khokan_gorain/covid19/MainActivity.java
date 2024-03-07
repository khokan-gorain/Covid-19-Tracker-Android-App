package com.khokan_gorain.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.khokan_gorain.covid19.R;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView tvCases,tvtodayCases,tvdeaths,tvtodayDeaths,tvrecovered,tvactive,tvcritical,tvaffectedCountries;
    SimpleArcLoader simpleArcLoader;
    ScrollView scrollView;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Global State");

        tvCases=findViewById(R.id.tvCases);
        tvtodayCases=findViewById(R.id.tvtodayCases);
        tvdeaths=findViewById(R.id.tvdeaths);
        tvtodayDeaths=findViewById(R.id.tvtodayDeaths);
        tvrecovered=findViewById(R.id.tvrecovered);
        tvactive=findViewById(R.id.tvactive);
        tvcritical=findViewById(R.id.tvcritical);
        tvaffectedCountries=findViewById(R.id.tvaffectedCountries);

        simpleArcLoader=findViewById(R.id.loader);
        scrollView =findViewById(R.id.scrollStatus);
        pieChart =findViewById(R.id.piechart);
        fetchData();
    }

    private void fetchData() {
        String url="https://corona.lmao.ninja/v2/all/";
        simpleArcLoader.start();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    tvCases.setText(jsonObject.getString("cases"));
                    tvtodayCases.setText(jsonObject.getString("todayCases"));
                    tvdeaths.setText(jsonObject.getString("deaths"));
                    tvtodayDeaths.setText(jsonObject.getString("todayDeaths"));
                    tvrecovered.setText(jsonObject.getString("recovered"));
                    tvactive.setText(jsonObject.getString("active"));
                    tvcritical.setText(jsonObject.getString("critical"));
                    tvaffectedCountries.setText(jsonObject.getString("affectedCountries"));

                    pieChart.addPieSlice(new PieModel("cases", Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#ED8A0D")));
                    pieChart.addPieSlice(new PieModel("Active", Integer.parseInt(tvactive.getText().toString()), Color.parseColor("#9809BD")));
                    pieChart.addPieSlice(new PieModel("Recovered", Integer.parseInt(tvrecovered.getText().toString()), Color.parseColor("#05950C")));
                    pieChart.addPieSlice(new PieModel("Deaths", Integer.parseInt(tvdeaths.getText().toString()), Color.parseColor("#C30B06")));
                    pieChart.startAnimation();

                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);


                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
            }

        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
