package com.exercise.passboring;

import android.app.Application;
import android.content.Context;

import com.dl7.downloaderlib.DownloadConfig;
import com.dl7.downloaderlib.FileDownloader;
import com.exercise.passboring.api.RetrofitService;
import com.exercise.passboring.engine.DownloaderWrapper;
import com.exercise.passboring.greendao.DaoMaster;
import com.exercise.passboring.greendao.DaoSession;
import com.exercise.passboring.injector.component.ApplicationComponent;
import com.exercise.passboring.injector.component.DaggerApplicationComponent;
import com.exercise.passboring.injector.modules.ApplicationModule;
import com.exercise.passboring.local.dao.NewsTypeDao;
import com.exercise.passboring.rxbus.RxBus;
import com.exercise.passboring.utils.PreferencesUtils;
import com.exercise.passboring.utils.ToastUtils;

import org.greenrobot.greendao.database.Database;

import java.io.File;

/**
 * 项目名称：PassBoring
 * 类描述：Appliaction
 * 创建人：小豪
 * 创建时间：2017/3/17 15:54
 * 修改人：小豪
 * 修改时间：2017/3/17 15:54
 * 修改备注：
 */

public class App extends Application {

    private static final String DB_NAME = "new-db";

    private static Context sContext;
    private DaoSession mDaoSession;
    private static ApplicationComponent sAppComponent;

    // 因为下载那边需要用，这里在外面实例化在通过 ApplicationModule 设置
    private RxBus mRxBus = new RxBus();


    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        initDatabase();
        initInjector();
        initConfig();
    }

    public static Context getContext() {
        return sContext;
    }


    /**
     * 初始化数据库
     */
    private void initDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getApplicationContext(), DB_NAME);
        Database database = helper.getWritableDb();
        mDaoSession = new DaoMaster(database).newSession();
        NewsTypeDao.updateLocalData(this, mDaoSession);
//        DownloadUtils.init(mDaoSession.getBeautyPhotoInfoDao());
    }


    /**
     * 初始化配置
     */
    private void initConfig() {
        RetrofitService.init();
        ToastUtils.init(getApplicationContext());
        FileDownloader.init(getApplicationContext());
        DownloadConfig config = new DownloadConfig.Builder().
                setDownloadDir(PreferencesUtils.getSavePath(getApplicationContext()) + File.separator + "video/").build();
        FileDownloader.setConfig(config);
        DownloaderWrapper.init(mRxBus, mDaoSession.getVideoInfoDao());
    }

    /**
     * 初始化注射器
     */
    private void initInjector() {
        // 这里不做注入操作，只提供一些全局单例数据
        sAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this, mDaoSession, mRxBus))
                .build();
    }

    public static ApplicationComponent getAppComponent() {
        return sAppComponent;
    }
}
