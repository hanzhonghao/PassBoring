package com.exercise.passboring.module.base;

import java.util.List;

/**
 * 项目名称：PassBoring
 * 类描述：和本地数据关联的界面接口
 * 创建人：小豪
 * 创建时间：2017/3/28 16:15
 * 修改人：小豪
 * 修改时间：2017/3/28 16:15
 * 修改备注：
 */

public interface ILocalView<T> {
    /**
     * 显示数据
     */
    void loadData(List<T> dataList);

    /**
     * 没有数据
     */
    void noData();
}
