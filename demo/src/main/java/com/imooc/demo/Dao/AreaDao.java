package com.imooc.demo.Dao;

import com.imooc.demo.bean.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AreaDao {
        //查询结果并以list集合形式返回
        List<Area> queryArea();
        //查询结果以实体类方式返回
        Area queryAreaid(int areaId);
        //增加地区
        int  insertArea(Area area);
        //修改地区
        int  updateArea(Area area);
        //删除地区
        int  deletearea(int areaId);
}
