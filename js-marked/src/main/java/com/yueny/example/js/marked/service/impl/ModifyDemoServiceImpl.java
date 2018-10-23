package com.yueny.example.js.marked.service.impl;

import com.google.common.collect.Lists;
import com.yueny.example.js.marked.bo.ModifyDemoBo;
import com.yueny.example.js.marked.service.IModifyDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * Created by yueny on 2018/9/25 0025.
 */
@Service
@Slf4j
public class ModifyDemoServiceImpl extends BaseService implements IModifyDemoService {
    public String getDemoData(){
        String data = "";

        // 读文件
        InputStream in = null;
        try {
            // 通过类加载器进行获取properties文件流
            in = ModifyDemoServiceImpl.class.getClassLoader().getResourceAsStream("md/readme.md");

            // size 为字串的长度 ，这里一次性读完
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);

            data = new String(buffer, "utf-8");
        } catch (Exception e) {
            log.error("出现 Exception", e);
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (Exception e) {
                log.error("文件流关闭出现异常", e);
            }
        }

        return data;
    }

    public List<ModifyDemoBo> queryAll(){
        ModifyDemoBo bo1 = new ModifyDemoBo();
        bo1.setName("ModifyDemoBo");
        bo1.setDesc("bo1 DESC");

        List<ModifyDemoBo> entrys = Lists.newArrayList(bo1);

        return entrys;
    }

}
