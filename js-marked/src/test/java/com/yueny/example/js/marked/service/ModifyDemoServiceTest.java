package com.yueny.example.js.marked.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yueny on 2018/10/8 0008.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ModifyDemoServiceTest {
    @Autowired
    private IModifyDemoService modifyDemoService;

    @Test
    public void testetDemoData() {
        String data = modifyDemoService.getDemoData();
        System.out.println(("data is :" + data));
    }

}
