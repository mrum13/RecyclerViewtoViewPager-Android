package com.example.imageloader.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.imageloader.R;
import com.example.imageloader.data.Data;
import com.example.imageloader.model.ViewModelData;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager viewPager;
    AdapterViewPager adapter;
    List<ViewModelData> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        Intent mIntent = getIntent();
        int posisi = mIntent.getIntExtra("position",0);

        models.addAll(Data.getListData());

        adapter = new AdapterViewPager(models, this,posisi);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(posisi);
        viewPager.setPadding(0, 0, 0, 0);

    }

}