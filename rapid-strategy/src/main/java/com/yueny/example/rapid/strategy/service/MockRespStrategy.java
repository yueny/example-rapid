package com.yueny.example.rapid.strategy.service;

import com.yueny.rapid.data.resp.pojo.response.NormalResponse;
import org.springframework.stereotype.Service;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-09-04 15:08
 */
@Service
public class MockRespStrategy implements IRespStrategy {
    @Override
    public NormalResponse<RespType> builder() {
        NormalResponse<RespType> response = new NormalResponse<>();
        response.setData(getCondition());

        return response;
    }

    @Override
    public RespType getCondition() {
        return RespType.MOCK;
    }
}
