package com.imooc.demo.web;

import com.imooc.demo.bean.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(value="/superadmin")
public class Areacontrller {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value="/listarea",method = RequestMethod.GET)
    private Map<String,Object>ListArea(){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        List<Area>list=new ArrayList<Area>();
        list=areaService.getAreaList();
        modelMap.put("arealist",list);
        return  modelMap;
    }
    @RequestMapping(value="/getareaid",method = RequestMethod.GET)
    private  Map<String,Object>getAraId(Integer areaid) {
        Map<String, Object> modelmap = new HashMap<String, Object>();
        Area area = areaService.getAreaId(areaid);
        modelmap.put("area",area);
        return  modelmap;
    }
    @RequestMapping(value="/addarea",method = RequestMethod.POST)
    private Map<String,Object>AddArea(@RequestBody Area area){
        Map<String, Object> modelmap = new HashMap<String, Object>();
        modelmap.put("success",areaService.addarea(area));
        return modelmap;
    }
    @RequestMapping(value="/modifyarea",method = RequestMethod.POST)
    private Map<String,Object>modifyArea(@RequestBody Area area){
        Map<String, Object> modelmap = new HashMap<String, Object>();
        modelmap.put("success",areaService.modifyarea(area));
        return modelmap;
    }
    @RequestMapping(value="/removearea",method = RequestMethod.GET)
    private Map<String,Object>removeArea(Integer areaid){
        Map<String, Object> modelmap = new HashMap<String, Object>();
        modelmap.put("success",areaService.daletearea(areaid));
        return modelmap;
    }
}
