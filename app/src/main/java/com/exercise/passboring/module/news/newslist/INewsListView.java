package com.exercise.passboring.module.news.newslist;

import com.exercise.passboring.adapter.item.NewsMultiItem;
import com.exercise.passboring.api.bean.NewsInfo;
import com.exercise.passboring.module.base.ILoadDataView;

import java.util.List;

/**
 * 项目名称：PassBoring
 * 类描述：新闻列表视图接口
 * 创建人：小豪
 * 创建时间：2017/3/22 13:55
 * 修改人：小豪
 * 修改时间：2017/3/22 13:55
 * 修改备注：
 */

public interface INewsListView extends ILoadDataView<List<NewsMultiItem>> {

    /**
     * 加载广告数据(就是Banner数据)
     */
    void loadAdData(NewsInfo newsBean);
}
