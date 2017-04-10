package com.exercise.passboring.local.dao;

import android.content.Context;

import com.exercise.passboring.greendao.DaoSession;
import com.exercise.passboring.greendao.NewsTypeInfoDao;
import com.exercise.passboring.local.table.NewsTypeInfo;
import com.exercise.passboring.utils.AssetsHelper;
import com.exercise.passboring.utils.GsonHelper;

import java.util.List;

/**
 * 项目名称：PassBoring
 * 类描述： 新闻分类数据访问
 * 创建人：小豪
 * 创建时间：2017/3/23 11:11
 * 修改人：小豪
 * 修改时间：2017/3/23 11:11
 * 修改备注：
 */

public class NewsTypeDao {
    // 所有栏目
    private static List<NewsTypeInfo> sAllChannels;


    private NewsTypeDao() {
    }

    /**
     * 更新本地数据，如果数据库新闻列表栏目为 0 则添加头 3 个栏目
     * @param context
     * @param daoSession
     */
    public static void updateLocalData(Context context, DaoSession daoSession) {
        sAllChannels = GsonHelper.convertEntities(AssetsHelper.readData(context, "NewsChannel"), NewsTypeInfo.class);
        NewsTypeInfoDao beanDao = daoSession.getNewsTypeInfoDao();
        if (beanDao.count() == 0) {
            beanDao.insertInTx(sAllChannels.subList(0, 3));
        }
    }

    /**
     * 获取所有栏目
     * @return
     */
    public static List<NewsTypeInfo> getAllChannels() {
        return sAllChannels;
    }
}