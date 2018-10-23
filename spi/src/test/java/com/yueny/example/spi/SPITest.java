package com.yueny.example.spi;

import org.junit.Test;

/**
 * Created by yueny on 2018/10/23 0023.
 */
public class SPITest {
    @Test
    public void test(){
        System.out.println(WatchServiceConfigLoader.get().getClass().getCanonicalName());
        System.out.println("EmailFields: " + WatchServiceConfigLoader.get().getEmailFields());
        System.out.println();
    }

}
