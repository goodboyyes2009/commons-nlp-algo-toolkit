package com.sunshine.fnlp;

import com.sunshine.seg.BaseSegmenter;
import com.sunshine.seg.FudanNLPSegmenter;
import com.sunshine.seg.HanLPSegmenter;
import com.sunshine.seg.JieBaSegmenter;
import org.fnlp.nlp.cn.CNFactory;
import org.fnlp.util.exception.LoadModelException;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: hj
 * @date: 21-8-19 上午9:47
 */
public class SegWordTest {
    String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";
    CNFactory factory;

    @Before
    public void init() throws LoadModelException {
        String dictPath = "/home/hj/datastory/programs/commons-nlp-algo-toolkit/src/main/resources/msr_training_words.dict";
        factory = CNFactory.getInstance("models", CNFactory.Models.SEG);
        factory.loadDict(dictPath);
    }


    @Test
    public void testSeg() throws LoadModelException {
        String[] seg = factory.seg(text);
        Arrays.stream(seg).forEach(System.out::println);
    }

    // @Test
    // public void segMSR() throws IOException {
    //     String path = "/home/hj/data/nlp/icwb2-data/testing/msr_test.utf8";
    //     File file = new File(path);
    //     BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
    //     String line;
    //     String outDir = "/home/hj/data/nlp/seg-dict-test";
    //
    //     List<BaseSegmenter> segmenters = new ArrayList<>();
    //     BaseSegmenter.outDir = outDir;
    //
    //     FudanNLPSegmenter fudanNLPSegmenter = new FudanNLPSegmenter();
    //     fudanNLPSegmenter.setFileName("fnlp-msr-seg.txt");
    //     fudanNLPSegmenter.setDictPath(path);
    //     fudanNLPSegmenter.setPrintWriter(new PrintWriter(fudanNLPSegmenter.getPath(), "UTF-8"));
    //
    //     HanLPSegmenter hanLPSegmenter = new HanLPSegmenter();
    //     hanLPSegmenter.setFileName("han-dat-msr-seg.txt");
    //     hanLPSegmenter.setDictPath(path);
    //     hanLPSegmenter.setPrintWriter(new PrintWriter(hanLPSegmenter.getPath(), "UTF-8"));
    //
    //     JieBaSegmenter jieBaSegmenter = new JieBaSegmenter();
    //     jieBaSegmenter.setFileName("jieba-msr-seg.txt");
    //     jieBaSegmenter.setDictPath("");
    //     jieBaSegmenter.setPrintWriter(new PrintWriter(jieBaSegmenter.getPath(), "UTF-8"));
    //
    //     segmenters.add(hanLPSegmenter);
    //     segmenters.add(fudanNLPSegmenter);
    //     segmenters.add(jieBaSegmenter);
    //
    //     while ((line = reader.readLine()) != null) {
    //         for (BaseSegmenter segmenter : segmenters) {
    //             List<String> token = segmenter.segFun(line);
    //             String newLine = String.join(" ", token);
    //             segmenter.outAppender(newLine);
    //         }
    //     }
    //     for (BaseSegmenter segmenter : segmenters) {
    //         segmenter.getPrintWriter().flush();
    //         segmenter.getPrintWriter().close();
    //     }
    // }
    //
    // @Test
    // public void segPUK() throws IOException {
    //     String path = "/home/hj/data/nlp/icwb2-data/testing/pku_test.utf8";
    //     File file = new File(path);
    //     BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
    //     String line;
    //     String outDir = "/home/hj/data/nlp/seg-dict-test";
    //
    //     List<BaseSegmenter> segmenters = new ArrayList<>();
    //     BaseSegmenter.outDir = outDir;
    //
    //     FudanNLPSegmenter fudanNLPSegmenter = new FudanNLPSegmenter();
    //     fudanNLPSegmenter.setFileName("fnlp-pku-seg.txt");
    //     fudanNLPSegmenter.setPrintWriter(new PrintWriter(fudanNLPSegmenter.getPath(), "UTF-8"));
    //
    //     HanLPSegmenter hanLPSegmenter = new HanLPSegmenter();
    //     hanLPSegmenter.setFileName("han-dat-pku-seg.txt");
    //     hanLPSegmenter.setPrintWriter(new PrintWriter(hanLPSegmenter.getPath(), "UTF-8"));
    //
    //     JieBaSegmenter jieBaSegmenter = new JieBaSegmenter();
    //     jieBaSegmenter.setFileName("jieba-pku-seg.txt");
    //     jieBaSegmenter.setPrintWriter(new PrintWriter(jieBaSegmenter.getPath(), "UTF-8"));
    //
    //     segmenters.add(hanLPSegmenter);
    //     segmenters.add(fudanNLPSegmenter);
    //     segmenters.add(jieBaSegmenter);
    //
    //     while ((line = reader.readLine()) != null) {
    //         for (BaseSegmenter segmenter : segmenters) {
    //             List<String> token = segmenter.segFun(line);
    //             String newLine = String.join(" ", token);
    //             segmenter.outAppender(newLine);
    //         }
    //     }
    //     for (BaseSegmenter segmenter : segmenters) {
    //         segmenter.getPrintWriter().flush();
    //         segmenter.getPrintWriter().close();
    //     }
    // }

    @Test
    public void evaluateSpeed(){
        FudanNLPSegmenter fudanNLPSegmenter = new FudanNLPSegmenter();
        fudanNLPSegmenter.evaluateSpeed();
    }
}
