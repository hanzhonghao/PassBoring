package com.exercise.passboring.module.video.main;

import com.dl7.downloaderlib.model.DownloadStatus;
import com.exercise.passboring.greendao.VideoInfoDao;
import com.exercise.passboring.module.base.IRxBusPresenter;
import com.exercise.passboring.rxbus.RxBus;
import com.orhanobut.logger.Logger;

import rx.Subscription;
import rx.functions.Action1;

/**
 * 项目名称：PassBoring
 * 类描述：Video 主界面 Presenter
 * 创建人：小豪
 * 创建时间：2017/3/27 15:37
 * 修改人：小豪
 * 修改时间：2017/3/27 15:37
 * 修改备注：
 */

public class VideoMainPresenter implements IRxBusPresenter {
    private final IVideoMainView mView;
    private final VideoInfoDao mDbDao;
    private final RxBus mRxBus;

    public VideoMainPresenter(IVideoMainView view, VideoInfoDao dbDao, RxBus rxBus) {
        mView = view;
        mDbDao = dbDao;
        mRxBus = rxBus;
    }

    @Override
    public void getData(boolean isRefresh) {
//        mView.updateLovedCount((int) mDbDao.queryBuilder().where(VideoInfoDao.Properties.IsCollect.eq(true)).count());
        mView.updateDownloadCount((int) mDbDao.queryBuilder()
                .where(VideoInfoDao.Properties.DownloadStatus.notIn(DownloadStatus.NORMAL, DownloadStatus.COMPLETE)).count());
    }

    @Override
    public void getMoreData() {
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
}
