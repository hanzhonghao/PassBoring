package com.exercise.passboring.module.base;

import rx.functions.Action1;

/**
 * 项目名称：PassBoring
 * 类描述：RxBus Presenter
 * 创建人：小豪
 * 创建时间：2017/3/21 21:30
 * 修改人：小豪
 * 修改时间：2017/3/21 21:30
 * 修改备注：
 */

public interface IRxBusPresenter extends IBasePresenter{

    /**
     * 注册
     */
    <T> void registerRxBux(Class<T> eventType,Action1<T> action);

    /**
     * 注销
     */
    void unregisterRxBus();
}
