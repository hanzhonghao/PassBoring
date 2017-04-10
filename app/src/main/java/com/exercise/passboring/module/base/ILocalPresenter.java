package com.exercise.passboring.module.base;

import java.util.List;

/**
 * 项目名称：PassBoring
 * 类描述：提供本地数据库操作的 Presenter
 * 创建人：小豪
 * 创建时间：2017/3/27 10:55
 * 修改人：小豪
 * 修改时间：2017/3/27 10:55
 * 修改备注：
 */

public interface ILocalPresenter<T> extends IBasePresenter{
    /**
     * 插入数据
     * @param data  数据
     */
    void insert(T data);

    /**
     * 删除数据
     * @param data  数据
     */
    void delete(T data);

    /**
     * 更新数据
     * @param list   所有数据
     */
    void update(List<T> list);
}
