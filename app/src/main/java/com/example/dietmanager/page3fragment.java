package com.example.dietmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class page3fragment extends AppCompatActivity {

    private String page;
    private TextView calorie, protein, carbs, fats;
    private Button send;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);
        calorie = findViewById(R.id.enterCalorie);
        protein = findViewById(R.id.enterProtein);
        carbs = findViewById(R.id.enterCarbohydrate);
        fats = findViewById(R.id.enterFats);
        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
        Intent intent = getIntent();
        page = intent.getStringExtra("page");
        if (page.equals("1")) {
           send.setText("Set");
        }
        else {
            send.setText("Search");
        }
    }

    private void send() {
        if (page.equals("0")) {
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            JSONObject json = new JSONObject();
            try {
                json.put("calorie", calorie.getText().toString());
                json.put("carbs", carbs.getText().toString());
                json.put("protein", protein.getText().toString());
                json.put("fats", fats.getText().toString() );
            } catch (JSONException e) {
                e.printStackTrace();
            }

            String url = Endpoints.GET_FOOD;
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, json,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Intent i = new Intent(getApplicationContext(), Output.class);
                            try {
                                i.putExtra("calorie", response.getString("calorie"));
                                i.putExtra("carbs", response.getString("carbs"));
                                i.putExtra("protein", response.getString("protein"));
                                i.putExtra("fats", response.getString("fats"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            startActivity(i);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            requestQueue.add(jsonObjectRequest);
        } else if (page.equals("1")) {
            page1fragment.setTexts(calorie.getText().toString(), protein.getText().toString(), carbs.getText().toString(), fats.getText().toString());
            finish();
        } else if (page.equals("2")) {

        }
    }

}