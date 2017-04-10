package com.exercise.passboring.injector.component;

import com.exercise.passboring.injector.PerFragment;
import com.exercise.passboring.injector.modules.VideoCacheModule;
import com.exercise.passboring.module.manage.download.cache.VideoCacheFragment;

import dagger.Component;

/**
 * 项目名称：PassBoring
 * 类描述：
 * 创建人：小豪
 * 创建时间：2017/3/28 16:18
 * 修改人：小豪
 * 修改时间：2017/3/28 16:18
 * 修改备注：
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = VideoCacheModule.class)
public interface VideoCacheComponent {
    void inject(VideoCacheFragment fragment);
}