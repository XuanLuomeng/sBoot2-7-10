package com.atguigu.sbootweb02.controller;

import com.atguigu.sbootweb02.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

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
    public String mainPage(HttpSession session, Model model) {
        //是否登录。   拦截器，过滤器
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg", "请重新登录");
            return "login";
        }
    }
}
