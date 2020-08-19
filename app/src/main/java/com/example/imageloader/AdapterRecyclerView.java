package com.example.imageloader;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.example.imageloader.model.ViewModelData;
import com.example.imageloader.viewpager.ViewPagerActivity;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    List<ViewModelData> list;
    RecyclerOnItemClickListener mItemClickListener;
    Context context;


    public AdapterRecyclerView(List<ViewModelData> list, Context context, RecyclerOnItemClickListener recyclerOnItemClickListener) {
        this.list = list;
        mItemClickListener = recyclerOnItemClickListener;
        this.context = context;
    }

    public void list(List<ViewModelData> list){
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final ViewModelData mdl =list.get(position);

        Glide.with(context).load(mdl.getImage()).into(holder.img);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent keImage = new Intent(context, ViewPagerActivity.class);
//                keImage.putExtra("position", getItemId(position));
//                context.startActivity(keImage);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageViewRV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
