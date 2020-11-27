package com.gyc.springbootstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * Created by GYC
 * 2020/11/26 7:17
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("msg", "<h2>你好,YoungDawn!</h2>");
        model.addAttribute("list", Arrays.asList("GYC", "HR", "MJY"));
        return "index";
    }

    @RequestMapping("/download")
    public String indextest() {
        return "download";
    }
}
