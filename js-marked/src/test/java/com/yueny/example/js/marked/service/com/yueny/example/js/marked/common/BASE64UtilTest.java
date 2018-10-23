package com.yueny.example.js.marked.service.com.yueny.example.js.marked.common;

import com.yueny.superclub.util.crypt.core.Base64Coder;
import org.junit.Assert;
import org.junit.Test;

/**
* Created by yueny on 2018/10/13 0013.
*/
public class BASE64UtilTest {
    @Test
    public void testDecode(){
        String val = Base64Coder.decryptVal("KDMpcGVlcnMtJmd0O251bWJlcu+8muWQjuerr+acjeWKoeWZqOeahOS4quaVsA==");
        Assert.assertEquals("(3)peers-&gt;number：后端服务器的个数", val);
    }

}
