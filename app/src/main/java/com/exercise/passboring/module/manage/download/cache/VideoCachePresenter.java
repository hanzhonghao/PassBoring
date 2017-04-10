package com.exercise.passboring.module.manage.download.cache;

import com.dl7.downloaderlib.model.DownloadStatus;
import com.exercise.passboring.greendao.VideoInfoDao;
import com.exercise.passboring.local.table.VideoInfo;
import com.exercise.passboring.module.base.ILocalView;
import com.exercise.passboring.module.base.IRxBusPresenter;
import com.exercise.passboring.rxbus.RxBus;
import com.exercise.passboring.utils.ListUtils;
import com.orhanobut.logger.Logger;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 项目名称：PassBoring
 * 类描述： video 缓存Presenter
 * 创建人：小豪
 * 创建时间：2017/3/28 16:22
 * 修改人：小豪
 * 修改时间：2017/3/28 16:22
 * 修改备注：
 */

public class VideoCachePresenter implements IRxBusPresenter {

    private final ILocalView mView;
    private final VideoInfoDao mDbDao;
    private final RxBus mRxBus;

    public VideoCachePresenter(VideoCacheFragment view, VideoInfoDao videoInfoDao, RxBus rxBus) {
        mView = view;
        mDbDao = videoInfoDao;
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
        mDbDao.queryBuilder().rx()
                .oneByOne()
                .filter(new Func1<VideoInfo, Boolean>() {
                    @Override
                    public Boolean call(VideoInfo videoInfo) {
                        // 判断是否存于下载中
                        return (videoInfo.getDownloadStatus() != DownloadStatus.NORMAL &&
                                videoInfo.getDownloadStatus() != DownloadStatus.COMPLETE);
                    }
                })
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<VideoInfo>>() {
                    @Override
                    public void call(List<VideoInfo> videoInfos) {
                        if (ListUtils.isEmpty(videoInfos)){
                            mView.noData();
                        }else{
                            mView.loadData(videoInfos);
                        }
                    }
                });
    }

    @Override
    public void getMoreData() {

    }
}
