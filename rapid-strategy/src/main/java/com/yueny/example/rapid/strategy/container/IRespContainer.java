package com.yueny.example.rapid.strategy.container;

import com.yueny.example.rapid.strategy.service.IRespStrategy;
import com.yueny.example.rapid.strategy.service.RespType;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-09-04 15:11
 */
public interface IRespContainer {

    IRespStrategy getStrategy(RespType type);

}
