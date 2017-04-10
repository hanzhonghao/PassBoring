package com.exercise.passboring.injector.component;

import com.exercise.passboring.injector.PerFragment;
import com.exercise.passboring.injector.modules.NewsMainModule;
import com.exercise.passboring.module.news.main.NewsMainFragment;

import dagger.Component;

/**
 * 项目名称：PassBoring
 * 类描述： 主页Component
 * 创建人：小豪
 * 创建时间：2017/3/22 9:38
 * 修改人：小豪
 * 修改时间：2017/3/22 9:38
 * 修改备注：
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = NewsMainModule.class)
public interface NewsMainComponent {
    void inject(NewsMainFragment fragment);
}