package com.exercise.passboring.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.exercise.passboring.R;
import com.github.ybq.android.spinkit.SpinKitView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称：PassBoring
 * 类描述：加载、空视图
 * 创建人：小豪
 * 创建时间：2017/3/17 16:37
 * 修改人：小豪
 * 修改时间：2017/3/17 16:37
 * 修改备注：
 */

public class EmptyLayout extends FrameLayout {
    public static final int STATUS_HIDE = 1001;
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_NO_NET = 2;
    public static final int STATUS_NO_DATA = 3;

    @BindView(R.id.empty_loading)
    SpinKitView mEmptyLoading;
    @BindView(R.id.tv_net_error)
    TextView mTvNetError;
    @BindView(R.id.rl_empty_container)
    FrameLayout mRlEmptyContainer;
    @BindView(R.id.empty_layout)
    FrameLayout mEmptyLayout;

    private OnRetryListener mOnRetryListener;

    private int mEmptyStatue = STATUS_LOADING;

    private Context mContext;

    private int mBgColor;

    public EmptyLayout(@NonNull Context context) {
        super(context, null);
    }

    public EmptyLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(attrs);
    }

    /**
     * 初始化
     */
    private void init(AttributeSet attrs) {
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.EmptyLayout);
        try {
            mBgColor = a.getColor(R.styleable.EmptyLayout_background_color, Color.WHITE);
        } finally {
            a.recycle();
        }
        View.inflate(mContext, R.layout.layout_empty_loading, this);
        ButterKnife.bind(this);
        mEmptyLayout.setBackgroundColor(mBgColor);
        switchEmptyView();
    }

    /**
     * 隐藏视图
     */
    public void hide() {
        mEmptyStatue = STATUS_HIDE;
        switchEmptyView();
    }

    /**
     * 设置状态
     */
    public void setEmptyStatus(@EmptyStatus int emptyStatus) {
        mEmptyStatue = emptyStatus;
        switchEmptyView();
    }

    /**
     * 获取状态
     */
    public int getEmptyStatue() {
        return mEmptyStatue;
    }

    /**
     * 设置重试监听器
     */
    public void setRetryListerer(OnRetryListener retryListener) {
        this.mOnRetryListener = retryListener;
    }

    /**
     * 点击重试监听器
     */
    public interface OnRetryListener {
        void onRetry();
    }

    /**
     * 切换视图
     */
    private void switchEmptyView() {
        switch (mEmptyStatue) {
            case STATUS_LOADING:
                setVisibility(VISIBLE);
                mRlEmptyContainer.setVisibility(GONE);
                mEmptyLoading.setVisibility(VISIBLE);
                break;
            case STATUS_NO_DATA:
            case STATUS_NO_NET:
                setVisibility(VISIBLE);
                mEmptyLoading.setVisibility(GONE);
                mRlEmptyContainer.setVisibility(VISIBLE);
                break;
            case STATUS_HIDE:
                setVisibility(GONE);
                break;
        }
    }

    @OnClick(R.id.tv_net_error)
    public void onClick() {
        if (mOnRetryListener != null) {
            mOnRetryListener.onRetry();
        }
    }

    //自定义注解取代枚举
    //自定义注解.定义适用于参数的注解，限定取值范围为{STATUS_LOADING, STATUS_NO_NET, STATUS_NO_DATA}
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({STATUS_LOADING, STATUS_NO_NET, STATUS_NO_DATA})
    public @interface EmptyStatus {
    }
}
