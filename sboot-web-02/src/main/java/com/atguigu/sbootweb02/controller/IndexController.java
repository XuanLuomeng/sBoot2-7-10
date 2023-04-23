package com.atguigu.sbootweb02.controller;

import com.atguigu.sbootweb02.bean.City;
import com.atguigu.sbootweb02.bean.Student;
import com.atguigu.sbootweb02.bean.User;
import com.atguigu.sbootweb02.service.impl.CityServiceImpl;
import com.atguigu.sbootweb02.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    CityServiceImpl cityService;

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityId(@RequestParam("id") Long id) {
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/student")
    public Student getById(@RequestParam("id") Integer id) {
        return studentService.getStudentById(id);
    }

    /**
     * 登陆页面
     *
     * @return
     */
    @GetMapping(value = {"", "/login"})
    public String loginPage() {
        return "login";
    }


    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())) {
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
        //登陆成功重定向到main.html,重定向防止表单重复提交
    }

    /**
     * 去main页面
     *
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage() {
        //是否登录。   拦截器，过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null) {
//            return "main";
//        } else {
//            //返回登陆页面
//            model.addAttribute("msg", "请重新登录");
//            return "login";
//        }
        return "main";
    }
}
