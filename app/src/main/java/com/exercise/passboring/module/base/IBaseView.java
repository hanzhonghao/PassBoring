package com.exercise.passboring.module.base;

import com.exercise.passboring.widget.EmptyLayout;
import com.trello.rxlifecycle.LifecycleTransformer;

/**
 * 项目名称：PassBoring
 * 类描述：基础BaseView
 * 创建人：小豪
 * 创建时间：2017/3/17 16:31
 * 修改人：小豪
 * 修改时间：2017/3/17 16:31
 * 修改备注：
 */

public interface IBaseView {


    /**
     * 显示加载动画
     */
    void showLoading();


    /**
     * 隐藏加载
     */
    void hideLoading();


    /**
     * 显示网络错误
     * @param onRetryListener 点击监听
     */
    void showNetError(EmptyLayout.OnRetryListener onRetryListener);


    /**
     * 绑定生命周期
     * @param <T>
     * @return
     */
    <T> LifecycleTransformer<T> bindToLife();

    /**
     * 完成刷新, 新增控制刷新
     */
    void finishRefresh();
}
