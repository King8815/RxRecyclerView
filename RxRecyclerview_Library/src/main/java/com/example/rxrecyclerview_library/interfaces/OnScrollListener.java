package com.example.rxrecyclerview_library.interfaces;

/**
 * Copyright ：All rights reserved
 *
 * @Description : 滑动回调
 * @Author : Brian
 * @Date : 2017/10/16.
 */

public interface OnScrollListener {
    void onScrollUp();//屏幕从下向上滑动
    void onScrollDown();//屏幕从上向下滑动
    void onScrollStateChanged();
}
