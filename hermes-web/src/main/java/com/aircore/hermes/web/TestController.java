package com.aircore.hermes.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghf@belink.com
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    private String test(){
        return "成功！";
    }


}
