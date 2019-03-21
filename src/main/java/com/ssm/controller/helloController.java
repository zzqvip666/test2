package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.User;
import com.ssm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class helloController {

    @Autowired
    private HelloService helloService;


    @RequestMapping("/hello")
    @ResponseBody
    public  Object hello(){

        return "";

    }

    @RequestMapping("/user/list2")
    public @ResponseBody  Object  userslist(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize){

            //开始分页  当加上该句的时候  在查询就是查询的分页数据了
        PageHelper.startPage(currentPage,pageSize);
        //PageInfo就是类似于我们以前写的PageBean


        List<User> users = helloService.userList();
        /**
         * 第一个参数分页数据：
         * 第二个参数是：分页导航页码
         */
        PageInfo<User> pageInfo = new PageInfo<>(users, 3);


        return pageInfo;
    }
    @RequestMapping("/user/list")
    public   String  userslist2(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize, Model model){

        //开始分页  当加上该句的时候  在查询就是查询的分页数据了
        PageHelper.startPage(currentPage,pageSize);
        //PageInfo就是类似于我们以前写的PageBean


        List<User> users = helloService.userList();
        /**
         * 第一个参数分页数据：
         * 第二个参数是：分页导航页码
         */
        PageInfo<User> pageInfo = new PageInfo<>(users, 3);

        model.addAttribute("page",pageInfo);

        return "allusers";
    }
}
