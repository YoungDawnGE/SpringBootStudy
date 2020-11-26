package com.gyc.springbootstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by GYC
 * 2020/11/23 20:32
 */

@Controller
@RequestMapping("/gyc")
public class GycController {


    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

}
