package com.imooc.demo.bean;

import java.util.Date;

/**
 * 实体类
 */
public class Area {
    //地区id
    private  Integer areaId;
    //地区名称
    private  String  areaName;
    //权重
    private  Integer priority;
    //创建时间
    private  Date    createTime;
    //更新时间
    private  Date    lastEditTime;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", priority=" + priority +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                '}';
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;

    }
}
