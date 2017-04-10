package com.exercise.passboring.local.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 项目名称：PassBoring
 * 类描述：新闻类型
 * 创建人：小豪
 * 创建时间：2017/3/21 19:33
 * 修改人：小豪
 * 修改时间：2017/3/21 19:33
 * 修改备注：
 */
@Entity
public class NewsTypeInfo {

    @Id(autoincrement = true)
    private Long id;
    private  String name;
    private String typeId;

    @Generated(hash = 1707873593)
    public NewsTypeInfo(Long id, String name, String typeId) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
    }

    @Generated(hash = 215923915)
    public NewsTypeInfo() {

    }
    public String getTypeId() {
        return this.typeId;
    }
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "NewsTypeBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId='" + typeId + '\'' +
                '}';
    }
}
