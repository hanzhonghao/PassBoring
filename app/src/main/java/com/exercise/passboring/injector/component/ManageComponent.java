package com.exercise.passboring.injector.component;

import com.exercise.passboring.injector.PerActivity;
import com.exercise.passboring.injector.modules.ChannelModule;
import com.exercise.passboring.module.news.channel.ChannelActivity;

import dagger.Component;

/**
 * 项目名称：PassBoring
 * 类描述：管理Component
 * 创建人：小豪
 * 创建时间：2017/3/27 11:15
 * 修改人：小豪
 * 修改时间：2017/3/27 11:15
 * 修改备注：
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ChannelModule.class)
public interface ManageComponent {
    void inject(ChannelActivity activity);
}
