package com.exercise.passboring.utils;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * 项目名称：PassBoring
 * 类描述： Snackbar 工具
 * 创建人：小豪
 * 创建时间：2017/3/21 15:44
 * 修改人：小豪
 * 修改时间：2017/3/21 15:44
 * 修改备注：
 */

public class SnackbarUtils {
    /**
     * 显示Snackbar
     */
    public static void showSnackbar(Activity activity, String message, boolean isLong) {
        if (activity == null) {
            return;
        }
        View view = activity.getWindow().getDecorView().findViewById(android.R.id.content);//从当前activity获取根视图
        Snackbar.make(view, message, isLong ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT).show();
    }


}
