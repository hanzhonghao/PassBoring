package com.exercise.passboring.api;

import com.exercise.passboring.api.bean.NewsInfo;
import com.exercise.passboring.local.table.VideoInfo;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

import static com.exercise.passboring.api.RetrofitService.AVOID_HTTP403_FORBIDDEN;
import static com.exercise.passboring.api.RetrofitService.CACHE_CONTROL_NETWORK;

/**
 * 项目名称：PassBoring
 * 类描述：API接口
 * 创建人：小豪
 * 创建时间：2017/3/22 15:37
 * 修改人：小豪
 * 修改时间：2017/3/22 15:37
 * 修改备注：
 */

public interface INewsApi {
    /**
     * 获取新闻列表
     * eg: http://c.m.163.com/nc/article/headline/T1348647909107/60-20.html
     * http://c.m.163.com/nc/article/list/T1348647909107/60-20.html
     *
     * @param type      新闻类型
     * @param id        新闻ID
     * @param startPage 起始页码
     * @return
     */
    @Headers(CACHE_CONTROL_NETWORK)
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String, List<NewsInfo>>> getNewsList(@Path("type") String type, @Path("id") String id,
                                                        @Path("startPage") int startPage);

    /**
     * 获取视频列表
     * eg: http://c.3g.163.com/nc/video/list/V9LG4B3A0/n/10-10.html
     *
     * @param id  video ID
     * @param startPage 起始页码
     * @return
     */
    @Headers(AVOID_HTTP403_FORBIDDEN)
    @GET("nc/video/list/{id}/n/{startPage}-10.html")
    Observable<Map<String,List<VideoInfo>>> getVideoList(@Path("id") String id,
                                                         @Path("startPage") int startPage);
}
