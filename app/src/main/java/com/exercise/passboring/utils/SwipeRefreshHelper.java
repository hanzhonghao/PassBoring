package com.exercise.passboring.utils;

import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;

/**
 * 项目名称：PassBoring
 * 类描述： 下拉刷新帮助类
 * 创建人：小豪
 * 创建时间：2017/3/20 11:21
 * 修改人：小豪
 * 修改时间：2017/3/20 11:21
 * 修改备注：
 */

public class SwipeRefreshHelper {

    private SwipeRefreshHelper() {
        throw new AssertionError();
    }

    /**
     * 初始化，关联AppBarLayout，处理滑动冲突
     */
    public static void init(final SwipeRefreshLayout refreshLayout, AppBarLayout appBar, SwipeRefreshLayout.OnRefreshListener listener) {
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        refreshLayout.setOnRefreshListener(listener);
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset >= 0) {//下拉的垂直距离大于0才会刷新，上滑不会刷新。我感觉没必要设置这个监听。
                    refreshLayout.setEnabled(true);
                } else {
                    refreshLayout.setEnabled(false);
                }
            }
        });
    }

    /**
     * 初始化
     *
     * @param refreshLayout
     * @param listener
     */
    public static void init(SwipeRefreshLayout refreshLayout, SwipeRefreshLayout.OnRefreshListener listener) {
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        refreshLayout.setOnRefreshListener(listener);
    }

    /**
     * 设置能够刷新
     */
    public static void enableRefresh(SwipeRefreshLayout refreshLayout, boolean isEnable) {
        if (refreshLayout != null) {
            refreshLayout.setEnabled(isEnable);
        }
    }

    /**
     * 控制刷新
     */
    public static void controlRefresh(SwipeRefreshLayout refreshLayout, boolean isRefresh) {
        if (refreshLayout != null) {
            if (isRefresh != refreshLayout.isRefreshing()) {
                refreshLayout.setRefreshing(isRefresh);
            }
        }
    }

}
