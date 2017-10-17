package com.example.rxrecyclerview_library.interfaces;

import android.view.View;

/**
 * Copyright ：All rights reserved
 *
 * @Description : item的点击事件监听回调
 * @Author : Brian
 * @Date : 2017/10/14.
 */

public interface OnItemClickListener {
    void onItemClickListener(View view, int position);
    void onItemLongClickListener(View view, int position);
}
