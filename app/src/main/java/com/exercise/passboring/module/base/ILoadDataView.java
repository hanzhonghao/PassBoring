package com.exercise.passboring.module.base;

/**
 * 项目名称：PassBoring
 * 类描述：加载数据的界面接口
 * 创建人：小豪
 * 创建时间：2017/3/22 14:39
 * 修改人：小豪
 * 修改时间：2017/3/22 14:39
 * 修改备注：
 */

public interface ILoadDataView<T> extends IBaseView{
    /**
     * 加载数据
     * @param data 数据
     */
    void loadData(T data);

    /**
     * 加载更多
     * @param data 数据
     */
    void loadMoreData(T data);

    /**
     * 没有数据
     */
    void loadNoData();

}
