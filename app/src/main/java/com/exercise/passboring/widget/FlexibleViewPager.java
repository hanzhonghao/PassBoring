package com.exercise.passboring.widget;

import android.content.Context;
import android.support.annotation.Px;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * 项目名称：PassBoring
 * 类描述：扩展动态控制 ViewPager 滑动使能功能
 * 创建人：小豪
 * 创建时间：2017/3/28 15:29
 * 修改人：小豪
 * 修改时间：2017/3/28 15:29
 * 修改备注：
 */

public class FlexibleViewPager extends ViewPager{

    private boolean mIsCanScroll = true;

    public FlexibleViewPager(Context context) {
        super(context);
    }

    public FlexibleViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void scrollTo(@Px int x, @Px int y) {
        if (mIsCanScroll) {
            super.scrollTo(x, y);
        }
    }

    public void setCanScroll(boolean canScroll){
        mIsCanScroll = canScroll;
    }
}
