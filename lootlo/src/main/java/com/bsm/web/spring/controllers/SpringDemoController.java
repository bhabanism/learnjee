package com.bsm.web.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mishra on 14/8/17.
 */

@Controller
public class SpringDemoController {

    @RequestMapping("/greet")
    public String greet(ModelMap map) {
        map.put("msg", "Hello Noob!");
        return "greet";
    }
}
