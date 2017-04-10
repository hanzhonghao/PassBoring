package com.exercise.passboring.utils;

import android.content.Context;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * 项目名称：PassBoring
 * 类描述：Assets帮助类
 * 创建人：小豪
 * 创建时间：2017/3/23 11:21
 * 修改人：小豪
 * 修改时间：2017/3/23 11:21
 * 修改备注：
 */

public class AssetsHelper {
    private AssetsHelper() {
        throw new AssertionError();
    }

    /**
     * 读取assets文件
     */
    public static String readData(Context context, String fileName) {
        InputStream inStream = null;
        String data = null;
        try {
            inStream = context.getAssets().open(fileName);//打开assets目录中的文件
            byte[] bytes = new byte[inStream.available()];//isStream.available()为文件中的总bye数
            inStream.read(bytes);
            inStream.close();
            data = new String(bytes, "utf-8");//将bytes转为utf-8字符串
        } catch (IOException e) {
            Logger.e(e.toString());
            e.printStackTrace();
        }
        return data;
    }
}
