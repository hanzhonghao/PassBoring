package com.exercise.passboring.module.news.main;

import com.exercise.passboring.greendao.NewsTypeInfoDao;
import com.exercise.passboring.local.table.NewsTypeInfo;
import com.exercise.passboring.module.base.IRxBusPresenter;
import com.exercise.passboring.rxbus.RxBus;
import com.orhanobut.logger.Logger;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * 项目名称：PassBoring
 * 类描述：主页Presenter
 * 创建人：小豪
 * 创建时间：2017/3/22 10:45
 * 修改人：小豪
 * 修改时间：2017/3/22 10:45
 * 修改备注：
 */

public class NewsMainPresenter implements IRxBusPresenter {
    private final INewsMainView mView;
    private final NewsTypeInfoDao mDbDao;
    private final RxBus mRxBus;

    public NewsMainPresenter(INewsMainView view, NewsTypeInfoDao dbDao, RxBus rxBus) {
        mView = view;
        mDbDao = dbDao;
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
        mDbDao.queryBuilder().rx().list()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<NewsTypeInfo>>() {
                    @Override
                    public void call(List<NewsTypeInfo> newsTypeInfos) {
                        mView.loadData(newsTypeInfos);
                    }
                });
    }

    @Override
    public void getMoreData() {

    }
}
