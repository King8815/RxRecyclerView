package com.example.rxrecyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rxrecyclerview.activity.BannerActivity;
import com.example.rxrecyclerview.activity.GridLayoutActivity;
import com.example.rxrecyclerview.activity.LinearLayoutActivity;
import com.example.rxrecyclerview.activity.RefreshActivity;
import com.example.rxrecyclerview.activity.StaggerLayoutActivity;
import com.example.rxrecyclerview.activity.SwipeRecyclerActivity;
import com.example.rxrecyclerview.adapter.MainRecyclerViewAdapter;
import com.example.rxrecyclerview_library.interfaces.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
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
    private static final Class<?>[] cls = {
                                            LinearLayoutActivity.class,
                                            GridLayoutActivity.class,
                                            StaggerLayoutActivity.class,
                                            RefreshActivity.class,
                                            SwipeRecyclerActivity.class,
                                            BannerActivity.class};

    public static Class<?>[] getCls() {
        return cls;
    }

    public static String[] getListItem() {
        return listItem;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        initRecyclerView();
        addClickListener();
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

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_setting){
                    Toast.makeText(MainActivity.this,"测试menu", Toast.LENGTH_SHORT).show();
                }
                return true;
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
        recyclerView.addItemDecoration(new DividerItemDecoration(this,manager.getOrientation()));
    }

    private void addClickListener(){
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(MainActivity.this,"item: " + getListItem()[position],Toast.LENGTH_SHORT).show();
                startActivity(getCls()[position]);
            }

            @Override
            public void onItemLongClickListener(View view, int position) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);//加载menu文件到布局
        return true;
    }

    private void startActivity(Class<?> cls){
        Intent intent= new Intent(this,cls);
        startActivity(intent);
    }

}
