package com.exercise.passboring.module.manage.download;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.exercise.passboring.R;
import com.exercise.passboring.adapter.ViewPagerAdapter;
import com.exercise.passboring.injector.component.DaggerDownloadComponent;
import com.exercise.passboring.injector.modules.DownloadModule;
import com.exercise.passboring.module.base.BaseActivity;
import com.exercise.passboring.module.base.BaseVideoDLFragment;
import com.exercise.passboring.module.base.IRxBusPresenter;
import com.exercise.passboring.module.manage.download.cache.VideoCacheFragment;
import com.exercise.passboring.rxbus.event.VideoEvent;
import com.exercise.passboring.widget.FlexibleViewPager;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.functions.Action1;

import static com.exercise.passboring.utils.CommonConstant.INDEX_KEY;

/**
 * 项目名称：PassBoring
 * 类描述：下载管理界面，仿Bilibili
 * 创建人：小豪
 * 创建时间：2017/3/28 14:54
 * 修改人：小豪
 * 修改时间：2017/3/28 14:54
 * 修改备注：
 */

public class DownloadActivity extends BaseActivity<IRxBusPresenter> {

    @Inject
    ViewPagerAdapter mPagerAdapter;

    @BindView(R.id.tv_close_edit)
    TextView mTvCloseEdit;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    SlidingTabLayout mTabLayout;
    @BindView(R.id.view_pager)
    FlexibleViewPager mViewPager;
    @BindView(R.id.btn_select_all)
    TextView mBtnSelectAll;
    @BindView(R.id.btn_select_del)
    TextView mBtnSelectDel;
    @BindView(R.id.fl_del_layout)
    FrameLayout mFlDelLayout;


    private BaseVideoDLFragment mCompleteFragment;
    private BaseVideoDLFragment mCacheFragment;
    private int mIndex;
    public static void launch(Context context, int index) {
        Intent intent = new Intent(context, DownloadActivity.class);
        intent.putExtra(INDEX_KEY, index);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.zoom_in_entry, R.anim.hold);

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_download;
    }

    @Override
    protected void initInjector() {
        DaggerDownloadComponent.builder()
                .applicationComponent(getAppComponent())
                .downloadModule(new DownloadModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
         mIndex = getIntent().getIntExtra(INDEX_KEY, 0);
        initToolBar(mToolBar,true,"下载管理");
        mViewPager.setAdapter(mPagerAdapter);
        mPresenter.registerRxBux(VideoEvent.class, new Action1<VideoEvent>() {
            @Override
            public void call(VideoEvent videoEvent) {
                if (videoEvent.checkStatus !=VideoEvent.CHECK_INVALID){
                    handleVideoEvent(videoEvent);
                }
            }
        });
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
//        mCompleteFragment = new VideoCompleteFragment();
        mCacheFragment = new VideoCacheFragment();
    }

    /**
     * 处理 VideoEvent，来改变编辑状态UI
     *
     * @param videoEvent
     */
    private void handleVideoEvent(VideoEvent videoEvent){
        mBtnSelectDel.setEnabled(videoEvent.checkStatus != VideoEvent.CHECK_NONE);
        mBtnSelectAll.setText(videoEvent.checkStatus == VideoEvent.CHECK_ALL?"取消全选":"全选");
        mBtnSelectAll.setSelected(videoEvent.checkStatus == VideoEvent.CHECK_ALL);//如果是全选了，就默认处于点击状态
    }

}
