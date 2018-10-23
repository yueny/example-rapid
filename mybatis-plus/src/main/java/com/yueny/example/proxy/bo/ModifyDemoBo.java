package com.yueny.example.proxy.bo;

import com.yueny.superclub.api.pojo.instance.AbstractBo;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * Created by yueny on 2018/9/25 0025.
 */
@Getter
@Setter
public class ModifyDemoBo extends AbstractBo {
    private Long id;
    private String name;
    private String desc;
    private String type;
    private String eventData;

    private Integer version;
    private String modifyUser;
    private Date createTime;
    private Date updateTime;

}
