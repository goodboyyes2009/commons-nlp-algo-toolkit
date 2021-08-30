package com.sunshine.seg;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: hj
 * @date: 21-8-26 上午9:45
 */
public class SegWordFactory {

    public static final List<Class<? extends BaseSegmenter>> classList = ImmutableList.of(FudanNLPSegmenter.class, HanLPSegmenter.class, JieBaSegmenter.class);


    public static BaseSegmenter createSegmenter(Class<? extends BaseSegmenter> clzz) {
        if (clzz.getName().equals(FudanNLPSegmenter.class.getName())) {
            return new FudanNLPSegmenter();
        } else if (clzz.getName().equals(HanLPSegmenter.class.getName())) {
            HanLPSegmenter hanLPSegmenter = new HanLPSegmenter();
            hanLPSegmenter.initSegmenter();
            return hanLPSegmenter;
        } else if (clzz.getName().equals(JieBaSegmenter.class.getName())) {
            return new JieBaSegmenter();
        } else {
            return null;
        }
    }

    /**
     * 返回所有的分词器
     *
     * @return
     */
    public static List<BaseSegmenter> createAllSegmenters() {
        return classList.stream().map(c -> createSegmenter(c)).collect(Collectors.toList());
    }
}