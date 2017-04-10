package com.exercise.passboring.module.manage.download.cache;

import android.widget.TextView;

import com.dl7.recycler.helper.RecyclerViewHelper;
import com.exercise.passboring.R;
import com.exercise.passboring.injector.component.DaggerVideoCacheComponent;
import com.exercise.passboring.injector.modules.VideoCacheModule;
import com.exercise.passboring.local.table.VideoInfo;
import com.exercise.passboring.module.base.BaseVideoDLFragment;
import com.exercise.passboring.module.base.ILocalView;
import com.exercise.passboring.module.base.IRxBusPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * 项目名称：PassBoring
 * 类描述：video缓存列表
 * 创建人：小豪
 * 创建时间：2017/3/28 16:13
 * 修改人：小豪
 * 修改时间：2017/3/28 16:13
 * 修改备注：
 */

public class VideoCacheFragment extends BaseVideoDLFragment<IRxBusPresenter> implements ILocalView<VideoInfo> {
    @BindView(R.id.default_bg)
    TextView mDefaultBg;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_download;
    }

    @Override
    protected void initInjector() {
        DaggerVideoCacheComponent.builder()
                .applicationComponent(getAppComponent())
                .videoCacheModule(new VideoCacheModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        RecyclerViewHelper.initRecyclerViewV(mContext,mrv);
    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }


    @Override
    public void loadData(List<VideoInfo> dataList) {

    }

    @Override
    public void noData() {

    }
}
