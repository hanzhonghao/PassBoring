package com.exercise.passboring.injector.component;

import com.exercise.passboring.injector.PerFragment;
import com.exercise.passboring.injector.modules.VideoMainModule;
import com.exercise.passboring.module.video.main.VideoMainFragment;

import dagger.Component;

/**
 * 项目名称：PassBoring
 * 类描述：食品界面Component
 * 创建人：小豪
 * 创建时间：2017/3/27 15:01
 * 修改人：小豪
 * 修改时间：2017/3/27 15:01
 * 修改备注：
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class,modules = VideoMainModule.class)
public interface VideoMainComponent {
    void inject(VideoMainFragment fragment);
}
