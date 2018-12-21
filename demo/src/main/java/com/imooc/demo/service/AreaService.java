package com.imooc.demo.service;

import com.imooc.demo.bean.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAreaList();
    Area getAreaId(int areaId);
    boolean addarea(Area area);
    boolean modifyarea(Area area);
    boolean daletearea(int areaId);
}
