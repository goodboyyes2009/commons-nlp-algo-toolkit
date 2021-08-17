package com.sunshine.hanlp.test;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import org.junit.Test;

import java.util.List;

/**
 * @author: hj
 * @date: 21-8-17 下午5:37
 */
public class TestSeg {

    @Test
    public void testSeg(){
        List<Term> terms = HanLP.segment("我是中国人");
        terms.stream().forEach(System.out::println);
    }
}