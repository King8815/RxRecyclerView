package com.example.rxrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rxrecyclerview.MainActivity;
import com.example.rxrecyclerview.R;

import java.util.ArrayList;

/**
 * Copyright ：All rights reserved
 *
 * @Description : just for MainActivity RecyclerView item adapter
 * @Author : Brian
 * @Date : 2017/10/13.
 */

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder>{
    private static final String TAG = "MainAdapter";

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String> list = new ArrayList<>();

    public MainRecyclerViewAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MainRecyclerViewAdapter.MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.main_list_item, parent, false);
        MainViewHolder holder = new MainViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MainRecyclerViewAdapter.MainViewHolder holder, final int position) {
        //set item content
        holder.textView.setText(list.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: " + list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MainViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.main_item);
        }
    }

}
