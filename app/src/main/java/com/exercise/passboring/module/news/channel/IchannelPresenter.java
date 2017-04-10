package com.exercise.passboring.module.news.channel;

import com.exercise.passboring.module.base.ILocalPresenter;

/**
 * 项目名称：PassBoring
 * 类描述：频道 Presenter 接口
 * 创建人：小豪
 * 创建时间：2017/3/27 10:54
 * 修改人：小豪
 * 修改时间：2017/3/27 10:54
 * 修改备注：
 */

public interface IchannelPresenter<T> extends ILocalPresenter<T> {
    /**
     * 交换
     */
    void swap(int fromPos,int toPos);
}
