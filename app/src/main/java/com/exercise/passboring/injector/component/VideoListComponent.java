package com.exercise.passboring.injector.component;

import com.exercise.passboring.injector.PerFragment;
import com.exercise.passboring.injector.modules.VideoListModule;
import com.exercise.passboring.module.video.list.VideoListFragment;

import dagger.Component;

/**
 * 项目名称：PassBoring
 * 类描述：
 * 创建人：小豪
 * 创建时间：2017/3/28 10:53
 * 修改人：小豪
 * 修改时间：2017/3/28 10:53
 * 修改备注：
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class,modules = VideoListModule.class)
public interface VideoListComponent {
    void inject(VideoListFragment fragment);
}
