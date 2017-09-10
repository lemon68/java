package com.jjly.api.controller;


import com.beust.jcommander.internal.Lists;
import com.jjly.client.IUserClient;
import com.jjly.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by helen
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private IUserClient userClient;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        List<User> userList = userClient.findAll();
        model.addAttribute("userList",userList);
        return "show_user";
    }
    @RequestMapping("/showUserRes")
    @ResponseBody
    public User showUserRes( User user){
        log.info("查询所有用户信息");
        return user;
    }
    @RequestMapping("/getUser")
    public String getUser(Model model){
        List<User> userList=Lists.newArrayList();
        User user=userClient.getByLoginAccount("111111");
        userList.add(user);
        model.addAttribute("userList",userList);
        return "show_user";
    }
}
