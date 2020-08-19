package com.example.imageloader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.example.imageloader.data.Data;
import com.example.imageloader.model.ViewModelData;
import com.example.imageloader.viewpager.ViewPagerActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerOnItemClickListener {
    RecyclerView recyclerView;
    AdapterRecyclerView adapter;
    List<ViewModelData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        list.addAll(Data.getListData());

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new AdapterRecyclerView(list, MainActivity.this, this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(int position) {
        Intent keDetail = new Intent(MainActivity.this, ViewPagerActivity.class);
        keDetail.putExtra("position", position);
        startActivity(keDetail);
    }
}