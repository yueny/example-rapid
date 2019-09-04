package com.yueny.example.rapid.strategy.service;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-09-04 15:01
 */
public enum RespType {
    /**
     * HTTP
     */
    HTTP,
    /**
     * mock
     */
    MOCK,
    /**
     * DUBBO
     */
    DUBBO;

    public static RespType getType(String type)
    {
        for (RespType respType : RespType.values())
        {
            if(StringUtils.endsWithIgnoreCase(respType.name(), type)){
                return respType;
            }
        }

        return null;
    }
}
