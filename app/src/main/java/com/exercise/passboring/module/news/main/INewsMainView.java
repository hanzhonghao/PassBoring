package com.exercise.passboring.module.news.main;

import com.exercise.passboring.local.table.NewsTypeInfo;

import java.util.List;

/**
 * 项目名称：PassBoring
 * 类描述：主页接口
 * 创建人：小豪
 * 创建时间：2017/3/21 17:37
 * 修改人：小豪
 * 修改时间：2017/3/21 17:37
 * 修改备注：
 */

public interface INewsMainView {

    /**
     * 显示数据
     */
    void loadData(List<NewsTypeInfo> checkList);

}
