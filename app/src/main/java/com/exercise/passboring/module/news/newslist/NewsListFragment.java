package com.exercise.passboring.module.news.newslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.daimajia.slider.library.SliderLayout;
import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.dl7.recycler.helper.RecyclerViewHelper;
import com.dl7.recycler.listener.OnRequestDataListener;
import com.exercise.passboring.R;
import com.exercise.passboring.adapter.item.NewsMultiItem;
import com.exercise.passboring.api.bean.NewsInfo;
import com.exercise.passboring.injector.component.DaggerNewsListComponent;
import com.exercise.passboring.injector.modules.NewsListModule;
import com.exercise.passboring.module.base.BaseFragment;
import com.exercise.passboring.module.base.IBasePresenter;
import com.exercise.passboring.utils.SliderHelper;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;

/**
 * 项目名称：PassBoring
 * 类描述：新闻列表
 * 创建人：小豪
 * 创建时间：2017/3/22 13:53
 * 修改人：小豪
 * 修改时间：2017/3/22 13:53
 * 修改备注：
 */

public class NewsListFragment extends BaseFragment<IBasePresenter> implements INewsListView {

    private static final String NEWS_TYPE_KEY = "NewsTypeKey";

    @BindView(R.id.rv_news_list)
    RecyclerView mRvNewsList;

    @Inject
    BaseQuickAdapter mAdapter;
    private SliderLayout mAdSlider;

    private String mNewsId;


    public static NewsListFragment newInstance(String newsId) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NEWS_TYPE_KEY, newsId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNewsId = getArguments().getString(NEWS_TYPE_KEY);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdSlider != null) {
            mAdSlider.startAutoCycle();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdSlider != null) {
            mAdSlider.stopAutoCycle();
        }
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_news_list;
    }

    @Override
    protected void initInjector() {
        DaggerNewsListComponent.builder()
                .applicationComponent(getAppComponent())
                .newsListModule(new NewsListModule(this, mNewsId))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        SlideInRightAnimationAdapter animAdapter = new SlideInRightAnimationAdapter(mAdapter);
        RecyclerViewHelper.initRecyclerViewV(mContext, mRvNewsList, true, new AlphaInAnimationAdapter(animAdapter));
        mAdapter.setRequestDataListener(new OnRequestDataListener() {
            @Override
            public void onLoadMore() {
                mPresenter.getMoreData();
            }
        });
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        mPresenter.getData(isRefresh);
    }

    @Override
    public void loadData(List<NewsMultiItem> newsList) {
        mAdapter.updateItems(newsList);
    }

    @Override
    public void loadMoreData(List<NewsMultiItem> newsList) {
        mAdapter.loadComplete();
        mAdapter.addItems(newsList);
    }

    @Override
    public void loadNoData() {
        mAdapter.loadAbnormal();
    }

    @Override
    public void loadAdData(NewsInfo newsBean) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.head_news_list, null);
        mAdSlider = (SliderLayout) view.findViewById(R.id.slider_ads);
        SliderHelper.initAdSlider(mContext, mAdSlider, newsBean);
        mAdapter.addHeaderView(view);
    }
}
