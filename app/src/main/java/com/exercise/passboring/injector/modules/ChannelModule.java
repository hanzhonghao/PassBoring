package com.exercise.passboring.injector.modules;

import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.exercise.passboring.adapter.ManageAdapter;
import com.exercise.passboring.greendao.DaoSession;
import com.exercise.passboring.injector.PerActivity;
import com.exercise.passboring.module.news.channel.ChannelActivity;
import com.exercise.passboring.module.news.channel.ChannelPresenter;
import com.exercise.passboring.module.news.channel.IchannelPresenter;
import com.exercise.passboring.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：PassBoring
 * 类描述： 管理的Module
 * 创建人：小豪
 * 创建时间：2017/3/27 11:28
* 修改人：小豪
 * 修改时间：2017/3/27 11:28
 * 修改备注：
 */
@Module
public class ChannelModule {
    private final ChannelActivity mView;

    public ChannelModule(ChannelActivity view){
        mView = view;
    }

    @Provides
    public BaseQuickAdapter providerManageAdapter(){
        return new ManageAdapter(mView);
    }

    @PerActivity
    @Provides
    public IchannelPresenter providerManagePresenter(DaoSession daoSession, RxBus rxBus){
        return new ChannelPresenter(mView,daoSession.getNewsTypeInfoDao(),rxBus);
    }
}
