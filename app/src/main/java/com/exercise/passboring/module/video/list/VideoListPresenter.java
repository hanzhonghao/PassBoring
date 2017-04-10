package com.exercise.passboring.module.video.list;

import com.exercise.passboring.api.RetrofitService;
import com.exercise.passboring.local.table.VideoInfo;
import com.exercise.passboring.module.base.IBasePresenter;
import com.exercise.passboring.module.base.ILoadDataView;
import com.exercise.passboring.widget.EmptyLayout;
import com.orhanobut.logger.Logger;

import java.util.List;

import rx.Subscriber;
import rx.functions.Action0;

/**
 * 项目名称：PassBoring
 * 类描述：
 * 创建人：小豪
 * 创建时间：2017/3/28 10:57
 * 修改人：小豪
 * 修改时间：2017/3/28 10:57
 * 修改备注：
 */

public class VideoListPresenter implements IBasePresenter {

    final private ILoadDataView mView;
    final private String mVideoId;
    private int mPage = 0;

    public VideoListPresenter(VideoListFragment view, String videoId) {
        this.mView = view;
        this.mVideoId = videoId;
    }

    @Override
    public void getData(boolean isRefresh) {
        RetrofitService.getVideoList(mVideoId, mPage)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mView.showLoading();
                    }
                })
                .compose(mView.<List<VideoInfo>>bindToLife())
                .subscribe(new Subscriber<List<VideoInfo>>() {
                    @Override
                    public void onCompleted() {
                        mView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                        mView.showNetError(new EmptyLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getData(false);
                            }
                        });
                    }

                    @Override
                    public void onNext(List<VideoInfo> videoInfos) {
                        mView.loadData(videoInfos);
                        mPage++;
                    }
                });
    }

    @Override
    public void getMoreData() {
        RetrofitService.getVideoList(mVideoId, mPage)
                .compose(mView.<List<VideoInfo>>bindToLife())
                .subscribe(new Subscriber<List<VideoInfo>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                        mView.loadNoData();
                    }

                    @Override
                    public void onNext(List<VideoInfo> videoList) {
                        mView.loadMoreData(videoList);
                        mPage++;
                    }
                });
    }
}
