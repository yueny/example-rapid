package com.yueny.example.spi.spi;

import java.util.List;
import java.util.Set;

/**
 * 配置中心实现
 */
public interface IWatchServiceConfiguration {

    public Set<String> getEmailFields();

    public Set<String> getMaskFields();

}
