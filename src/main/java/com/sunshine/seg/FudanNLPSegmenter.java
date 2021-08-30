package com.sunshine.seg;

import org.fnlp.nlp.cn.CNFactory;
import org.fnlp.util.exception.LoadModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author: hj
 * @date: 21-8-20 下午4:13
 */
public class FudanNLPSegmenter extends BaseSegmenter {
    private static final Logger logger = LoggerFactory.getLogger(FudanNLPSegmenter.class);

    private CNFactory cnFactory;

    public FudanNLPSegmenter() {
        try {
            cnFactory = CNFactory.getInstance("models");
        } catch (LoadModelException e) {
            logger.error("初始化 FudanNLP Segmenter失败");
        }
    }


    @Override
    public void loadCustomDict(String path) throws Exception {
        cnFactory.loadDict(path);
    }


    @Override
    protected String transSegWordResult(Object o) {
        return o == null ? null : (String) o;
    }

    @Override
    protected List<Object> doSegWord(String text) {
        if (text != null && !text.trim().equals("")) {
            try {
                String[] seg = cnFactory.seg(text);
                return Arrays.asList(seg);
            } catch (Exception e) {
                logger.error("text: " + text);
                logger.error(e.getMessage(), e);
            }
        }
        return null;
    }
}
