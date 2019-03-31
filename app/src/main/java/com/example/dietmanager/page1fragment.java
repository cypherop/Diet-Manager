package com.example.dietmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class page1fragment extends Fragment implements ActiveFragment {
    private TextView v1,v2,v3,v4,v12,v22,v32,v42;
    private static String s1, s2, s3, s4, s5, s6, s7, s8;
    private Button set;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.page1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v1 = getActivity().findViewById(R.id.v1);
        v2 = getActivity().findViewById(R.id.v2);
        v3 = getActivity().findViewById(R.id.v3);
        v4 = getActivity().findViewById(R.id.v4);
        v12 = getActivity().findViewById(R.id.v12);
        v22 = getActivity().findViewById(R.id.v22);
        v32 = getActivity().findViewById(R.id.v32);
        v42 = getActivity().findViewById(R.id.v42);
        set = getActivity().findViewById(R.id.set);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext() ,page3fragment.class);
                i.putExtra("page", "1");
                startActivity(i);
            }
        });
    }
    public static void setTexts(String v1, String v2, String v3, String v4) {
        s1 = v1;
        s2 = v2;
        s3 = v3;
        s4 = v4;
        s5 = "0";
        s6 = "0";
        s7 = "0";
        s8 = "0";
    }

    public static void add(String v1, String v2, String v3, String v4) {
        if (s5 == null) {
            s5 = "0";
        }
        if (s6 == null) {
            s6 = "0";
        }
        if (s7 == null) {
            s7 = "0";
        }
        if (s8 == null) {
            s8 = "0";
        }
        s5 = String.valueOf(Integer.valueOf(s5)+Integer.valueOf(v1));
        s6 = String.valueOf(Integer.valueOf(s6)+Integer.valueOf(v2));
        s7 = String.valueOf(Integer.valueOf(s7)+Integer.valueOf(v3));
        s8 = String.valueOf(Integer.valueOf(s8)+Integer.valueOf(v4));
    }

    @Override
    public void onResume() {
        super.onResume();
        if(s1 == null) {
            v1.setText("0");
        }
        else {
            v1.setText(s1);
        }
        if(s2 == null) {
            v2.setText("0");
        }
        else {
            v2.setText(s2);
        }
        if(s3 == null) {
            v3.setText("0");
        }
        else {
            v3.setText(s3);
        }
        if(s4 == null) {
            v4.setText("0");
        }
        else {
            v4.setText(s4);
        }
        if(s5 == null) {
            v12.setText("0");
        }
        else {
            v12.setText(s5);
        }
        if(s6 == null) {
            v22.setText("0");
        }
        else {
            v22.setText(s6);
        }
        if(s7 == null) {
            v32.setText("0");
        }
        else {
            v32.setText(s7);
        }
        if(s8 == null) {
            v42.setText("0");
        }
        else {
            v42.setText(s8);
        }
    }
}
