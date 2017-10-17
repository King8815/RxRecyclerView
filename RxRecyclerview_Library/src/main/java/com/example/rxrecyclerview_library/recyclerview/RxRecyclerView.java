package com.example.rxrecyclerview_library.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Copyright ：All rights reserved
 *
 * @Description :
 * @Author : Brian
 * @Date : 2017/10/16.
 */

public class RxRecyclerView extends RecyclerView {
    private static final String TAG = "RxRecyclerView";
    private Context context;

    private boolean isRefreshing = false;//是否正在下拉刷新
    private boolean isLoadingData = false;//是否正在加载更多数据
    private boolean isRefreshingEnabled = true;//下拉刷新激活
    private boolean isLoadingDataEnabled = true;//加载数据激活


    public RxRecyclerView(Context context) {
        super(context);
    }

    public RxRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RxRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.i(TAG, "initRecyclerView: ");
    }

}
