package com.exercise.passboring.injector.modules;

import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.exercise.passboring.adapter.NewsMultiListAdapter;
import com.exercise.passboring.injector.PerFragment;
import com.exercise.passboring.module.base.IBasePresenter;
import com.exercise.passboring.module.news.newslist.NewsListFragment;
import com.exercise.passboring.module.news.newslist.NewsListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：PassBoring
 * 类描述：新闻列表 Module
 * 创建人：小豪
 * 创建时间：2017/3/22 15:03
 * 修改人：小豪
 * 修改时间：2017/3/22 15:03
 * 修改备注：
 */
@Module
public class NewsListModule {

    private final NewsListFragment mNewsListView;
    private final String mNewsId;

    public NewsListModule(NewsListFragment view,String newsId) {
        this.mNewsListView = view;
        this.mNewsId = newsId;
    }

    @PerFragment
    @Provides
    public IBasePresenter providerPresenter(){
        return new NewsListPresenter(mNewsListView,mNewsId);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAapter(){
        return new NewsMultiListAdapter(mNewsListView.getContext());
    }
}
