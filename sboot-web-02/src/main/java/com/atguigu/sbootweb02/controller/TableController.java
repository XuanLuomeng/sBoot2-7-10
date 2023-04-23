package com.atguigu.sbootweb02.controller;

import com.atguigu.sbootweb02.bean.User;
import com.atguigu.sbootweb02.exception.UserTooManyException;
import com.atguigu.sbootweb02.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes ra) {

        userService.removeById(id);

        ra.addAttribute("pn", pn);

        return "redirect:/dynamic_table";
    }

    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //表格内容的遍历
//        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//                new User("lisi", "123444"),
//                new User("haha", "aaaaaa"),
//                new User("hehe", "aaaddd"));
//        model.addAttribute("users",users);

//        if(users.size()>3){
//            throw new UserTooManyException();
//        }

        List<User> list = userService.list();

        Page<User> userPage = new Page<>(pn, 2);
        Page<User> page = userService.page(userPage, null);

        model.addAttribute("page", page);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }
}
