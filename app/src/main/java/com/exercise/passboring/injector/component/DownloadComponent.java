package com.exercise.passboring.injector.component;

import com.exercise.passboring.injector.PerActivity;
import com.exercise.passboring.injector.modules.DownloadModule;
import com.exercise.passboring.module.manage.download.DownloadActivity;

import dagger.Component;

/**
 * 项目名称：PassBoring
 * 类描述：video下载 Component
 * 创建人：小豪
 * 创建时间：2017/3/28 15:05
 * 修改人：小豪
 * 修改时间：2017/3/28 15:05
 * 修改备注：
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = DownloadModule.class)
public interface DownloadComponent {
    void inject(DownloadActivity activity);
}
