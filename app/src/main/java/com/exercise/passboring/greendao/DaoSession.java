package com.exercise.passboring.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.exercise.passboring.local.table.NewsTypeInfo;
import com.exercise.passboring.local.table.VideoInfo;

import com.exercise.passboring.greendao.NewsTypeInfoDao;
import com.exercise.passboring.greendao.VideoInfoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig newsTypeInfoDaoConfig;
    private final DaoConfig videoInfoDaoConfig;

    private final NewsTypeInfoDao newsTypeInfoDao;
    private final VideoInfoDao videoInfoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        newsTypeInfoDaoConfig = daoConfigMap.get(NewsTypeInfoDao.class).clone();
        newsTypeInfoDaoConfig.initIdentityScope(type);

        videoInfoDaoConfig = daoConfigMap.get(VideoInfoDao.class).clone();
        videoInfoDaoConfig.initIdentityScope(type);

        newsTypeInfoDao = new NewsTypeInfoDao(newsTypeInfoDaoConfig, this);
        videoInfoDao = new VideoInfoDao(videoInfoDaoConfig, this);

        registerDao(NewsTypeInfo.class, newsTypeInfoDao);
        registerDao(VideoInfo.class, videoInfoDao);
    }
    
    public void clear() {
        newsTypeInfoDaoConfig.clearIdentityScope();
        videoInfoDaoConfig.clearIdentityScope();
    }

    public NewsTypeInfoDao getNewsTypeInfoDao() {
        return newsTypeInfoDao;
    }

    public VideoInfoDao getVideoInfoDao() {
        return videoInfoDao;
    }

}