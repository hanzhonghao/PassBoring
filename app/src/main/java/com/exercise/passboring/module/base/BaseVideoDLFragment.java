package com.exercise.passboring.module.base;

import android.support.v7.widget.RecyclerView;

import com.exercise.passboring.R;

import butterknife.BindView;

/**
 * 项目名称：PassBoring
 * 类描述：video下载的基类Fragment
 * 创建人：小豪
 * 创建时间：2017/3/28 15:57
 * 修改人：小豪
 * 修改时间：2017/3/28 15:57
 * 修改备注：
 */

public abstract class BaseVideoDLFragment<T extends IBasePresenter> extends BaseFragment<T>{
    @BindView(R.id.rv_video_list)
    protected RecyclerView mRvVideoList;

//    @Inject
//    protected BaseVideoDLAdapter mAdapter;


}
