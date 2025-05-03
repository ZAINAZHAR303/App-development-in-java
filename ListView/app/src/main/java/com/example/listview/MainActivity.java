package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    ArrayList<String> arrFruits;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.myListView); // link to XML
        arrFruits = new ArrayList<>();

// Add data to the list
        arrFruits.add("Apple");
        arrFruits.add("Banana");
        arrFruits.add("Cherry");

// Create Adapter to connect data to ListView
        adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.simple_list_item_1,R.id.tv1, arrFruits);

// Set adapter to ListView
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Example: Show toast
                Toast.makeText(getApplicationContext(), "Clicked: " + arrFruits.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }
}