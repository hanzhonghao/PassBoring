package com.exercise.passboring.module.video.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.dl7.recycler.helper.RecyclerViewHelper;
import com.dl7.recycler.listener.OnRequestDataListener;
import com.exercise.passboring.R;
import com.exercise.passboring.injector.component.DaggerVideoListComponent;
import com.exercise.passboring.injector.modules.VideoListModule;
import com.exercise.passboring.local.table.VideoInfo;
import com.exercise.passboring.module.base.BaseFragment;
import com.exercise.passboring.module.base.IBasePresenter;
import com.exercise.passboring.module.base.ILoadDataView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 项目名称：PassBoring
 * 类描述：列表展示fragment
 * 创建人：小豪
 * 创建时间：2017/3/27 16:29
 * 修改人：小豪
 * 修改时间：2017/3/27 16:29
 * 修改备注：
 */

public class VideoListFragment extends BaseFragment<IBasePresenter> implements ILoadDataView<List<VideoInfo>> {

    private static final String VIDEO_ID_KEY = "VideoIdKey";
    @BindView(R.id.rv_photo_list)
    RecyclerView mRvPhotoList;

    @Inject
    BaseQuickAdapter mAdapter;

    private String mVideoId;

    public static VideoListFragment newInstance(String videoId) {
        VideoListFragment fragment = new VideoListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(VIDEO_ID_KEY, videoId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mVideoId = getArguments().getString(VIDEO_ID_KEY);
        }
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_photo_list;
    }

    @Override
    protected void initInjector() {
        DaggerVideoListComponent.builder()
                .applicationComponent(getAppComponent())
                .videoListModule(new VideoListModule(this,mVideoId))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
//        SlideInBottomAdapter slideAdapter = new SlideInBottomAdapter(mAdapter);
        RecyclerViewHelper.initRecyclerViewV(mContext,mRvPhotoList,mAdapter);
        mAdapter.setRequestDataListener(new OnRequestDataListener() {
            @Override
            public void onLoadMore() {
                mPresenter.getMoreData();
            }
        });

    }

    @Override
    protected void updateViews(boolean isRefresh) {
        mPresenter.getData(isRefresh);
    }

    @Override
    public void loadData(List<VideoInfo> videoList) {
        mAdapter.updateItems(videoList);
        for (VideoInfo bean : videoList) {
            Log.e("VideoListFragment", bean.toString());
        }
    }

    @Override
    public void loadMoreData(List<VideoInfo> photoList) {
        mAdapter.loadComplete();
        mAdapter.addItems(photoList);
    }

    @Override
    public void loadNoData() {
        mAdapter.loadAbnormal();
    }
}
