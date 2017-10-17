package com.example.rxrecyclerview_library.ItemDecoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Copyright ：All rights reserved
 *
 * @Description : LienarLayout下的分割线
 * @Author : Brian
 * @Date : 2017/10/14.
 */

public class LinearItemDecoration extends RecyclerView.ItemDecoration{
    private static final String TAG = "LinearItemDecoration";
    public static final int HORIZONTAL = LinearLayout.HORIZONTAL;
    public static final int VERTICAL = LinearLayout.VERTICAL;

    private Paint mDividerPaint;//分割线颜色
    private Drawable dividerDrawable;//图片分割线
    private int dividerHeight = 1;//分割线宽度
    private int orientation;//分割线方向
    public static final int[] attr = new int[]{android.R.attr.listDivider};

    public LinearItemDecoration(Context context) {
        final TypedArray ta = context.obtainStyledAttributes(attr);
        this.dividerDrawable = ta.getDrawable(0);
        ta.recycle();
    }

    public LinearItemDecoration(Context context, int orientation) {
        this(context);
        setOrientation(orientation);
    }

    public LinearItemDecoration(Context context, int orientation, int dividerHeight, int dividerColor) {
        this(context);
        setOrientation(orientation);
        this.dividerHeight = dividerHeight;
        //绘制颜色分割线的画笔
        mDividerPaint = new Paint();
        mDividerPaint.setStyle(Paint.Style.FILL);//填充画笔
        mDividerPaint.setColor(dividerColor);
    }

    public LinearItemDecoration(Context context, int orientation, int dividerHeight, Drawable dividerDrawable) {
        this(context);
        setOrientation(orientation);
        this.dividerHeight = dividerHeight;
        this.dividerDrawable = dividerDrawable;
    }

    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL && orientation != VERTICAL) {
            throw new IllegalArgumentException(
                    "Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.orientation = orientation;
    }

    public void setDrawable(Drawable dividerDrawable) {
        if (dividerDrawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.dividerDrawable = dividerDrawable;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() == null) {
            return;
        }
        if (orientation == LinearLayout.VERTICAL){
            //绘制垂直分割线
            drawVerticalDivider(c, parent);
        }else if (orientation == LinearLayout.HORIZONTAL){
            //绘制水平分割线
            drawHorizontalDivider(c, parent);
        }
    }

    /**
     * 垂直布局，绘制水平分割线
     */
    private void drawVerticalDivider(Canvas canvas, RecyclerView parent){
        canvas.save();
        //确定分割线的坐标点
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        // 这里的parent就是recycleview，通过它我们可以获取列表的所有的元素，
        // 然后遍历列表中的每一个元素，对每一个元素绘制垂直分割线
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final int bottom = child.getBottom() + Math.round(ViewCompat.getTranslationY(child));
            final int top = bottom - dividerDrawable.getIntrinsicHeight();

            if (mDividerPaint != null){
                canvas.drawRect(left,top,right,bottom,mDividerPaint);
            }
        }
        canvas.restore();
    }

    /**
     * 水平布局，绘制垂直分割线
     */
    private void drawHorizontalDivider(Canvas canvas, RecyclerView parent){
        canvas.save();
        final int top;
        final int bottom;
            top = parent.getPaddingTop();
            bottom = parent.getHeight() - parent.getPaddingBottom();
            canvas.clipRect(parent.getPaddingLeft(), top,
                    parent.getWidth() - parent.getPaddingRight(), bottom);

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final int right = child.getRight() + Math.round(ViewCompat.getTranslationX(child));
            final int left = right - dividerDrawable.getIntrinsicWidth();
            dividerDrawable.draw(canvas);
        }
        canvas.restore();
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }
}
