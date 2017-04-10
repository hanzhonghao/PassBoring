package com.exercise.passboring.module.news.channel;

import com.exercise.passboring.local.table.NewsTypeInfo;

import java.util.List;

/**
 * 项目名称：PassBoring
 * 类描述：栏目管理接口
 * 创建人：小豪
 * 创建时间：2017/3/27 10:52
 * 修改人：小豪
 * 修改时间：2017/3/27 10:52
 * 修改备注：
 */

public interface IchannelView {
    /**
     * 显示数据
     * @param checkList     选中栏目
     * @param uncheckList   未选中栏目
     */
    void loadData(List<NewsTypeInfo> checkList,List<NewsTypeInfo> uncheckList);
}
