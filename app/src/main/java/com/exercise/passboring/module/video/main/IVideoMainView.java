package com.exercise.passboring.module.video.main;

/**
 * 项目名称：PassBoring
 * 类描述：video 主界面接口
 * 创建人：小豪
 * 创建时间：2017/3/27 14:58
 * 修改人：小豪
 * 修改时间：2017/3/27 14:58
 * 修改备注：
 */

interface IVideoMainView {
    /**
     * 更新数据
     * @param lovedCount 收藏数
     */
    void updateLovedCount(int lovedCount);

    /**
     * 更新数据
     * @param downloadCount 下载中个数
     */
    void updateDownloadCount(int downloadCount);
}
