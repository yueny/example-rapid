package com.yueny.example.proxy.entry;

import lombok.Data;

import java.sql.Date;

/**
 * Created by yueny on 2018/9/25 0025.
 */
@Data
public class ModifyDemo {
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
