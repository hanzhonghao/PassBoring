package com.exercise.passboring.adapter;

import android.content.Context;

import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.dl7.recycler.adapter.BaseViewHolder;
import com.exercise.passboring.R;
import com.exercise.passboring.local.table.NewsTypeInfo;

/**
 * 项目名称：PassBoring
 * 类描述：管理界面适配器
 * 创建人：小豪
 * 创建时间：2017/3/27 11:36
 * 修改人：小豪
 * 修改时间：2017/3/27 11:36
 * 修改备注：
 */

public class ManageAdapter extends BaseQuickAdapter<NewsTypeInfo> {
    public ManageAdapter(Context context) {
        super(context);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.adapter_manage;
    }

    @Override
    protected void convert(BaseViewHolder holder, NewsTypeInfo item) {
        holder.setText(R.id.tv_channel_name, item.getName());
    }
}
