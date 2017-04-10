package com.exercise.passboring.adapter.item;

import android.support.annotation.IntDef;

import com.dl7.recycler.entity.MultiItemEntity;
import com.exercise.passboring.api.bean.NewsInfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 项目名称：PassBoring
 * 类描述：新闻复用列表项
 * 创建人：小豪
 * 创建时间：2017/3/22 14:20
 * 修改人：小豪
 * 修改时间：2017/3/22 14:20
 * 修改备注：
 */

public class NewsMultiItem extends MultiItemEntity {

    public static final int ITEM_TYPE_NORMAL = 1;
    public static final int ITEM_TYPE_PHOTO_SET = 2;

    private NewsInfo mNewsBean;

    public NewsMultiItem(@NewsItemType int itemType, NewsInfo newsBean) {
        super(itemType);
        mNewsBean = newsBean;
    }

    public NewsInfo getNewsBean() {
        return mNewsBean;
    }

    public void setNewsBean(NewsInfo newsBean) {
        mNewsBean = newsBean;
    }

    @Override
    public void setItemType(@NewsItemType int itemType) {
        super.setItemType(itemType);
    }

    /**
     * 注解代替枚举
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({ITEM_TYPE_NORMAL, ITEM_TYPE_PHOTO_SET})
    public @interface NewsItemType {
    }


}
