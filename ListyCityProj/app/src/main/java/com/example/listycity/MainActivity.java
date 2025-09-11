package com.example.listycity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    boolean deleteMode = false;
    // whether deletion is available

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

        // listen for items clicked
        cityList.setOnItemClickListener((parent, view, position, id) -> {
            String clickedCity = dataList.get(position);

            if (deleteMode) {   // only delete if you're in "delete city" mode
                dataList.remove(position);
                cityAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Deleted: " + clickedCity, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Clicked: " + clickedCity, Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void enableInput(View view){
        // enables the input box
        findViewById(R.id.addcity).isEnabled();
        Log.d("entercity", "enabled");
    }

    public void addCity(View view){
        // adds the city to the list
       TextView text = findViewById(R.id.enterCity);
        String newCity = text.getText().toString();
        dataList.add(newCity);
        cityAdapter.notifyDataSetChanged();  // refreshes the ListView


    }

    public void deleteCity(View view){
        // toggles delete mode on click
        deleteMode = !deleteMode;
    }


}