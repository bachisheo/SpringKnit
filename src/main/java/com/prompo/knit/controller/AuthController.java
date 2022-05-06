package com.prompo.knit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthController {
    @GetMapping("/login")
    @ResponseBody
    public ModelAndView getLoginPage() {
        ModelAndView mav = new ModelAndView("login_page");
        return mav;
    }
    @PostMapping("/login")
    public RedirectView auth() {
        return new RedirectView("index");
    }
    @PostMapping("/logout")
    public RedirectView oauth() {
        return new RedirectView("login");
    }

    @GetMapping("/login/access")
    public ModelAndView accessauth() {
        var mav = new ModelAndView("login_page");
        var param = new HashMap<String, Object>();
        param.put("access_error", new Object());
        mav.getModel().put("mypar", param);
        return mav;
    }
}