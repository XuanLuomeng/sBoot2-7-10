package com.atguigu.sbootweb01.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 当spring:
 *   mvc:
 *     hiddenmethod:
 *       filter:
 *         enabled: true
 *  时才能采用rest风格，且html使用put和deleter请求时需要使用post，其次标签内需要设置
 *  <input name="_method" type="hidden" value="请求方式">
 *  name可以通过后端设置HiddenHttpMethodFilter的setMethodParam来设置
 */
@RestController
public class HelloController {
    @RequestMapping("/bug.jpg")
    public String hello(){
        return "aaaa";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "GET-张三";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "POST-张三";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){
        return "PUT-张三";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleterUser(){
        return "DELETER-张三";
    }
}
