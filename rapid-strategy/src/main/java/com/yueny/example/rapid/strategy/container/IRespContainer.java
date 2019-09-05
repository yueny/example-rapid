package com.yueny.example.rapid.strategy.container;

import com.yueny.example.rapid.strategy.service.IRespStrategy;
import com.yueny.example.rapid.strategy.service.RespType;
import com.yueny.superclub.util.strategy.container.IStrategyContainer;

/**
 * 第三种容器实现
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-09-04 15:11
 */
public interface IRespContainer extends IStrategyContainer<RespType, IRespStrategy> {
    //.
}
