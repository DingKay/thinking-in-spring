package com.dk.geek.bean.web.controller;

import com.dk.geek.bean.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    private User user;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", user);
        return "index";
    }
}
