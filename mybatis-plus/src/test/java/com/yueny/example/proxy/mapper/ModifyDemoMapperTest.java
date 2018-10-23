package com.yueny.example.proxy.mapper;

import com.yueny.example.proxy.entry.ModifyDemo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by yueny on 2018/9/25 0025.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ModifyDemoMapperTest {
    @Autowired
    private ModifyDemoMapper modifyDemoMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));

        List<ModifyDemo> userList = modifyDemoMapper.selectList(null);

        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}
