package com.dk.geek.bean.web.controller;

import com.dk.geek.bean.domain.User;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dkay
 * @version 1.0
 */
@Controller
public class IndexController {

    @Autowired
    @Qualifier("requestUser")
    private User requestUser;

    @Autowired
    @Qualifier("sessionUser")
    private User sessionUser;

    @Autowired
    @Qualifier("servletContextUser")
    private User servletContextUser;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("requestUser", requestUser);
        model.addAttribute("sessionUser", sessionUser);
        // servletContextUser 对象需要调用，不然jsp无法获取到
        servletContextUser.setAge(30);
        return "index";
    }
}
