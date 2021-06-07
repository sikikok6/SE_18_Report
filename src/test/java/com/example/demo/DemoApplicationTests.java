package com.example.demo;

import com.example.demo.Service.ApplyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    ApplyService applyService;

    @Test
    void TestGet() {
        applyService.GetApplications();
    }

}
