package com.imooc.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseBody
    private Map<String,Object>exceptionHandler(HttpServletRequest request,Exception e){
        Map<String, Object> modelmap = new HashMap<String, Object>();
        modelmap.put("success",false);
        modelmap.put("errMsg",e.getMessage());
        return  modelmap;
    }

}
