package com.exercise.passboring.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * 项目名称：PassBoring
 * 类描述：测量工具类
 * 创建人：小豪
 * 创建时间：2017/3/20 14:48
 * 修改人：小豪
 * 修改时间：2017/3/20 14:48
 * 修改备注：
 */

public class MeasureUtils {
    public static float dp2px(Context context, float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, context.getResources().getDisplayMetrics());
    }

    public static float sp2px(Context context, float sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                context.getResources().getDisplayMetrics());
    }


}
