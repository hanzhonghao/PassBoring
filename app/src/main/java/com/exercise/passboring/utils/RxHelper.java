package com.exercise.passboring.utils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 项目名称：PassBoring
 * 类描述：RxJava帮助类
 * 创建人：小豪
 * 创建时间：2017/3/20 14:18
 * 修改人：小豪
 * 修改时间：2017/3/20 14:18
 * 修改备注：
 */

public class RxHelper {
    private RxHelper() {
        throw new AssertionError();
    }

    /**
     * 倒计时
     * @param time
     * @return
     */
    public static Observable<Integer> countdown(int time) {
        if (time < 0) {
            time = 0;
        }
        final int countTime = time;

        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .map(new Func1<Long, Integer>() {
                    @Override
                    public Integer call(Long increaseTime) {
                        return countTime - increaseTime.intValue();
                    }
                })
                .take(countTime + 1)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
