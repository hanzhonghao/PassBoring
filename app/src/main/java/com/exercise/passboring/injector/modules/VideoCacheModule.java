package com.exercise.passboring.injector.modules;

import com.exercise.passboring.adapter.BaseVideoDLAdapter;
import com.exercise.passboring.adapter.VideoCacheAdapter;
import com.exercise.passboring.greendao.DaoSession;
import com.exercise.passboring.injector.PerFragment;
import com.exercise.passboring.module.base.IRxBusPresenter;
import com.exercise.passboring.module.manage.download.cache.VideoCacheFragment;
import com.exercise.passboring.module.manage.download.cache.VideoCachePresenter;
import com.exercise.passboring.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：PassBoring
 * 类描述：video缓存Module
 * 创建人：小豪
 * 创建时间：2017/3/28 16:19
 * 修改人：小豪
 * 修改时间：2017/3/28 16:19
 * 修改备注：
 */
@Module
public class VideoCacheModule {


    private final VideoCacheFragment mView;

    public VideoCacheModule(VideoCacheFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public IRxBusPresenter providePresenter(DaoSession daoSession, RxBus rxBus){
        return  new VideoCachePresenter(mView,daoSession.getVideoInfoDao(),rxBus);
    }

    @PerFragment
    @Provides
    public BaseVideoDLAdapter provideAdapter(RxBus rxBus) {
        return new VideoCacheAdapter(mView.getContext(), rxBus);
    }
}
