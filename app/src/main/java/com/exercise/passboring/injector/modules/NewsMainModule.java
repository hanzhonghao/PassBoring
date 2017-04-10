package com.exercise.passboring.injector.modules;

import com.exercise.passboring.adapter.ViewPagerAdapter;
import com.exercise.passboring.greendao.DaoSession;
import com.exercise.passboring.injector.PerFragment;
import com.exercise.passboring.module.base.IRxBusPresenter;
import com.exercise.passboring.module.news.main.NewsMainFragment;
import com.exercise.passboring.module.news.main.NewsMainPresenter;
import com.exercise.passboring.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：PassBoring
 * 类描述：新闻主页 Module
 * 创建人：小豪
 * 创建时间：2017/3/22 9:42
 * 修改人：小豪
 * 修改时间：2017/3/22 9:42
 * 修改备注：
 */
@Module
public class NewsMainModule {
    private final NewsMainFragment mView;

    public NewsMainModule(NewsMainFragment view) {
        mView = view;
    }

    @PerFragment
    @Provides
    public IRxBusPresenter provideMainPresenter(DaoSession daoSession, RxBus rxBus) {
        return new NewsMainPresenter(mView, daoSession.getNewsTypeInfoDao(), rxBus);
    }

    @PerFragment
    @Provides
    public ViewPagerAdapter providerViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getChildFragmentManager());//得到NewsMainFragment中的ViewPagerde Fragment
    }
}
