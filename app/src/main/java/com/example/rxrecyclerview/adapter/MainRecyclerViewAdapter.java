package com.example.rxrecyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.rxrecyclerview.MainActivity;
import com.example.rxrecyclerview.R;
import com.example.rxrecyclerview_library.interfaces.OnItemClickListener;

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
    private OnItemClickListener mListener;//对item设置点击监听事件

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

    /**
     * 绑定viewholder，并且设置item中的内容，以及item的点击事件监听
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final MainRecyclerViewAdapter.MainViewHolder holder, final int position) {
        //设置item中显示的内容
        holder.textView.setText(list.get(position));

        //判断是否设置了监听器
        if (mListener != null) {
            //为item设置单击监听事件
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = holder.getLayoutPosition();//1.获取当前的item的位置
                    mListener.onItemClickListener(view, position);//2.利用回调函数设置监听事件
                }
            });

            /*
            //为item设置长按监听事件
            holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = holder.getLayoutPosition();
                    mListener.onItemLongClickListener(view,position);
                    //设置为true，表示已经进行了事件，不会再次进行事件的传递
                    return true;
                }
            });*/
        }

    }

    /**
     * list的数量
     * @return
     */
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

    public void setOnItemClickListener(OnItemClickListener mListener){
        this.mListener = mListener;
    }
}
