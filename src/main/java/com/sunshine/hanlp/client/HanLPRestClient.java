package com.sunshine.hanlp.client;

import com.alibaba.fastjson.JSON;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.restful.HanLPClient;
import com.hankcs.hanlp.seg.common.Term;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * HanLPClient 类
 *
 * @author: hj
 * @date: 21-8-17 上午11:23
 */
public class HanLPRestClient {
    public static void main(String[] args) throws IOException {
        HanLPClient client = new HanLPClient("https://www.hanlp.com/api", null, "zh", 30);
        Map<String, List> map = client.parse("如果按照上面这种方式如何获取呢");
        map.forEach((k,v) -> {
            System.out.println("k->" + k +", v->" + JSON.toJSONString(v));
        });
        List<Term> terms = HanLP.segment("我是中国人");
        terms.stream().forEach(System.out::println);
    }
}
