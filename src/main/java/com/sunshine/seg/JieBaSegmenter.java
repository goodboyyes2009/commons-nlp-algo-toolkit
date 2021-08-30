package com.sunshine.seg;

import com.huaban.analysis.jieba.JiebaSegmenter;

import java.nio.file.Paths;
import java.util.List;

/**
 * @author: hj
 * @date: 21-8-20 下午4:14
 */
public class JieBaSegmenter extends BaseSegmenter {
    JiebaSegmenter segmenter;

    public JieBaSegmenter() {
        segmenter = new JiebaSegmenter();
    }


    @Override
    public void loadCustomDict(String path) {
        segmenter.initUserDict(Paths.get(path));
    }


    @Override
    protected List<Object> doSegWord(String text) {
        if (text == null || text.trim().equals("")) {
            return null;
        }
        return (List) segmenter.sentenceProcess(text);
    }

    @Override
    protected String transSegWordResult(Object o) {
        if (o == null) {
            return null;
        }
        return (String) o;
    }
}