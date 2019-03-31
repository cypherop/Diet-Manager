package com.example.dietmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Output extends AppCompatActivity {

    private Button add;
    private TextView v1, v2, v3 ,v4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);
        v1 = findViewById(R.id.v1);
        v2 = findViewById(R.id.v2);
        v3 = findViewById(R.id.v3);
        v4 = findViewById(R.id.v4);
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page1fragment.add(v1.getText().toString(), v2.getText().toString(), v3.getText().toString(), v4.getText().toString());
                finish();
            }
        });
        v1.setText(getIntent().getStringExtra("calorie"));
        v2.setText(getIntent().getStringExtra("protein"));
        v3.setText(getIntent().getStringExtra("fats"));
        v4.setText(getIntent().getStringExtra("carbs"));
    }
}
