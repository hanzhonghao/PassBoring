package com.exercise.passboring.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.dl7.recycler.adapter.BaseViewHolder;
import com.exercise.passboring.R;
import com.exercise.passboring.local.table.VideoInfo;
import com.exercise.passboring.utils.DefIconFactory;
import com.exercise.passboring.utils.ImageLoader;
import com.exercise.passboring.utils.ToastUtils;

/**
 * 项目名称：PassBoring
 * 类描述：
 * 创建人：小豪
 * 创建时间：2017/3/28 11:20
 * 修改人：小豪
 * 修改时间：2017/3/28 11:20
 * 修改备注：
 */

public class VideoListAdapter extends BaseQuickAdapter<VideoInfo> {
    public VideoListAdapter(Context context) {
        super(context);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.adapter_video_list;
    }

    @Override
    protected void convert(BaseViewHolder holder, VideoInfo item) {
        ImageView ivPhoto = holder.getView(R.id.iv_photo);
        ImageLoader.loadFitCenter(mContext,item.getCover(),ivPhoto, DefIconFactory.provideIcon());
        holder.setText(R.id.tv_title,item.getTitle());
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast("还没有做出观看视频界面");
            }
        });
    }
}
