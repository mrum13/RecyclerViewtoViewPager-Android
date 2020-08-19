package com.example.imageloader.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.imageloader.R;
import com.example.imageloader.model.ViewModelData;

import java.util.List;

public class AdapterViewPager extends PagerAdapter {
    private List<ViewModelData> models;
    private LayoutInflater layoutInflater;
    private Context context;
    int pos,impl;
    ViewPager mViewPager;

    public AdapterViewPager(List<ViewModelData> models, Context context, int pos) {
        this.models = models;
        this.context = context;
        this.pos = pos;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView;

        imageView = view.findViewById(R.id.image);


        imageView.setImageResource(models.get(position).getImage());
//        title.setText(models.get(position).getTitle());
//        desc.setText(models.get(position).getDesc());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
