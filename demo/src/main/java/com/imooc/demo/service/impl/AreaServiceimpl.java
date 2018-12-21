package com.imooc.demo.service.impl;

import com.imooc.demo.bean.Area;
import com.imooc.demo.Dao.AreaDao;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class AreaServiceimpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList()  {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaId(int areaId) {
        return areaDao.queryAreaid(areaId);
    }
    @Transactional
    @Override
    public boolean addarea(Area area) {
        if (area.getAreaName()!=null && !"".equals(area.getAreaName())){
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        try {
            int effenum = areaDao.insertArea(area);
            if (effenum > 0) {
                return true;
            }else {
                throw new RuntimeException("插入信息失败!");
            }
        }catch (Exception e){
                throw  new RuntimeException("插入信息失败"+e.getMessage());
            }
        }else{
            throw  new RuntimeException("区域信息不能为空");
            }
    }

    @Override
    public boolean modifyarea(Area area) {
        try {
            int effeunm = areaDao.updateArea(area);
            if (effeunm > 0) {
                return true;
            } else {
                throw new RuntimeException("更新信息失败！");
            }
     }catch(Exception e){
            throw  new RuntimeException("更新信息失败"+e.getMessage());
        }
    }

    @Override
    public boolean daletearea(int areaId) {
        try {
            int effeunm =areaDao.deletearea(areaId);
            if (effeunm > 0) {
                return true;
            } else {
                throw new RuntimeException("删除信息失败！");
            }
        }catch(Exception e){
            throw  new RuntimeException("删除信息失败"+e.getMessage());
        }
    }
}
