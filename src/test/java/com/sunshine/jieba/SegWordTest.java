package com.sunshine.jieba;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.sunshine.seg.JieBaSegmenter;
import com.sunshine.seg.SegWordFactory;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

/**
 * @author: hj
 * @date: 21-8-19 上午10:24
 */
public class SegWordTest {

    String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";
    JiebaSegmenter segmenter;
    String dictPath = "/home/hj/datastory/programs/commons-nlp-algo-toolkit/src/main/resources";

    @Before
    public void init() {
        this.segmenter = new JiebaSegmenter();
        this.segmenter.initUserDict(Paths.get(dictPath));
    }

    @Test
    public void testSeg() {
        System.out.println("======================= Full Mode =========================");
        List<String> strings = segmenter.sentenceProcess(text);
        strings.forEach(System.out::println);
    }

    @Test
    public void testSegIndexMode() {
        System.out.println("======================= Index Mode =========================");
        List<SegToken> process = segmenter.process(text, JiebaSegmenter.SegMode.INDEX);
        process.stream().forEach(System.out::println);
    }

    @Test
    public void testSegSearchMode() {
        System.out.println("======================= Search Mode =========================");
        List<SegToken> process = segmenter.process(text, JiebaSegmenter.SegMode.SEARCH);
        process.stream().forEach(System.out::println);
    }

    @Test
    public void testSegWord(){
        JieBaSegmenter segmenter = (JieBaSegmenter)SegWordFactory.createSegmenter(JieBaSegmenter.class);
        segmenter.segWord(text).stream().forEach(System.out::println);
    }
}
