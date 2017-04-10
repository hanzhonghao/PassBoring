package com.exercise.passboring.injector.modules;

import com.exercise.passboring.adapter.ViewPagerAdapter;
import com.exercise.passboring.injector.PerActivity;
import com.exercise.passboring.module.base.IRxBusPresenter;
import com.exercise.passboring.module.manage.download.DownloadActivity;
import com.exercise.passboring.module.manage.download.DownloadPresenter;
import com.exercise.passboring.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：PassBoring
 * 类描述：video下载Module
 * 创建人：小豪
 * 创建时间：2017/3/28 15:07
 * 修改人：小豪
 * 修改时间：2017/3/28 15:07
 * 修改备注：
 */
@Module
public class DownloadModule {

    private final DownloadActivity mView;

    public DownloadModule(DownloadActivity view) {
        mView = view;
    }

    @PerActivity
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter(){
        return new ViewPagerAdapter(mView.getSupportFragmentManager());
    }

    @PerActivity
    @Provides
    public IRxBusPresenter provideVideosPresenter(RxBus rxBus) {
        return new DownloadPresenter(rxBus);
    }
}
