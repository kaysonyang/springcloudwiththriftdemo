package com.jia50.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 02 on 2016/8/15.
 */
@RestController
public class DemoController {
    @RequestMapping("/pay")
    public String home() throws Exception {

        return new String("Hello World");
    }
}
