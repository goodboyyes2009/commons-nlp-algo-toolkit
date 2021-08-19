package com.sunshine.fnlp;

import org.fnlp.nlp.cn.CNFactory;
import org.fnlp.util.exception.LoadModelException;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: hj
 * @date: 21-8-19 上午9:47
 */
public class SegWordTest {
    String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";

    @Test
    public void testSeg() throws LoadModelException {
        CNFactory factory = CNFactory.getInstance("models");

        String[] seg = factory.seg(text);
        Arrays.stream(seg).forEach(System.out::println);
    }
}
