package com.sunshine.hanlp.test;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Other.AhoCorasickDoubleArrayTrieSegment;
import com.hankcs.hanlp.seg.Other.DoubleArrayTrieSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author: hj
 * @date: 21-8-17 下午5:37
 */
public class SegWordTest {

    String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";

    Segment segment;

    @Before
    public void init(){
        HanLP.Config.ShowTermNature = false;
    }


    @Test
    public void testSeg(){
        HanLP.Config.enableDebug();
        List<Term> terms = HanLP.segment("我是中国人");
        terms.stream().forEach(System.out::println);
    }

    @Test
    public void testDAT(){
        segment = new DoubleArrayTrieSegment();
        List<Term> terms = segment.seg(text);
        terms.forEach(t -> System.out.println(t.word));
    }

    @Test
    public void testACDAT() throws IOException {
        setSomeConf();
        segment = new AhoCorasickDoubleArrayTrieSegment();
        List<Term> terms = segment.seg(text);
        terms.forEach(t -> System.out.println(t.word));
    }

    private void setSomeConf(){
        if (segment != null){
            segment.enablePartOfSpeechTagging(true);
        }
    }
}