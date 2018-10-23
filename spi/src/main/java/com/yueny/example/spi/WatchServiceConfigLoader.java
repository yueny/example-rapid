package com.yueny.example.spi;

import java.util.ServiceLoader;

import com.yueny.example.spi.internals.ApolloWatchServiceConfiguration;
import com.yueny.example.spi.spi.IWatchServiceConfiguration;
import lombok.extern.slf4j.Slf4j;

/**
 * spi 加载
 */
@Slf4j
public class WatchServiceConfigLoader {
    private static Object oject = new Object();
    private static IWatchServiceConfiguration watchServiceConfiguration;

    public static IWatchServiceConfiguration get(){
        if(watchServiceConfiguration == null){
            synchronized (oject){
                if(watchServiceConfiguration == null){
                    watchServiceConfiguration = getInternals();
                    
                    log.debug("初始化 IWatchServiceConfiguration, 初始化实例对象：{}.", watchServiceConfiguration.getClass().getCanonicalName());
                }
            }
        }

        return watchServiceConfiguration;
    }

    private static IWatchServiceConfiguration getInternals(){
        ServiceLoader<IWatchServiceConfiguration> loaders = ServiceLoader
                .load(IWatchServiceConfiguration.class);

        IWatchServiceConfiguration watchServiceConfiguration = null;
        // 优先选择自定义spi实现
        for (IWatchServiceConfiguration in : loaders) {
            if(!(in instanceof ApolloWatchServiceConfiguration)){
                watchServiceConfiguration = in;
                break;
            }
        }

        // 如果没有自定义spi, 则采用默认
        if(watchServiceConfiguration == null){
            for (IWatchServiceConfiguration in : loaders) {
                if(in instanceof ApolloWatchServiceConfiguration){
                    watchServiceConfiguration = in;
                    break;
                }
            }
        }

        return watchServiceConfiguration;
    }

}
