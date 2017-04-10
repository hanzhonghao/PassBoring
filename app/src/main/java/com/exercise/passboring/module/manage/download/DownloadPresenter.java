package com.exercise.passboring.module.manage.download;

import com.exercise.passboring.module.base.IRxBusPresenter;
import com.exercise.passboring.rxbus.RxBus;
import com.orhanobut.logger.Logger;

import rx.Subscription;
import rx.functions.Action1;

/**
 * 项目名称：PassBoring
 * 类描述：video下载Presenter
 * 创建人：小豪
 * 创建时间：2017/3/28 15:16
 * 修改人：小豪
 * 修改时间：2017/3/28 15:16
 * 修改备注：
 */

public class DownloadPresenter implements IRxBusPresenter {

    private final RxBus mRxBus;


    public DownloadPresenter(RxBus rxBus) {
        mRxBus = rxBus;
    }

    @Override
    public <T> void registerRxBux(Class<T> eventType, Action1<T> action) {
        Subscription subscription = mRxBus.doSubscribe(eventType, action, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Logger.e(throwable.toString());
            }
        });
        mRxBus.addSubscription(this, subscription);
    }

    @Override
    public void unregisterRxBus() {
        mRxBus.unSubscribe(this);
    }

    @Override
    public void getData(boolean isRefresh) {

    }

    @Override
    public void getMoreData() {

    }
}
