package com.example.rxrecyclerview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rxrecyclerview.adapter.MainRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private MainRecyclerViewAdapter adapter;
    private ArrayList<String> mList = null;


    private static final String[] listItem = {"LinearLayoutActivity",
                                                "GridLayoutActivity",
                                                "StaggerLayoutActivity",
                                                "RefreshActivity",
                                                "SwipeRecyclerActivity",
                                                "BannerActivity"};

    public static String[] getListItem() {
        return listItem;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        initRecyclerView();
    }

    private void initToolBar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.fanhui);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"这是一个测试！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mList = new ArrayList<>();
        for (int i = 0; i < getListItem().length; i++){
            Log.i(TAG, "onCreate: mListItem.item[" + i + "] = " +getListItem()[i]);
            mList.add(getListItem()[i]);
        }

        adapter = new MainRecyclerViewAdapter(this, mList);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

}
