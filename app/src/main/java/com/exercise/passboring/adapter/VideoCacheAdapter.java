package com.exercise.passboring.adapter;

import android.content.Context;

import com.dl7.recycler.adapter.BaseViewHolder;
import com.exercise.passboring.R;
import com.exercise.passboring.local.table.VideoInfo;
import com.exercise.passboring.rxbus.RxBus;

/**
 * 项目名称：PassBoring
 * 类描述：Video 下载适配器
 * 创建人：小豪
 * 创建时间：2017/3/29 10:34
 * 修改人：小豪
 * 修改时间：2017/3/29 10:34
 * 修改备注：
 */

public class VideoCacheAdapter extends BaseVideoDLAdapter {
    public VideoCacheAdapter(Context context, RxBus rxBus) {
        super(context, rxBus);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.adapter_video_cache;
    }

    @Override
    protected void convert(BaseViewHolder holder, VideoInfo item) {

    }
}
