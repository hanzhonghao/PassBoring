package com.exercise.passboring.module.base;

/**
 * 项目名称：PassBoring
 * 类描述： 基础Presenter
 * 创建人：小豪
 * 创建时间：2017/3/17 16:27
 * 修改人：小豪
 * 修改时间：2017/3/17 16:27
 * 修改备注：
 */

public interface IBasePresenter {
    /**
    *@desc 获取网络数据，更新界面
    *@author 小豪
    *@time 2017/3/17 16:30
    *@param  isRefresh 新增参数，用来判断是否为下拉刷新调用，下拉刷新的时候不应该再显示加载界面和异常界面
    *@return
    */
    void getData(boolean isRefresh);

    /**
    *@desc 加载更多数据
    *@author 小豪
    *@time 2017/3/17 16:31
    *@param
    *@return
    */
    void getMoreData();
}
