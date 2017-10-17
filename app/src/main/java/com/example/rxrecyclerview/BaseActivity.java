package com.example.rxrecyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Copyright ：All rights reserved
 *  封装ToolBar
 * @Description :
 * @Author : Brian
 * @Date : 2017/10/16.
 */

public class BaseActivity extends AppCompatActivity {
    //通用的标题
    private TextView title;
    //通用的toolbar
    private Toolbar toolbar;
    //通用的子activity的内容
    private RelativeLayout content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        init();
    }
    private void init(){
        toolbar = (Toolbar)findViewById(R.id.base_toolbar);
        title = (TextView)findViewById(R.id.base_title);
        content = (RelativeLayout)findViewById(R.id.base_content);
        setSupportActionBar(toolbar);
        //设置ToolBar的默认的标题是否显示，对应ActionBar.DISPLAY_SHOW_TITLE
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    //隐藏toolbar
    public void hideToolbar(){
        toolbar.setVisibility(View.GONE);
    }
    //设置返回按钮
    public void setNavigation(final Drawable drawable){
        //设置标题左侧的返回图标
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //为返回按钮设置监听事件
    public void setNavigationListener(View.OnClickListener clickListener){
        //设置nav图标的监听事件
        toolbar.setNavigationOnClickListener(clickListener);
    }

    //设置子Activity中显示的内容
    public void setContentLayout(int layoutId){
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(layoutId,null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        content.addView(contentView,params);
    }

    //设置标题内容
    public void setTitle(String s) {
        if (!TextUtils.isEmpty(s)){
            title.setText(s);
        }
    }
}
