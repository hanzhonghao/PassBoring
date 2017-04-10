package com.exercise.passboring.injector.modules;

import android.content.Context;

import com.exercise.passboring.App;
import com.exercise.passboring.greendao.DaoSession;
import com.exercise.passboring.rxbus.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：PassBoring
 * 类描述：Application Module
 * 创建人：小豪
 * 创建时间：2017/3/22 10:02
 * 修改人：小豪
 * 修改时间：2017/3/22 10:02
 * 修改备注：
 */
@Module
public class ApplicationModule {
    private final App mApp;
    private final DaoSession mDaoSession;
    private final RxBus mRxbus;

    public ApplicationModule(App application, DaoSession daoSession, RxBus rxBus) {
        mApp = application;
        mDaoSession=daoSession;
        mRxbus =rxBus;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(){
        return mApp.getApplicationContext();
    }

    @Provides
    @Singleton
    RxBus provideRxBus(){
        return mRxbus;
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession() {
        return mDaoSession;
    }
}
