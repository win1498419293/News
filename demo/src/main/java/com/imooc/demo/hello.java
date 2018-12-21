package com.imooc.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class hello {
    @RequestMapping(value = "/hello",method = RequestMethod.GET )
    public String hello(){
        return "Hello world";
    }
}
