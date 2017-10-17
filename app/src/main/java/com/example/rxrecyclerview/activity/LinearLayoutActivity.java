package com.example.rxrecyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rxrecyclerview.BaseActivity;
import com.example.rxrecyclerview.R;

public class LinearLayoutActivity extends BaseActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_linear_layout);
        textView = (TextView)findViewById(R.id.text_linear);
        textView.setText("这一个Linear");
        setTitle("diyige");
    }
}
