package com.example.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView RV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ArrayList<ModelFruit> list = new ArrayList<>();
        list.add(new ModelFruit(R.drawable.apple,"Apple"));
        list.add(new ModelFruit(R.drawable.apple,"banana"));
        list.add(new ModelFruit(R.drawable.apple,"orange"));
        list.add(new ModelFruit(R.drawable.apple,"gauva"));


        RV1 = findViewById(R.id.RV1);
        MainAdapter adapter = new MainAdapter(list,this);
        RV1.setAdapter(adapter);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        RV1.setLayoutManager(LayoutManager);
    }
}