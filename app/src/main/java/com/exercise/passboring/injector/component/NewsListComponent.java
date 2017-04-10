package com.exercise.passboring.injector.component;

import com.exercise.passboring.injector.PerFragment;
import com.exercise.passboring.injector.modules.NewsListModule;
import com.exercise.passboring.module.news.newslist.NewsListFragment;

import dagger.Component;

/**
 * 项目名称：PassBoring
 * 类描述：新闻列表 Component
 * 创建人：小豪
 * 创建时间：2017/3/22 15:00
 * 修改人：小豪
 * 修改时间：2017/3/22 15:00
 * 修改备注：
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class,modules = NewsListModule.class)
public interface NewsListComponent {
    void inject(NewsListFragment fragment);
}
