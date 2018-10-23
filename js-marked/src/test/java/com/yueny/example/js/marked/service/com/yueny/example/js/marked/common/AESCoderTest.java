//package com.yueny.example.js.marked.service.com.yueny.example.js.marked.common;
//
//import com.yueny.example.js.marked.common.AESCoder;
//import org.junit.Assert;
//import org.junit.Test;
//
///**
//* Created by yueny on 2018/10/13 0013.
//*/
//public class AESCoderTest {
//    private static final String KEY = "abcdefgabcdefg12";
//
//    @Test
//    public void testDecode(){
//        String content = "nginx做为方向代理时，能够为后端服务器提供负载均衡的功能，其中加权轮询策略使是其默认的负载均衡策略。\n" +
//                " ![](http://static.yueny.site/blog/uploads/yuanyang/image/20160924/20160924131235_807.png)\n" +
//                "\n" +
//                "直观上就是将来自客户的请求按照每个服务器的权值进行负载均衡（权值大的服务器处理的请求也应该多）。那么对于每次客户的请求如何选取后端服务器才能确保这种均衡呢？nginx采用加权轮询策略时选取后端服务器的核心代码是ngx_http_upstream_get_peer函数(位于ngx_http_upstream_round_robin.c中)。下面对这段代码进行分析。\n" +
//                "\n" +
//                "代码说明\n" +
//                "```\n" +
//                "(1)peer[n].weight：后端服务器初始权重。\n" +
//                "(2)peer[n].current_weight：后端服务器当前权重，初始情况等于peer[n].weight\n" +
//                "(3)peers-&gt;number：后端服务器的个数\n" +
//                "(4)peers-&gt;peer[0]：一个数组的第一个元素，这个数组的每个元素对应一个后端服务器。\n" +
//                "(5)一旦某个后端服务器n被选中后，会在其他处理函数中执行peer[n].current_weight–。\n" +
//                "(6)代码18行乘以1000是为了避免浮点处理，所以直接报被除数放大1000倍，也就是间接把精度提升到小数点后三位，注意这里是权值的比较，因此把两边权值都放大1000倍并不会影响最终的比较结果\n" +
//                "```\n" +
//                "\n" +
//                "```\n" +
//                "static ngx_uint_t ngx_http_upstream_get_peer(ngx_http_upstream_rr_peers_t *peers)\n" +
//                "{\n" +
//                "ngx_uint_t i, n, reset = 0;\n" +
//                "ngx_http_upstream_rr_peer_t *peer;\n" +
//                "peer = &amp;peers-&gt;peer[0]; //peer指向后端服务器列表\n" +
//                "\n" +
//                "for ( ;; ) {\n" +
//                "for (i = 0; i &lt; peers-&gt;number; i++) {\n" +
//                "if (peer[i].current_weight &lt;= 0) {\n" +
//                "continue;\n" +
//                "}\n" +
//                "n = i; //n为第一个current_weight大于0的服务器下标\n" +
//                "while (i &lt; peers-&gt;number - 1) {\n" +
//                "i++; //i从n的下一个服务器开始遍历\n" +
//                "if (peer[i].current_weight &lt;= 0) {\n" +
//                "continue;\n" +
//                "}\n" +
//                "if (peer[n].current_weight * 1000 / peer[i].current_weight\n" +
//                "&gt; peer[n].weight * 1000 / peer[i].weight) //选取后端服务器的关键\n" +
//                "{\n" +
//                "return n;\n" +
//                "}\n" +
//                "n = i;\n" +
//                "}\n" +
//                "if (peer[i].current_weight &gt; 0) {\n" +
//                "n = i;\n" +
//                "}\n" +
//                "return n;\n" +
//                "}\n" +
//                "if (reset++) { //初始为0，所以第二次循环到此条件才成立，注意是后置自增。\n" +
//                "return 0;\n" +
//                "}\n" +
//                "for (i = 0; i &lt; peers-&gt;number; i++) {\n" +
//                "peer[i].current_weight = peer[i].weight;\n" +
//                "}\n" +
//                "}\n" +
//                "}\n" +
//                "```\n" +
//                "\n" +
//                "分析\n" +
//                "18~19行代码是选取后端服务器的关键，那么这个条件是如何确保选取后端服务器负载均衡呢？\n" +
//                "假设有三台后端服务器A、B、C，它们的权值分别为5、3、1。那么执行过程如下：\n" +
//                "* (1) 第一次请求由于peer[n].current_weight= peer[n].weight&amp;&amp;peer[i].current_weight= peer[i].weight，所以代码18行的条件始终不成立。13行的while循环到i=2时退出。接着执行到25代码行条件成立，n=i=2，所以第一次选中服务器C，之后服务器C的current_weight–,当前权值变为0.\n" +
//                "* (2) 第二次请求到来时，A、B、C的权值为5、3、0。代码执行到14行时，i=1，n=0，此时由于A和B的current_weight和weight相同，条件依然不成立，23行使n=i=1，然后i++变为2，但代码15行条件成立(C的current_weight为0),继续循环到13行代码不成立。此时跳出13行的while循环，执行到18行返回n=1，即选择服务器B。\n" +
//                "* (3)第三次请求到达时，A、B、C的权值为5、2、0。执行到代码14行时n=0，i=1，随后18行条件成立（peer[n].current_weight=5，peer[i].current_weight=2，peer[n].weight=5，peer[i].weight=3）,所以19行返回n=0，即选中服务器A。\n" +
//                "* (4)……\n" +
//                "* (5)随后请求处理类似，知道所有服务器current_weight都等于0。此时第8行的for循环跳出，执行第30行条件不成立，执行33行，再次将current_weight重置为初始值。\n" +
//                "这样一个过程确保链接的处理按照服务器配置的权重来均衡。\n" +
//                "\n" +
//                "注意\n" +
//                "可以看出nginx每次选出的服务器并不一定是当前权重(处理能力)最大的，如上分析第一次请求选取的并不是服务器A，而是C，但就总体效果而言如果请求数量足够多最终可以实现让客户的请求在整体上根据服务器的权值在各个服务器上按照对应比例分布。\n" +
//                "\n" +
//                "应用\n" +
//                "应用这个负载均衡逻辑就可以实现对客户端的请求按照服务器的处理能力(权重)进行负载均衡了。";
//
//        System.out.println("加密前：" + content);
//        System.out.println("加密密钥和解密密钥：" + KEY);
//
//        String encrypt = AESCoder.encrypt(content, KEY);
//        System.out.println(encrypt.length()+":加密后：" + encrypt);
//
//        String decrypt = AESCoder.decrypt("kLYnrDM5Y5x4QCRw+VW5o+X1UfQm9xY+tHY1vxka9Uxt7NdqLkxD/JOcbyKi0atpVBVQHGKYrboywREqogse83klHwrQcx5J0ZvshpsV4appBxdkLlHvatoCnP0vkyXGkveoPrx+/Ua88Jn9MeMLHR7t7FkMpN6Ggh3jo/FSQHITtJmORzBHTozsjFFULRoWEFlQToDUUskGYYRiV7h7ILCQeB88u2hoc+NApBEVSY/HphW1ANaWo4y2N1noD8ipa70aaSRmJOlwj8hiimYdjNV02IrNXRU/RQd2jrBJjoNZCS/QFkQ7Xx8y9SCrR6LKY9NPSKEJM5+2s5YRMyhZVFR6GdT7h0MkhIdsRMUA/+zy79fJGEMZWxiSfQ82k6hvLS7Plv7uX3KfvWkX2OGW+yrio4vuTsSckhVLiVpWPl22RP6db/YVAUcpImEAi142kSzja30QOFqSu3jASksIGvn6Sx37On/2hx50J7Na+2eVp1q10WxP1uBts4f46uDaUtHgm4MIXqs3yyimntatVP5emQNPk7GsxCvb8PaeKO6mfbNoYOgBPEag8i1rTrDVMfMC307kAj1L0QIDRWOQllrrSNERLqxlXiILdbcSIfTodBAj0ZCY8n+roRjbwUzIfqvLZLasrfWcORjWYpd7s2G6VZoC6rJZwv50/oi5vEpQ6xXL86SB571gaQA6V1vGM8Lm2iYyT7JQobwKhH5Ejj7TEmUFa7ZqlfQ2P6qy5QpWCtSBBcTQwJgolmBNmyO2hCPVbOzTFcGdO3VQSXabMsl2qwslTJRMM4I6olJ9a7hrRWVvFECq4nbL4NYMd+NH", "abcdefgabcdefg12");
//        System.out.println("解密后：" + decrypt);
//    }
//
//}
