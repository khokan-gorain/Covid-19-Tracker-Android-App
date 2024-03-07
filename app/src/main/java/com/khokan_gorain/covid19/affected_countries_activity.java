package com.khokan_gorain.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.khokan_gorain.covid19.R;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class affected_countries_activity extends AppCompatActivity {
    EditText edSearch;
    ListView listView;
    SimpleArcLoader simpleArcLoader;

    public static List<countryModel> countryModelList =new ArrayList<>();
    countryModel countryModel;
    MyCountomAdapter myCountomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affected_countries_activity);
            this.setTitle("Affected Countries");

        edSearch=(EditText) findViewById(R.id.edSearch);
       listView =(ListView)findViewById(R.id.listView);
        simpleArcLoader=findViewById(R.id.loder);

        fetchData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),Main2Activity.class).putExtra("position",position));
            }
        });

        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            myCountomAdapter.getFilter().filter(s);
            myCountomAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





    }

    private void fetchData() {
        String url="https://corona.lmao.ninja/v2/countries/";
       simpleArcLoader.start();
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String countryName = jsonObject.getString("country");
                                String cases = jsonObject.getString("cases");
                                String todayCases = jsonObject.getString("todayCases");
                                String deaths = jsonObject.getString("deaths");
                                String todayDeaths = jsonObject.getString("todayDeaths");
                                String recovered = jsonObject.getString("recovered");
                                String active = jsonObject.getString("active");
                                String critical = jsonObject.getString("critical");

                                JSONObject object = jsonObject.getJSONObject("countryInfo");
                                String flagurl = object.getString("flag");

                                countryModel = new countryModel(flagurl,countryName,cases,todayCases,deaths,todayDeaths,recovered,active,critical);
                                countryModelList.add(countryModel);
                            }

                            myCountomAdapter = new MyCountomAdapter(affected_countries_activity.this,countryModelList);
                            listView.setAdapter(myCountomAdapter);
                           simpleArcLoader.stop();
                           simpleArcLoader.setVisibility(View.GONE);

                        } catch (JSONException e) {
                            e.printStackTrace();
                           simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(View.GONE);
                        }

                    }




        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(affected_countries_activity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
               simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);

            }

        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
