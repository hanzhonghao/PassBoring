package com.exercise.passboring.api;

import android.support.annotation.NonNull;

import com.exercise.passboring.api.bean.NewsInfo;

/**
 * 项目名称：PassBoring
 * 类描述：工具类
 * 创建人：小豪
 * 创建时间：2017/3/22 16:23
 * 修改人：小豪
 * 修改时间：2017/3/22 16:23
 * 修改备注：
 */

public class NewsUtils {

    // 新闻列表头部
    private static final int HAS_HEAD = 1;

    private static final String NEWS_ITEM_SPECIAL = "special";
    private static final String NEWS_ITEM_PHOTO_SET = "photoset";

    /**
     * 判断是否为广告
     */
    public static boolean isAdNews(@NonNull NewsInfo newsBean) {
        return (newsBean.getHasHead() == HAS_HEAD &&
                newsBean.getAds() != null && newsBean.getAds().size() > 1);
    }


    /**
     * 判断新闻类型
     *
     * @param skipType
     * @return
     */
    public static boolean isNewsSpecial(String skipType) {
        return NEWS_ITEM_SPECIAL.equals(skipType);
    }

    public static boolean isNewsPhotoSet(String skipType) {
        return NEWS_ITEM_PHOTO_SET.equals(skipType);
    }
}
