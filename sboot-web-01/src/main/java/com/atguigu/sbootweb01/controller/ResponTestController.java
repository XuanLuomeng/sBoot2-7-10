package com.atguigu.sbootweb01.controller;

import com.atguigu.sbootweb01.bean.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponTestController {

    @ResponseBody
    @GetMapping("he11")
    public FileSystemResource file(){
        //文件以这样的方式返回看是谁处理的(messageConverter)。
        return null;
    }

    /**
     * 1、浏览器发请求直接返回xml [application/xml]   jacksonXmlConverter
     * 2、如果是ajax请求返回json [application/json]   jacksonJsonConverter
     * 3、如果app发送请求，返回自定义协议数据 [application/???]   ???Converter
     *
     * 步骤:
     * 1、添加自定义的MessageConverter进系统底层
     * 2、系统底层就会统计出所有MessageConverter能操作哪些数据
     * 3、客户端内容协商[???--->???]
     * @return
     */
    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("lisi");
        return person;
    }
}
