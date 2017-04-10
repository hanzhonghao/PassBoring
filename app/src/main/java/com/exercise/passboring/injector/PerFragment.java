package com.exercise.passboring.injector;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * 项目名称：PassBoring
 * 类描述：单例表示
 * 创建人：小豪
 * 创建时间：2017/3/22 9:58
 * 修改人：小豪
 * 修改时间：2017/3/22 9:58
 * 修改备注：
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
