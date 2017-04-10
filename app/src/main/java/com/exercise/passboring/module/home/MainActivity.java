package com.exercise.passboring.module.home;

import android.Manifest;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.dl7.downloaderlib.FileDownloader;
import com.exercise.passboring.R;
import com.exercise.passboring.module.base.BaseActivity;
import com.exercise.passboring.module.news.main.NewsMainFragment;
import com.exercise.passboring.module.video.main.VideoMainFragment;
import com.exercise.passboring.utils.SnackbarUtils;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.io.File;

import butterknife.BindView;
import rx.functions.Action1;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.fl_container)
    FrameLayout mFlContainer;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    //SparseArray用来性能优化
    private SparseArray<String> mSparseTags = new SparseArray<>();
    private int mItemId = -1;
    private long mExitTime = 0;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case R.id.nav_news:
                    replaceFragment(R.id.fl_container, new NewsMainFragment(), mSparseTags.get(R.id.nav_news));
                    break;
                case R.id.nav_photos:
                    replaceFragment(R.id.fl_container, new NewsMainFragment(), mSparseTags.get(R.id.nav_photos));
                    break;
                case R.id.nav_videos:
                    replaceFragment(R.id.fl_container, new VideoMainFragment(), mSparseTags.get(R.id.nav_videos));
                    break;
                case R.id.nav_setting:
//                    SettingActivity.launch(MainActivity.this);
                    break;
            }
            mItemId = -1;
            return true;
        }
    });


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        initDrawerLayout(mDrawerLayout, mNavView);
        mSparseTags.put(R.id.nav_news, "News");
        mSparseTags.put(R.id.nav_photos, "Photos");
        mSparseTags.put(R.id.nav_videos, "Videos");
//        getPermission();
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        mNavView.setCheckedItem(R.id.nav_news);//默认选中新闻
        addFragment(R.id.fl_container, new NewsMainFragment(), "News");
    }

    /**
     * 初始化DrawerLayout
     *
     * @param drawerLayout
     * @param navView
     */
    private void initDrawerLayout(DrawerLayout drawerLayout, NavigationView navView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
            //将侧边栏顶部延伸至status bar
            drawerLayout.setFitsSystemWindows(true);
            //将主页面顶部延伸至status bar
            drawerLayout.setClipToPadding(false);
        }
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerClosed(View drawerView) {
                mHandler.sendEmptyMessage(mItemId);
            }
        });
        navView.setNavigationItemSelectedListener(this);
    }

    /**
     * 基于RxJava开发的用于帮助在Android 6.0中处理运行时权限检测
     */
    private void getPermission() {
        final File dir = new File(FileDownloader.getDownloadDir());
        if (!dir.exists() || !dir.isDirectory()) {
            dir.delete();
            new RxPermissions(this).request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE)
                    .subscribe(new Action1<Boolean>() {
                        @Override
                        public void call(Boolean aBoolean) {
                            if (aBoolean) {
                                dir.mkdirs();
                            } else {
                                SnackbarUtils.showSnackbar(MainActivity.this, "下载目录创建失败", true);
                            }
                        }
                    });
        }
    }

    /**
     * 实现类接口必须实现的方法
     * 即点击任何一个子项目都会关闭侧边栏
     *
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        if (item.isChecked()) {
            return true;
        }
        mItemId = item.getItemId();
        return true;
    }

    @Override
    public void onBackPressed() {
        //获取堆栈里的有几个
        int stackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else if (stackEntryCount == 1) {
            // 如果剩一个说明在主页，提示按两次退出app
            exit();
        } else {
            //// 获取上一个堆栈中保存的是哪个页面，根据name来设置导航项的选中状态
            String tagName = getSupportFragmentManager().getBackStackEntryAt(stackEntryCount - 2).getName();
            mNavView.setCheckedItem(mSparseTags.keyAt(mSparseTags.indexOfValue(tagName)));
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 退出
     */
    private void exit() {
        if (System.currentTimeMillis() - mExitTime > 2000) {
            SnackbarUtils.showSnackbar(this, "再按一次退出程序", true);
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
