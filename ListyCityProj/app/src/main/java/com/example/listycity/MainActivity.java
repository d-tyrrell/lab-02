package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    // Declare variables:
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    // contains the list of cities

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

    }

    public void clearList(View view){
        dataList.clear();
    }
}