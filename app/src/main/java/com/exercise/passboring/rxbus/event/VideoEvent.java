package com.exercise.passboring.rxbus.event;

import android.support.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 项目名称：PassBoring
 * 类描述：Video 事件
 * 创建人：小豪
 * 创建时间：2017/3/27 16:22
 * 修改人：小豪
 * 修改时间：2017/3/27 16:22
 * 修改备注：
 */

public class VideoEvent {
    /**
     * Video 缓存列表选中事件：全没选、选中部分、全选
     */
    public static final int CHECK_INVALID = 400;
    public static final int CHECK_NONE = 401;
    public static final int CHECK_SOME = 402;
    public static final int CHECK_ALL = 403;

    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.PARAMETER)
    @IntDef({CHECK_INVALID, CHECK_NONE, CHECK_SOME, CHECK_ALL})
    public @interface CheckStatus {}

    public int checkStatus = CHECK_INVALID;

    public VideoEvent() {
    }

    public VideoEvent(@CheckStatus int checkStatus) {
        this.checkStatus = checkStatus;
    }
}
