package com.exercise.passboring.injector.component;

import android.content.Context;

import com.exercise.passboring.greendao.DaoSession;
import com.exercise.passboring.injector.modules.ApplicationModule;
import com.exercise.passboring.rxbus.RxBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 项目名称：PassBoring
 * 类描述：Application Component
 * 创建人：小豪
 * 创建时间：2017/3/22 10:01
 * 修改人：小豪
 * 修改时间：2017/3/22 10:01
 * 修改备注：
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    // provide
    Context getContext();

    RxBus getRxBus();

    DaoSession getDaoSession();
}
