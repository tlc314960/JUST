package com.ruoyi;

import com.ruoyi.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Test {


    public static void main(String[] args) {
        TestService a = new TestService();
        System.out.println(a.helloTest());
    }
}
