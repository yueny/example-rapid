package com.yueny.example.proxy.service.impl;

import com.yueny.example.proxy.bo.ModifyDemoBo;
import com.yueny.example.proxy.entry.ModifyDemo;
import com.yueny.example.proxy.mapper.ModifyDemoMapper;
import com.yueny.example.proxy.service.IModifyDemoService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by yueny on 2018/9/25 0025.
 */
@Service
public class ModifyDemoServiceImpl extends BaseService implements IModifyDemoService {
    @Autowired
    private ModifyDemoMapper modifyDemoMapper;

    public ModifyDemoBo queryByUserId(Long userId){
        return null;
    }

    public List<ModifyDemoBo> queryAll(){
        List<ModifyDemo> entrys = modifyDemoMapper.selectList(null);

        if(CollectionUtils.isEmpty(entrys)){
            return Collections.emptyList();
        }

        List<ModifyDemoBo> userList = map(entrys, ModifyDemoBo.class);
        return userList;
    }

}
