package com.yueny.example.rapid.strategy.container;

import com.yueny.example.rapid.strategy.service.IRespStrategy;
import com.yueny.example.rapid.strategy.service.RespType;
import com.yueny.superclub.util.strategy.container.StrategyContainerImpl;
import org.springframework.stereotype.Service;

/**
 * 第二种容器实现
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-09-04 15:12
 */
@Service
public class Resp2Container extends StrategyContainerImpl<RespType, IRespStrategy> implements IRespContainer {
//    private IStrategyContainer<RespType, IRespStrategy> strategyContainer
//            = new StrategyContainerImpl<RespType, IRespStrategy>() {
//    };
//
//    @Override
//    public IRespStrategy getStrategy(RespType type) {
//        if (type == null) {
//            return null;
//        }
//
//        IRespStrategy strategy = super.getStrategy(type);
//        if (strategy == null) {
//            return null;
//        }
//
//        return strategy;
//    }
}
