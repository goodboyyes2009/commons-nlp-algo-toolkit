package com.sunshine.seg;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Other.AhoCorasickDoubleArrayTrieSegment;
import com.hankcs.hanlp.seg.Other.DoubleArrayTrieSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;

/**
 * @author: hj
 * @date: 21-8-20 下午4:13
 */
@Setter
@Getter
public class HanLPSegmenter extends BaseSegmenter {
    private Segment segment;
    public boolean dat = true;

    public HanLPSegmenter() {
        HanLP.Config.ShowTermNature = false;
    }

    public void initSegmenter() {
        if (dat) {
            segment = new DoubleArrayTrieSegment();
        } else {
            try {
                segment = new AhoCorasickDoubleArrayTrieSegment();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (segment != null) {
            segment.enablePartOfSpeechTagging(true);
        }
    }


    @Override
    public void loadCustomDict(String path) {
        try {
            if (dat) {
                segment = new DoubleArrayTrieSegment(path);
            } else {
                segment = new AhoCorasickDoubleArrayTrieSegment(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected List<Object> doSegWord(String line) {
        if (line == null || line.trim().equals("")) {
            return null;
        }
        return (List) segment.seg(line);
    }

    @Override
    protected String transSegWordResult(Object o) {
        if (o == null) {
            return null;
        } else {
            return ((Term) o).word;
        }
    }
}