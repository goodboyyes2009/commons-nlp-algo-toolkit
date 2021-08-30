package com.sunshine.hanlp.test;

import com.sunshine.seg.HanLPSegmenter;
import com.sunshine.seg.SegWordFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author: hj
 * @date: 21-8-17 下午5:37
 */
public class SegWordTest {

    String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";
    HanLPSegmenter segmenter;
    String dictPath = "/home/hj/data/nlp/icwb2-data/gold/pku_training_words.utf8";

    @Before
    public void init() {
        segmenter = (HanLPSegmenter) SegWordFactory.createSegmenter(HanLPSegmenter.class);
    }


    @Test
    public void testSeg() {
        List<String> strings = segmenter.segWord(text);
        strings.stream().forEach(System.out::println);
    }

    @Test
    public void testDAT() {
        segmenter.loadCustomDict(dictPath);
        List<String> segWords = segmenter.segWord(text);
        segWords.stream().forEach(System.out::println);
    }

    @Test
    public void testACDAT() {
        segmenter.dat = false;
        segmenter.initSegmenter();
        List<String> strings = segmenter.segWord(text);
        strings.stream().forEach(System.out::println);
    }
}