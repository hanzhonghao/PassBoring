package com.exercise.passboring.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import jp.wasabeef.recyclerview.adapters.AnimationAdapter;

/**
 * 项目名称：PassBoring
 * 类描述：
 * 创建人：小豪
 * 创建时间：2017/3/28 11:31
 * 修改人：小豪
 * 修改时间：2017/3/28 11:31
 * 修改备注：
 */

public class SlideInBottomAdapter extends AnimationAdapter{
    public SlideInBottomAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        super(adapter);
    }

    @Override
    protected Animator[] getAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0)
        };
    }
}
