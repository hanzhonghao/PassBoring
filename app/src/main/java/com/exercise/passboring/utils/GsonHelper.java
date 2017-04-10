package com.exercise.passboring.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：PassBoring
 * 类描述：Gson数据转化处理
 * 创建人：小豪
 * 创建时间：2017/3/23 11:14
 * 修改人：小豪
 * 修改时间：2017/3/23 11:14
 * 修改备注：
 */

public class GsonHelper {

    private static Gson sGson = new Gson();

    private static JsonParser sJsonParser = new JsonParser();

    public GsonHelper() {
    }

    /**
     * 将json数据转换成实体列表数据
     */
    public static <T> List<T>convertEntities(String jsonData,Class<T> entityClass){
        List<T> entities = new ArrayList<>();
        try{
            JsonArray jsonArray = sJsonParser.parse(jsonData).getAsJsonArray();
            for (JsonElement element: jsonArray){
                entities.add(sGson.fromJson(element,entityClass));
            }
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return entities;
    }
}
