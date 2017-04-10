package com.exercise.passboring.injector.modules;

import com.exercise.passboring.adapter.ViewPagerAdapter;
import com.exercise.passboring.greendao.DaoSession;
import com.exercise.passboring.injector.PerFragment;
import com.exercise.passboring.module.base.IRxBusPresenter;
import com.exercise.passboring.module.video.main.VideoMainFragment;
import com.exercise.passboring.module.video.main.VideoMainPresenter;
import com.exercise.passboring.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：PassBoring
 * 类描述：视频主界面 Module
 * 创建人：小豪
 * 创建时间：2017/3/27 15:02
 * 修改人：小豪
 * 修改时间：2017/3/27 15:02
 * 修改备注：
 */
@Module
public class VideoMainModule {

    private final VideoMainFragment mView;

    public VideoMainModule(VideoMainFragment view) {
        mView = view;
    }

    @PerFragment
    @Provides
    public ViewPagerAdapter providerViewPagerAdapter(){
        return new ViewPagerAdapter(mView.getChildFragmentManager());
    }

    @PerFragment
    @Provides
    public IRxBusPresenter providerVideosPresenter(DaoSession daoSession, RxBus rxBus){
        return new VideoMainPresenter(mView, daoSession.getVideoInfoDao(), rxBus);
    }
}
