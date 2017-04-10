package com.exercise.passboring.injector.modules;

import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.exercise.passboring.adapter.VideoListAdapter;
import com.exercise.passboring.injector.PerFragment;
import com.exercise.passboring.module.base.IBasePresenter;
import com.exercise.passboring.module.video.list.VideoListFragment;
import com.exercise.passboring.module.video.list.VideoListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：PassBoring
 * 类描述：video列表
 * 创建人：小豪
 * 创建时间：2017/3/28 10:54
 * 修改人：小豪
 * 修改时间：2017/3/28 10:54
 * 修改备注：
 */
@Module
public class VideoListModule {

    private final VideoListFragment mView;
    private final String mVideoId;

    public VideoListModule(VideoListFragment view, String videoId){
        this.mView = view;
        this.mVideoId = videoId;
    }

    @PerFragment
    @Provides
    public IBasePresenter providerPresenter(){
        return new VideoListPresenter(mView,mVideoId);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new VideoListAdapter(mView.getContext());
    }
}
