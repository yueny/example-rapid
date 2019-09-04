package com.yueny.example.rapid.strategy.service;

import com.yueny.rapid.data.resp.pojo.response.NormalResponse;
import com.yueny.superclub.util.strategy.IStrategy;


/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-09-04 15:02
 */
public interface IRespStrategy extends IStrategy<RespType> {
    /**
     *
     */
    NormalResponse<RespType> builder();
}
