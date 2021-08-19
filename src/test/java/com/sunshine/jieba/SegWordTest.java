package com.sunshine.jieba;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import org.junit.Test;

import java.util.List;

/**
 * @author: hj
 * @date: 21-8-19 上午10:24
 */
public class SegWordTest {

    String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";

    @Test
    public void testSeg() {
        System.out.println("======================= Full Mode =========================");
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<String> strings = segmenter.sentenceProcess(text);
        strings.forEach(System.out::println);
    }
    
    @Test
    public void testSegIndexMode(){
        System.out.println("======================= Index Mode =========================");
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<SegToken> process = segmenter.process(text, JiebaSegmenter.SegMode.INDEX);
        process.stream().forEach(System.out::println);
    }

    @Test
    public void testSegSearchMode(){
        System.out.println("======================= Search Mode =========================");
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<SegToken> process = segmenter.process(text, JiebaSegmenter.SegMode.SEARCH);
        process.stream().forEach(System.out::println);
    }

}
