package com.exercise.passboring.adapter;

import android.content.Context;
import android.util.SparseBooleanArray;

import com.dl7.downloaderlib.entity.FileInfo;
import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.dl7.recycler.adapter.BaseViewHolder;
import com.exercise.passboring.R;
import com.exercise.passboring.engine.DownloaderWrapper;
import com.exercise.passboring.local.table.VideoInfo;
import com.exercise.passboring.rxbus.RxBus;
import com.exercise.passboring.rxbus.event.VideoEvent;
import com.orhanobut.logger.Logger;

/**
 * 项目名称：PassBoring
 * 类描述：video下载适配器基类
 * 创建人：小豪
 * 创建时间：2017/3/29 10:07
 * 修改人：小豪
 * 修改时间：2017/3/29 10:07
 * 修改备注：
 */

public abstract class BaseVideoDLAdapter extends BaseQuickAdapter<VideoInfo> {

    private static final  int INVALID_POS = -1;
    protected SparseBooleanArray mSparseItemChecked = new SparseBooleanArray();

    protected boolean mIsEditMode = false;
    protected final RxBus mRxBus;

    public BaseVideoDLAdapter(Context context, RxBus rxBus) {
        super(context);
        mRxBus = rxBus;
    }

    /**
     * 处理选中事件
     * @param position
     * @param isChecked
     */
    protected void handleCheckedChanged(int position,boolean isChecked){
        if (position ==INVALID_POS){
            Logger.i(position + "" + isChecked);
            return;
        }
        mSparseItemChecked.put(position,isChecked);
        int checkedCount = 0;
        int checkedStatus;
        for (int i = 0;i<getItemCount();i++){
            if(mSparseItemChecked.get(i,false)){
                checkedCount++;
            }
        }
        if (checkedCount == 0){
            checkedStatus = VideoEvent.CHECK_NONE;
        }else if(checkedCount == getItemCount()){
            checkedStatus = VideoEvent.CHECK_ALL;
        }else{
            checkedStatus = VideoEvent.CHECK_SOME;
        }
        //通知DownloadActivity更新界面
        mRxBus.post(new VideoEvent(checkedStatus));
    }

    public boolean isEditMode(){
        return mIsEditMode;
    }

    public void setEditMode(boolean editMode){
        mIsEditMode = editMode;
        if (!mIsEditMode){
            mSparseItemChecked.clear();
        }
        notifyDataSetChanged();
    }

    /**
     * 切换item的选中状态
     */
    public void toggleItemChecked(int position, BaseViewHolder holder){
        boolean isChecked = mSparseItemChecked.get(position);
        holder.setChecked(R.id.cb_delete,!isChecked);
        handleCheckedChanged(position,!isChecked);
    }

    public void deleteItemChecked() {
        for (int i = mSparseItemChecked.size() - 1; i >= 0; i--) {
            if (mSparseItemChecked.valueAt(i)) {
                DownloaderWrapper.delete(getItem(mSparseItemChecked.keyAt(i)));
                removeItem(mSparseItemChecked.keyAt(i));
                mSparseItemChecked.delete(mSparseItemChecked.keyAt(i));
            }
        }
    }

    public void checkAllOrNone(boolean isChecked) {
        for (int i = 0; i < getItemCount(); i++) {
            mSparseItemChecked.put(i, isChecked);
        }
        notifyDataSetChanged();
    }

    public void updateDownload(FileInfo fileInfo) {
    }
}
